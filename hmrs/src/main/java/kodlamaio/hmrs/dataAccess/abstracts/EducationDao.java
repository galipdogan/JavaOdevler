package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{
	Education getByName(String name);
	List<Education> getByNameContains(String name);
	
	
}
