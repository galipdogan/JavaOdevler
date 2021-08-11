package kodlamaio.hmrs.core.utilities.validation.userValidation;

import kodlamaio.hmrs.core.entities.User;
import kodlamaio.hmrs.core.utilities.results.DataResult;

public interface UserValidationService {
	DataResult<User> isValid(User user);
	//Result userExists(String email);
}
