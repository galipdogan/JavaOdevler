package kodlamaio.hmrs.core.utilities.validation.userValidation;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.User;

public interface UserValidationService {
	DataResult<User> isValid(User user);
	//Result userExists(String email);
}
