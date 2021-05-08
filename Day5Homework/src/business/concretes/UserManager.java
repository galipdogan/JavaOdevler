package business.concretes;


import business.abstracts.UserService;
import business.abstracts.UserValidationService;
import core.abstracts.LoginService;
//import core.abstracts.MailValidationService;
//import core.business.MailValidationManager;
import dataAccess.abstracts.UserDao;
import entities.business.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private LoginService loginService;
	private UserValidationService userValidationService;
	//private MailValidationService mailValidationService;
	public UserManager(UserDao userDao,UserValidationService userValidationService,LoginService loginService) {
		super();
		this.userDao = userDao;
		this.userValidationService=userValidationService;
		this.loginService= loginService;
		//this.mailValidationService=mailValidationService;
	}


	@Override
	public void add(User user) {
		if(userValidationService.isValid(user))
		userDao.add(user);
		//mailValidationService.sendMail();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User get(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByMail(String mail) {
		
		return userDao.getByMail(mail);
	}

}