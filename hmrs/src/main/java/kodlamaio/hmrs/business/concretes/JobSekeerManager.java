package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.JobSekeerService;
import kodlamaio.hmrs.dataAccess.abstracts.JobSekeerDao;
import kodlamaio.hmrs.entities.concretes.JobSekeer;

@Service
public class JobSekeerManager implements JobSekeerService {
	
	JobSekeerDao jobSekeerDao;
	@Autowired
	public JobSekeerManager(JobSekeerDao jobSekeerDao) {
		super();
		this.jobSekeerDao = jobSekeerDao;
	}

	@Override
	public List<JobSekeer> getAll() {
		return this.jobSekeerDao.findAll();
	}

}
