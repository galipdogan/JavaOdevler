

import business.abstracts.AuthService;
import business.abstracts.UserService;
import business.concretes.AuthManager;
import business.concretes.UserManager;
import business.concretes.UserValidationManager;
import core.abstracts.LoginService;
import core.business.GoogleAuthManagerAdapter;
import core.business.MailValidationManager;
import dataAccess.concretes.InMemoryUserDao;
import entities.business.User;

public class Main {

	public static void main(String[] args) {
		User user = new User();
		user.setFirstName("Galip");
		user.setLastName("Doðan");
		user.setEmail("galip@galip.com");
		user.setPassword("123456");

		UserService userService=new UserManager(new InMemoryUserDao(),new UserValidationManager(new InMemoryUserDao()),new GoogleAuthManagerAdapter());
			
		AuthService authService=new AuthManager(new UserManager(new InMemoryUserDao(),new UserValidationManager(new InMemoryUserDao()),new GoogleAuthManagerAdapter()));
		
		
		//userService.add(user);
		//authService.register(user);
		//authService.login("galip@galip.com", "123456");
		authService.loginWithGoogle("galip@galip.com", "123456");
		
	}
}
