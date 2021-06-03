package kodlamaio.hmrs.core.utilities.validation.EmployerValidate;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.entities.concretes.Employer;

@Service
public class EmployerValidationManager implements EmployerValidationService {


	@Override
	public boolean isValid(Employer employer) {
		if (checkMailAndDomain(employer)) {
			return true;
		}
		return false;
	}

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
