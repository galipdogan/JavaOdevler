package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.business.utilities.validation.employerValidation.EmployerValidationService;
import kodlamaio.hmrs.core.dataAccess.UserDao;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.validation.userValidation.UserValidationService;
import kodlamaio.hmrs.dataAccess.abstracts.EmployerDao;
import kodlamaio.hmrs.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerValidationService employerValidationService;
	private UserValidationService userValidationService;
	private EmployerDao employerDao;
	private UserDao userDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao,
			EmployerValidationService employerValidationService) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.employerValidationService = employerValidationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employer listed");
	}

	@Override
	public Result add(Employer employer) {
		if (!checkMailAndDomain(employer)) {
			return new ErrorResult("please check mail and domain");
			
		} if (!this.userValidationService.isValid(employer).isSuccess()) {
			return new ErrorResult();
		}

		return new SuccessDataResult<Employer>(this.employerDao.save(employer), "Employer added");

	}

	@Override
	public Result update(Employer employer) {
		return null;
	}

	@Override
	public Result delete(Employer employer) {

		return null;
		// new SuccessDataResult<Employer>(this.employerDao.delete(employer), "Employer
		// deleted");
	}

//	public static boolean checkMailAndDomain(Employer employer) {
//
//        String[] dizi = employer.getEmail().split("@");
//        String email=dizi[1];
//
//        String[] dizi2 = employer.getWebsite().split("www.");
//        String domain =dizi2[1];
//
//        if(email.equals(domain)) {
//            return true;
//        }
//        return false;
//    }

	public boolean checkMailAndDomain(Employer employer) {

		var email = employer.getEmail();
		// var name = email.substring(0, email.lastIndexOf("@"));
		var domain = email.substring(email.lastIndexOf("@") + 1);
		if (employer.getWebsite().equals(domain)) {
			return true;
		}
		return false;
	}

}
