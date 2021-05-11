package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.dataAccess.abstracts.UserDao;
import kodlamaio.hmrs.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserDao userdao;
	
	@Autowired
	public UserManager(UserDao userdao) {
		super();
		this.userdao = userdao;
	}


	@Override
	public List<User> getAll() {
		return this.userdao.findAll();
		
	}

}
