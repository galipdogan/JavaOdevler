package business.concretes;

import business.abstracts.AuthService;
import business.abstracts.UserService;
import business.abstracts.UserValidationService;
import core.abstracts.MailValidationService;
import entities.business.User;

public class AuthManager implements AuthService {
	private UserService userService;

	public AuthManager(UserService userService) {
		super();
		this.userService = userService;

	}

	@Override
	public void login(String email, String password) {
		User getUser = userService.getByMail(email);
		if (getUser == null) {
			System.out.println("Sisteme kay�tl� de�ilsiniz.");
		} else if (getUser.getPassword() != password) {
			System.out.println("L�tfen parolan�z� kontrol ediniz..");
		} else {
			System.out.println("Login ba�ar�l� " + getUser.getFirstName() + " " + getUser.getLastName());
		}
	}

	@Override
	public void register(User user) {
		userService.add(user);

	}

	@Override
	public void loginWithGoogle(String email, String password) {
		User getUser = userService.getByMail(email);
		if (getUser == null) {
			System.out.println("Sisteme kay�tl� de�ilsiniz.");
		} else if (getUser.getPassword() != password) {
			System.out.println("L�tfen parolan�z� kontrol ediniz..");
		} else {
			System.out.println("Google ile login ba�ar�l� " + getUser.getFirstName() + " " + getUser.getLastName());
		}
	}

}
