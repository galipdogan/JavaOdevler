package core.business;

import GoogleAuthManager.GoogleAuthManager;
import business.abstracts.AuthService;
import core.abstracts.LoginService;

public class GoogleAuthManagerAdapter implements LoginService {

	@Override
	public void login(String mail, String password) {
		GoogleAuthManager googleAuthManager=new GoogleAuthManager();
		System.out.println("Google ile giriþ baþarýlý");
	}

}
