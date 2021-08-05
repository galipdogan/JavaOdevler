package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.CV;

public interface CvDao extends JpaRepository<CV, Integer> {
	List<CV> findById(int id);
	
	boolean existsById(int id);

}
