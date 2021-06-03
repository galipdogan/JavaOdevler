package kodlamaio.hmrs.core.utilities.validation.UserValidate;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.el.stream.Stream;

import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.UserDao;
import kodlamaio.hmrs.entities.concretes.User;

@Service
public class UserValidationManager implements UserValidationService{
	
	
	private UserDao userDao;
	@Autowired
	public UserValidationManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result isValid(User user) {
		if (!isValidEmail(user.getEmail())) {
			System.out.println("Wrong mail format. Please check mail.");
			//return false;
			return new ErrorResult("Wrong mail format. Please check mail.");
		
		}else if(this.userDao.findByEmail(user.getEmail()).isSuccess()){
			System.out.println("This mail adress already taken");
			//return false;
			return  new ErrorResult("This mail adress already has been taken");			
		
		}else if(!isValidPassword(user.getPassword())) {
			//System.out.println("Password is null or not min 6 character.");
			return new ErrorResult("Password is null or not min 6 character.");
		}
		return new SuccessResult();
		
	}
	
	public boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
	
	public boolean isValidPassword(String password) {
		if (password == null || password.length() < 6) {
			return false;
		}
		return true;
	}
	

//	public boolean userExists(String email) {
//		if (userDao.findByEmail(email).equals(email)) {
//			return true;
//		} else {
//			return false;		}
//
//	}
}
