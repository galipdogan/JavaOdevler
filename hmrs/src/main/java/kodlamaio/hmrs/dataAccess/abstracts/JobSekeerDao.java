package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hmrs.entities.concretes.JobSekeer;

public interface JobSekeerDao extends JpaRepository<JobSekeer, Integer>{
	
	List<JobSekeer> findByNationalityId(String notionalityId);
	List<JobSekeer> findByEmail(String email);

}
