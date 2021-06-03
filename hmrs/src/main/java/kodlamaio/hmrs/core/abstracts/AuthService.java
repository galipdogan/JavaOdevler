package kodlamaio.hmrs.core.abstracts;

import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Employer;
import kodlamaio.hmrs.entities.concretes.JobSekeer;

public interface AuthService {
	
	Result registerEmployer(Employer employer, String password);
	Result registerJobseeker(JobSekeer jobseeker, String password);

}
