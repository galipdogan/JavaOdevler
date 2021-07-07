package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hmrs.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"JobPosition listed");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(jobPositionDao.findAll()!=null) {
			return new SuccessDataResult<JobPosition>(this.jobPositionDao.save(jobPosition),"JobPosition added");
		}
		return new ErrorDataResult<JobPosition>("This position already has");
	}

	@Override
	public Result update(JobPosition jobPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobPosition jobPosition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
