package kodlamaio.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hmrs.entities.concretes.Verify;

public interface VerifyDao extends JpaRepository<Verify, Integer>{

}
