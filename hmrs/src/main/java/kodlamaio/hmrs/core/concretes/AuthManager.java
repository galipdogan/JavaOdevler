package kodlamaio.hmrs.core.concretes;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployerService;
import kodlamaio.hmrs.business.abstracts.JobSekeerService;
import kodlamaio.hmrs.business.abstracts.UserService;
import kodlamaio.hmrs.business.utilities.validation.employerValidation.EmployerValidationService;
import kodlamaio.hmrs.business.utilities.validation.jobsekeerValidation.JobSekeerValidationService;
import kodlamaio.hmrs.core.abstracts.AuthService;
import kodlamaio.hmrs.core.abstracts.EmailSenderService;
import kodlamaio.hmrs.core.abstracts.VerificationService;
import kodlamaio.hmrs.core.utilities.mernis.PersonCheckService;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;
import kodlamaio.hmrs.entities.concretes.Employer;
import kodlamaio.hmrs.entities.concretes.JobSekeer;
import kodlamaio.hmrs.entities.concretes.User;
import kodlamaio.hmrs.entities.concretes.Verification;

@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private EmployerService employerService;
	private EmployerValidationService employerValidationService;
	private JobSekeerService jobseekerService;
	private JobSekeerValidationService jobSekeerValidationService;
	private VerificationService verificationService;
	private PersonCheckService personCheckService;
	private EmailSenderService emailService;

	@Autowired
	public AuthManager(UserService userService, EmployerService employerService,
			EmployerValidationService employerValidationService, JobSekeerService jobseekerService,
			JobSekeerValidationService jobSekeerValidationService, VerificationService verificationService,
			PersonCheckService personCheckService) {

		super();
		this.userService = userService;
		this.employerService = employerService;
		this.employerValidationService = employerValidationService;
		this.jobseekerService = jobseekerService;
		this.jobSekeerValidationService = jobSekeerValidationService;
		this.verificationService = verificationService;
		this.personCheckService = personCheckService;
	}

	@Override
	public Result registerEmployer(Employer employer, String password) {
		if (!employerValidationService.isValid(employer)) {
			return new ErrorResult("Please check your informaiton");
		}
		this.employerService.add(employer);
		String token = UUID.randomUUID().toString();
		this.emailService.send(employer.getEmail(), token);
		return new SuccessResult();

	}

	@Override
	public Result registerJobseeker(JobSekeer jobseeker, String password) {

//		if (!isValidEmail(jobseeker.getEmail())) {
//			return new ErrorResult("Wrong mail format");
//		} else if (jobseeker.getFirstName() == null) {
//		return new ErrorResult("Please check your First Name");
//		} else if (jobseeker.getLastName() == null) {
//			return new ErrorResult("Please check your Last Name");
//
//	} else if (jobseeker.getPassword() == null) {
//		return new ErrorResult("Please check your password is not to be null");
//
//		} else if (!userExists(jobseeker.getEmail())) {
//			return new ErrorResult("This mail adress already taken");
//
//	} else if (!checkIfExistsTcNo(jobseeker.getNationalityId())) {
//			return new ErrorResult("This NationalityId already have");
//		
//		} else if (!checkIfRealPerson(jobseeker)) {
//			return new ErrorResult("TCKN could not be verified.");
//		}
//
		if (!jobSekeerValidationService.isValid(jobseeker).isSuccess()) {
			return new ErrorResult();
		}

		jobseekerService.add(jobseeker);
		String token = UUID.randomUUID().toString();
		emailService.send(jobseeker.getEmail(), token);
		return new SuccessResult("Registration has been successfully completed");
	}

	public boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public boolean userExists(String email) {
		if (userService.findByEmail(email).equals(email)) {
			return true;
		} else {
			return false;
		}

	}

	private boolean checkIfExistsTcNo(JobSekeer jobSekeer) {

		if (this.jobseekerService.getByNationalityId(jobSekeer).getData() == null) {
			return true;
		}
		return false;
	}

}
