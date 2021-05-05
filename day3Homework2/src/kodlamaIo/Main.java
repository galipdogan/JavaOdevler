package kodlamaIo;

public class Main {

	public static void main(String[] args) {

		Student student = new Student(1,"stdntUsername" ,"Galip", "Doğan", "galip@galip.com", "1233", 1, "computer", "1255");

		Instructor instructor = new Instructor(1,"insUsername","Eğitmen", "Eğitmen", "egitmen@egitmen.com", "1233", 1, "computer","1255");

		//step by step insert
		StudentManager studentManager = new StudentManager();
		studentManager.add(student);

		InstructorManager instructorManager = new InstructorManager();
		instructorManager.add(instructor);

		
		//Inheritance insert
		UserManager userManager = new UserManager();
		userManager.add(student);
		userManager.add(instructor);

		//bulk insert 
		User[] users = { student, instructor };
		userManager.addMultiple(users);

	}

}
