package kodlamaIo;

public class UserManager {
	public void add(User user) {
		System.out.println("Kullanýcý eklendi " + user.getFisrtName());
	}
	
	//bulk insert
	public void addMultiple(User[] users) {
		for(User user: users) {
			add(user);
		}
	}
	
}
