package kodlamaio.hmrs.core.utilities.validation.UserValidate;

import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.User;

public interface UserValidationService {
	Result isValid(User user);
	//Result userExists(String email);
}
