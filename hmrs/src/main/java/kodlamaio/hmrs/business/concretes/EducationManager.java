package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EducationService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.EducationDao;
import kodlamaio.hmrs.entities.concretes.Education;
@Service
public class EducationManager implements EducationService{

	private EducationDao educationDao;
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<Education>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Education listed");
	}

	@Override
	public Result add(Education education) {
		// TODO Auto-generated method stub
		this.educationDao.save(education);
		return new SuccessDataResult<Education>("Education added");
	}

}
