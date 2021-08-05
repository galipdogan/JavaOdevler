package kodlamaio.hmrs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hmrs.entities.concretes.JobAdvertisement;
import kodlamaio.hmrs.entities.concretes.dtos.JobAdvertisementWithEmployerDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	//JobAdvertisement findByJobAdvertisementName(String JobAdvertisementName);
	@Query("From JobAdvertisement where isActive = true")
	List<JobAdvertisement> getAllIsActive();
	
	@Query("From JobAdvertisement where isActive = true Order By createdAt Desc")
	List<JobAdvertisement> findAllByOrderByCreatedAtDesc();
	
	@Query("From JobAdvertisement where isActive = true and employerId =:id")
	List<JobAdvertisement>getAllIsActiveJobAdvertByEmployer(int id);
	
	@Query("From JobAdvertisement where isActive = true and employerId =:id")
	List<JobAdvertisementWithEmployerDto>getAllIsActiveJobAdvertistementDtoByEmployer(int id);
	
//	@Query("Select new kodlamaio.hmrs.entities.dtos.JobAdvertisementWithEmployer"
//			+ "(e.companyName,jp.jobPositionName,c.cityName, ja.totalPositions,ja.createdAt,ja.deadline)"
//			+ "FROM  JobAdvertisement ja"
//			+ "LEFT JOIN ja.employer e"
//			+ "LEFT JOIN ja.jopPosition jp"
//			+ "LEFT JOIN ja.city c")
//	List<JobAdvertisementWithEmployerDto> getAllJobAdvertisementWithEmployerDto();
	
}
