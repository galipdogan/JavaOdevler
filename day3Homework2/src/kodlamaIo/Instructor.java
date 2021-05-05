package kodlamaIo;

public class Instructor extends User{
	private int instructorId;
	private String departman;
	private String title;//ünvan
	
	public Instructor() {
		
	}
	
	public Instructor(int userId,String userName, String firstName, String lastName, String eMail, String password,int instructorId, String departman, String title ) {
		super(userId,userName,firstName, lastName, eMail, password);
		this.instructorId=instructorId;
		this.departman=departman;
		this.title=title;
	}
	
	public String getDepartman() {
		return departman;
	}
	public void setDepartman(String departman) {
		this.departman = departman;
	}
	
	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}
