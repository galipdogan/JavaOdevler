package core.business;

import GoogleAuthManager.GoogleAuthManager;
import core.abstracts.LoginService;

public class GoogleAuthManagerAdapter implements LoginService {

	@Override
	public void login(String email, String password) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.login(email, password);
		System.out.println("Google ile giriþ baþarýlý");

	}

}
