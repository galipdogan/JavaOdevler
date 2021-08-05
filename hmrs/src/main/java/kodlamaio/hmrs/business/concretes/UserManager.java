package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.core.abstracts.EmailSenderService;
import kodlamaio.hmrs.core.abstracts.VerificationService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.validation.userValidation.UserValidationService;
import kodlamaio.hmrs.dataAccess.abstracts.UserDao;
import kodlamaio.hmrs.entities.concretes.User;


@Service
public class UserManager implements UserService {

	private UserDao userDao;
	private UserValidationService userValidationService;
	private VerificationService verificationService;
	private EmailSenderService emailSenderService;

	@Autowired
	public UserManager(UserValidationService userValidationService,
			VerificationService verificationService, EmailSenderService emailSenderService, UserDao userDao) {
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
		if (!userValidationService.isValid(user).isSuccess()) {
			return new ErrorResult("Not a valid user.");

//		}else if(this.userDao.findByEmail(user.getEmail())) {
//			return new ErrorResult("The Mail adress already have");
		}
		
		String token = UUID.randomUUID().toString();
		emailSenderService.send(user.getEmail(), token);
		System.out.println(user.getEmail() + token);
		this.userDao.save(user);
		return new SuccessDataResult<User>("User added"+token);
		

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
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email), "Found user");
	}


}
