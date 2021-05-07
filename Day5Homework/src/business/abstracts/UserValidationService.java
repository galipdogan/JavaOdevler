package business.abstracts;

import entities.business.User;

public interface UserValidationService {
	boolean isValid(User user);
	boolean userExists(String email);
}
