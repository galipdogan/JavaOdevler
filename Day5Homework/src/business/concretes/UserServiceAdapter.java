package business.concretes;

import business.abstracts.UserValidationService;
import entities.business.User;

public class UserServiceAdapter implements UserValidationService {

	@Override
	public boolean isValid(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
