package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import entities.business.User;

public class InMemoryUserDao implements dataAccess.abstracts.UserDao {

	private List<User> users = new ArrayList<User>();

	public InMemoryUserDao() {
		super();
		User user1 = new User(1, "Galip", "Doðan", "galip@galip.com", "123456", true);
		User user2 = new User(2, "Galip", "Doðan", "glp@galip.com", "123456", true);
		User user3 = new User(3, "Galip", "Doðan", "glpp1@galip.com", "123456", true);

		users.add(user1);
		users.add(user2);
		users.add(user3);
	}

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("InMemory Eklendi : " + user.getFirstName());

	}

	@Override
	public void update(User user) {
		User userToUpdate = users.stream().filter(u -> u.getId() == user.getId()).findFirst().orElse(null);

		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setVerify(user.isVerify());
		System.out.println("InMemory Güncellendi : " + user.getFirstName());
	}

	@Override
	public void delete(int id) {
		User userToDelete = users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);

		users.remove(userToDelete);

		System.out.println("InMemory Silindi : ");

	}

	@Override
	public List<User> getAll() {
		for (User user : users) {
			System.out.println(user);
		}
		return users;
	}

	@Override
	public User getByMail(String email) {
		User userToReturn=null;
		for(User user:this.users) {
			if(user.getEmail().equals(email)) {
				userToReturn=user;
				break;
			}
		}
		return userToReturn;
	}

	@Override
	public boolean isVerified(User user) {
		User userToCheck = get(user.getId());
        return userToCheck.isVerify() ?
                true : false;
	}

	@Override
	public User get(int id) {
		 User userToReturn = this.users.stream()
	                .filter((user) -> user.getId() == id)
	                .findFirst()
	                .orElse(null);
	        return userToReturn;
	}
   
}