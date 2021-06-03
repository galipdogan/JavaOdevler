package kodlamaio.hmrs.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.core.abstracts.EmailSenderService;
import kodlamaio.hmrs.core.abstracts.VerificationService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.validation.UserValidate.UserValidationService;
import kodlamaio.hmrs.dataAccess.abstracts.UserDao;
import kodlamaio.hmrs.entities.concretes.User;


@Service
public class UserManager implements UserService {

	private UserDao userDao;
	private UserValidationService userValidationService;
	private VerificationService verificationService;
	private EmailSenderService emailSenderService;

	@Autowired
	public UserManager(UserDao userdao, UserValidationService userValidationService,
			VerificationService verificationService, EmailSenderService emailSenderService) {
		super();
		this.userDao = userDao;
		this.userValidationService = userValidationService;
		this.verificationService = verificationService;
		this.emailSenderService = emailSenderService;
	}

	@Override
	public DataResult<List<User>> getAll() {

		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "User listed");
	}

	@Override
	public Result add(User user) {
		if (!isValidEmail(user.getEmail())) {
			return new ErrorResult("Not a valid mail adress.");

		}else if(this.userDao.findByEmail(user.getEmail()).isSuccess()) {
			return new ErrorResult("The Mail adress already have");
		}
		String token = UUID.randomUUID().toString();
		emailSenderService.send(user.getEmail(), token);					
		return new SuccessDataResult<User>(this.userDao.save(user), "User added");
		

	}

	@Override
	public Result delete(User user) {

		return null;// new SuccessDataResult<User>(this.userdao.delete(user),"User deleted");
	}

	@Override
	public Result update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<User> getByEmail(String email) {

		return new SuccessDataResult(this.userDao.findByEmail(email),"Found");
	}
//	
//	public boolean isValid(User user) {
//		if (!isValidEmail(user.getEmail())) {
//			System.out.println("Wrong mail format. Please check mail.");
//			return false;
//			return new ErrorResult("Wrong mail format. Please check mail.");
//		
//		}else if(!userDao.findByEmail(user.getEmail()).isEmpty()){
//			System.out.println("This mail adress already taken");
//			return false;
//			return  new ErrorResult("This mail adress already has been taken");			
//		
//		}else if(!isValidPassword(user.getPassword())) {
//			return new ErrorResult
//			System.out.println("Password is null or not min 6 character.");
//			return false;
//		}
//		return true;
//				new SuccessResult();
//		
//	}
//	
	public boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
//	
//	public boolean isValidPassword(String password) {
//		if (password == null || password.length() < 6) {
//			return false;
//		}
//
//		return true;
//	}


}
