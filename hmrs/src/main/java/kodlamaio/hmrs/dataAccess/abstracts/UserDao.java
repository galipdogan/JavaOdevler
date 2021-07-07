package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
