package kodlamaio.hmrs.business.utilities.validation.jobsekeerValidation;

import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobSekeer;

public interface JobSekeerValidationService {
	 Result isValid(JobSekeer jobSekeer);
}
