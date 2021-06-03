package kodlamaio.hmrs.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	DataResult<List<User>> findByEmail(String email);
	//boolean emailExists(User user);
}
