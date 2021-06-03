package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployeeService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hmrs.dataAccess.abstracts.UserDao;
import kodlamaio.hmrs.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {
	
	private EmployeeDao employeeDao;
	private UserDao userDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,UserDao userDao) {
		super();
		this.employeeDao = employeeDao;
		this.userDao=userDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Employee listed");
	}

	@Override
	public Result add(Employee employee) {
		employeeDao.save(employee);
		return new SuccessDataResult<Employee>(this.employeeDao.save(employee),"Employee added");
	}

	@Override
	public Result update(Employee employee) {
		
		return new SuccessDataResult<Employee>(this.employeeDao.save(employee),"Employee updated");
		
	}

	@Override
	public Result delete(Employee employee) {
		this.employeeDao.delete(employee);
		return new SuccessResult( "Employee deleted");
	}

	

}
