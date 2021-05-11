package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.entities.concretes.Employee;

public interface EmployeeService {
	List<Employee> getAll();
}
