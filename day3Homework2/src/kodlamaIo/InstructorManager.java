package kodlamaIo;

public class InstructorManager extends UserManager {

	@Override
	public void add(User user) {
		System.out.println("Kullan�c� eklendi " + user.getFisrtName());
	}
}
