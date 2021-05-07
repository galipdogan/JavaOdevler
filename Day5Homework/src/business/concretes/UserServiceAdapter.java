package business.concretes;

import business.abstracts.UserValidationService;
import entities.business.User;

public class UserServiceAdapter implements UserValidationService {

	@Override
	public boolean isValid(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userExists(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
