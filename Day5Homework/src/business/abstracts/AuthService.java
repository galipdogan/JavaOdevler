package business.abstracts;

import entities.business.User;

public interface AuthService {
	void login(String email, String password);
    void register(User user);
    
}
