package kodlamaIo;

public class Student extends User {
	private int studentId;
	private String departman;
	private String studentNumber;

	public Student() {
		
	}

	public Student(int userId,String userName, String firstName, String lastName, String eMail, String password, int studentId,
			String departman, String studentNumber) {
		super(userId,userName, firstName, lastName, eMail, password);
		this.studentId = studentId;
		this.departman = departman;
		this.studentNumber=studentNumber;
	}

	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getDepartman() {
		return this.departman;
	}

	public void setDepartman(String departman) {
		this.departman = departman;
	}
	
	public String getStudentNumber() {
		return this.studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

}
