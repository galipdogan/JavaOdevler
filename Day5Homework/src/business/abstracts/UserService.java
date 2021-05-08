package business.abstracts;

import entities.business.User;

public interface UserService {
	void add(User user);
	void update(User user);
	void delete(int id);	
	User get(String email);
	User getByMail(String mail);

	
}
