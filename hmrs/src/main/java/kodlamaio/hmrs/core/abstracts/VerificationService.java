package kodlamaio.hmrs.core.abstracts;


import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Verification;

public interface VerificationService {
	Result add(Verification verification);
	Result findByToken(String token);
	Integer setConfirmedAt(String token);
	
}