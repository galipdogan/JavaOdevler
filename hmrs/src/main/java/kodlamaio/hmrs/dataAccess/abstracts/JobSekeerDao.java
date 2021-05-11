package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.JobSekeer;

public interface JobSekeerDao extends JpaRepository<JobSekeer, Integer>{

}
