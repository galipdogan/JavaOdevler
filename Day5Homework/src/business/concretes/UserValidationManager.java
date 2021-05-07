package business.concretes;

import java.util.regex.Pattern;

import dataAccess.abstracts.UserDao;
import entities.business.User;

public class UserValidationManager implements business.abstracts.UserValidationService {

	private UserDao userDao;

	public UserValidationManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public boolean isValidString(String name) {

		if (name == null || name.length() < 2) {
			return false;
		}

		return true;
	}

	public boolean isValidPassword(String password) {
		if (password == null || password.length() < 6) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isValid(User user) {
		if (!isValidEmail(user.getEmail())) {
			System.out.println("Yanlýþ email formatý. lütfen kontrol edin.");
			return false;

		}

		if (!isValidString(user.getFirstName())) {
			System.out.println("Lütfen en az 2 karakter giriniz");
			return false;

		}
		if (!isValidString(user.getLastName())) {
			System.out.println("Lütfen en az 2 karakter giriniz");
			return false;

		}
		if (!isValidPassword(user.getPassword())) {
			System.out.println("Lütfen en az 6 karakter giriniz");
			return false;

		}
		return true;

	}
	
	@Override
	public boolean userExists(String email) {
		
		for()
		
	}

}
