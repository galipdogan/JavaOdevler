package kodlamaio.hmrs.core.utilities.mernis;

import kodlamaio.hmrs.entities.concretes.JobSekeer;

public interface PersonCheckService {
	boolean checkIfRealPerson(JobSekeer jobSekeer);
}
