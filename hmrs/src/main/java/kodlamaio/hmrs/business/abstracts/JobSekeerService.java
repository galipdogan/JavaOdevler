package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobSekeer;

public interface JobSekeerService {
	DataResult<List<JobSekeer>> getAll();
	DataResult<JobSekeer> getByNationalityId(JobSekeer jobSekeer);
	Result add(JobSekeer jobSekeer);
	Result update(JobSekeer jobSekeer);
	Result delete(JobSekeer jobSekeer);

}
