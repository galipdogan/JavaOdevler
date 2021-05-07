

import business.concretes.UserManager;
import business.concretes.UserValidationManager;
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

		UserManager userManager = new UserManager(new InMemoryUserDao(),new UserValidationManager(new InMemoryUserDao()),new MailValidationManager());
		//userManager.add(user);
		userManager.login("galip@galip.com", "123456");
		

	}
}
