package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.DepartmentService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.DepartmentDao;
import kodlamaio.hmrs.entities.concretes.Department;

@Service
public class DeparmentManager implements DepartmentService{
	
	private DepartmentDao departmentDao;
	@Autowired
	public DeparmentManager(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public DataResult<List<Department>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Department>>(this.departmentDao.findAll());
	}

	@Override
	public Result add(Department department) {
		// TODO Auto-generated method stub
		this.departmentDao.save(department);
		return new SuccessDataResult<Department>("Department added");
	}

}
