package dataAccess.abstracts;

import java.util.List;

import entities.business.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(int id);
	List<User> getAll();
	User getByMail(String email); 
}
