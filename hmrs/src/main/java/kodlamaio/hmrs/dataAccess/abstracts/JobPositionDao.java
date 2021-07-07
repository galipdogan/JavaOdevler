package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{

	DataResult<JobPosition> getByJobPositionName(String jobPositionName);
	
	DataResult<JobPosition> getByIsActive(boolean active);
	
	
}
