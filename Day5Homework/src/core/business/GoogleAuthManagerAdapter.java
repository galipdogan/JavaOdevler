package core.business;

import GoogleAuthManager.GoogleAuthManager;
import business.abstracts.AuthService;

public class GoogleAuthManagerAdapter implements AuthService{

	@Override
	public void loginToSystem(String message) {
		GoogleAuthManager auth=new GoogleAuthManager();
		auth.login(message);
		
	}

}
