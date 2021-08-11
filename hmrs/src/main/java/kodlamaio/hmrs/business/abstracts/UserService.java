package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.entities.User;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

public interface UserService {
  DataResult<List<User>> getAll();
  DataResult<User> findByEmail(String email);
  Result add(User user);
  Result delete(User user);
  Result update(User user);
  //boolean emailExist(String email);
  
}
