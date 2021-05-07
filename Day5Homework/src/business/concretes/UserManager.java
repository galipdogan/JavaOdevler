package business.concretes;

import business.abstracts.UserService;
import business.abstracts.UserValidationService;
import core.abstracts.MailValidationService;
import dataAccess.abstracts.UserDao;
import entities.business.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private UserValidationService userValidationService;
	private MailValidationService mailValidationService;
	private UserService userService;

	public UserManager(UserDao userDao, UserValidationService userValidationService,
			MailValidationService mailValidationService) {
		this.userDao = userDao;
		this.userValidationService = userValidationService;
		this.mailValidationService = mailValidationService;
	}

	@Override
	public void add(User user) {
		if (!userValidationService.isValid(user)) {
			System.out.println("Lütfen bilgilerinizi kontrol ediniz");
		} else if (user.getEmail() == null) {
			System.out.println("Bu kullanýcý daha önce kayýtlýdýr");

		} else if (userValidationService.userExists(user.getEmail())) {

		} else {
			userDao.add(user);
			mailValidationService.sendMail();
		}

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public void login(String email, String password) {

	}

	@Override
	public User get(String email) {
		// TODO Auto-generated method stub
		return null;
	}


}