package kodlamaio.hmrs.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobSekeerService;
import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.core.abstracts.EmailSenderService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.validation.JobSekeerValidate.JobSekeerValidationService;
import kodlamaio.hmrs.core.utilities.validation.UserValidate.UserValidationService;
import kodlamaio.hmrs.dataAccess.abstracts.JobSekeerDao;
import kodlamaio.hmrs.entities.concretes.JobSekeer;

@Service
public class JobSekeerManager implements JobSekeerService {

	private JobSekeerDao jobSekeerDao;
	private JobSekeerValidationService jobSekeerValidationService;
	private UserValidationService userValidationService;
	private UserService userService;
	private EmailSenderService emailSenderService;

	@Autowired
	public JobSekeerManager(JobSekeerDao jobSekeerDao, JobSekeerValidationService jobSekeerValidationService,UserService userService,
			UserValidationService userValidationService,
			EmailSenderService emailSenderService) {
		super();
		this.jobSekeerDao = jobSekeerDao;
		this.jobSekeerValidationService = jobSekeerValidationService;
		this.userValidationService = userValidationService;
		this.userService=userService;
		this.emailSenderService=emailSenderService;
	}

	@Override
	public DataResult<List<JobSekeer>> getAll() {
		return new SuccessDataResult<List<JobSekeer>>(this.jobSekeerDao.findAll());
	}

	@Override
	public Result add(JobSekeer jobSekeer) {
		if (this.jobSekeerDao.findByNationalityId(jobSekeer.getNationalityId()).stream().count()!=0) {
			return new ErrorResult("This identity already have");
		
		}else if(jobSekeer.getFirstName().isBlank() || jobSekeer.getFirstName().equals(null)) {
			return new ErrorResult("Check the firstname is not to be null");
		
		}else if(jobSekeer.getLastName().isBlank() || jobSekeer.getLastName().equals(null)) {
			return new ErrorResult("Check the lastname is not to be null");
		
		}else if(jobSekeer.getDateOfBirth().equals(null)) {
			return new ErrorResult("Check the birthday is not to be null");
			
		}else if(jobSekeer.getEmail().isBlank() || jobSekeer.getEmail().equals(null)) {
			return new ErrorResult("Check the email is not to be null");
			
		}else if(jobSekeer.getPassword().isBlank() || jobSekeer.getPassword().equals(null)) {
			return new ErrorResult("Check the password is not to be null");
		
		}else if(this.jobSekeerDao.findByEmail(jobSekeer.getEmail()).stream().count()!=0) {
			return new ErrorResult("The email is already have");
		}
		
		this.jobSekeerDao.save(jobSekeer);
		String token = UUID.randomUUID().toString();
		emailSenderService.send(jobSekeer.getEmail(), token);	
		return new SuccessDataResult<JobSekeer>(jobSekeer, "JobSekeer added");
	}

	@Override
	public Result update(JobSekeer jobSekeer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobSekeer jobSekeer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<JobSekeer> getByNationalityId(JobSekeer jobSekeer) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public boolean findByNationalityId(JobSekeer jobSekeer) {
//		if (this.jobSekeerDao.findByNationalityId(jobSekeer.getNationalityId()).stream().count()!=0){					
//			return true;
//		}
//		return false;
//	}
//	
//	private boolean firstNameChecker(JobSekeer jobSekeer) {
//		if(jobSekeer.getFirstName().isBlank() || jobSekeer.getFirstName().equals(null)) {
//			return false;
//		}
//		return true;
//	}
//	
//	private boolean lastNameChecker(JobSekeer jobSekeer) {
//		if(jobSekeer.getLastName().isBlank() || jobSekeer.getLastName().equals(null)) {
//			return false;
//		}
//		return true;
//	}
//	
//	private boolean birthDateChecker(JobSekeer jobSekeer) {
//		if(jobSekeer.getDateOfBirth().equals(null)) {
//			return false;
//		}
//		return true;
//	}
//	
//	private boolean emailNullChecker(JobSekeer jobSekeer) {
//		if(jobSekeer.getEmail().isBlank() || jobSekeer.getEmail().equals(null)) {
//			return false;
//		}
//		return true;
//	}
//	
//	private boolean passwordNullChecker(JobSekeer jobSekeer) {
//		if(jobSekeer.getPassword().isBlank() || jobSekeer.getPassword().equals(null)) {
//			return false;
//		}
//		return true;
//	}

}
