package kodlamaio.hmrs.core.utilities.validation.JobSekeerValidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hmrs.core.utilities.mernis.PersonCheckService;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.JobSekeerDao;
import kodlamaio.hmrs.entities.concretes.JobSekeer;

@Service
public class JobSekeerValidationManager implements JobSekeerValidationService {


	private JobSekeerDao jobSekeerDao;
	private PersonCheckService personCheckService;

	@Autowired
	public JobSekeerValidationManager(JobSekeerDao jobSekeerDao,PersonCheckService personCheckService) {
		super();
		
		this.jobSekeerDao = jobSekeerDao;
		this.personCheckService =personCheckService;
	}

	@Override
	public Result isValid(JobSekeer jobSekeer) {
		
		if (findByNationalityId(jobSekeer)) {
			return new ErrorDataResult<JobSekeer>("This identity already has");
		}else if(!firstNameChecker(jobSekeer)) {
			return new ErrorDataResult<JobSekeer>("First Name cannot be null");
		}else if(!lastNameChecker(jobSekeer)) {
			return new ErrorDataResult<JobSekeer>("Last Name cannot be null");
		}else if(!birthDateChecker(jobSekeer)) {
			return new ErrorDataResult<JobSekeer>("Last Name cannot be null");
		}if(!emailNullChecker(jobSekeer)) {
			return new ErrorDataResult<JobSekeer>("Email cannot be null");
		}else if(!passwordNullChecker(jobSekeer)) {
			return new ErrorDataResult<JobSekeer>("Password cannot be null");
		}		
		return new SuccessResult();
	}
	

	public boolean findByNationalityId(JobSekeer jobSekeer) {
		if (this.jobSekeerDao.findByNationalityId(jobSekeer.getNationalityId()).stream().count()!=0){					
			return true;
		}
		return false;
	}
	
	private boolean firstNameChecker(JobSekeer jobSekeer) {
		if(jobSekeer.getFirstName().isBlank() || jobSekeer.getFirstName().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean lastNameChecker(JobSekeer jobSekeer) {
		if(jobSekeer.getLastName().isBlank() || jobSekeer.getLastName().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean birthDateChecker(JobSekeer jobSekeer) {
		if(jobSekeer.getDateOfBirth().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean emailNullChecker(JobSekeer jobSekeer) {
		if(jobSekeer.getEmail().isBlank() || jobSekeer.getEmail().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean passwordNullChecker(JobSekeer jobSekeer) {
		if(jobSekeer.getPassword().isBlank() || jobSekeer.getPassword().equals(null)) {
			return false;
		}
		return true;
	}
}
