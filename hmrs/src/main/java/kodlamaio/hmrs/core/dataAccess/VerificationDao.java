package kodlamaio.hmrs.core.dataAccess;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hmrs.entities.concretes.Verification;

public interface VerificationDao extends JpaRepository<Verification, Integer>{
	
	 Optional<Verification> findByToken(String token);

	    @Transactional
	    @Modifying
	    @Query("UPDATE Verification c " +
	            "SET c.confirmedAt = ?2 " +
	            "WHERE c.token = ?1")
	    int updateConfirmedAt(String token,
	                          LocalDateTime confirmedAt);

}
