package kodlamaio.hmrs.core.concretes;



import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.abstracts.VerificationService;
import kodlamaio.hmrs.core.dataAccess.VerificationDao;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.entities.concretes.Verification;

@Service
public class VerificationManager implements VerificationService {

	private VerificationDao verificationDao;
	@Autowired
	public VerificationManager(VerificationDao verificationDao) {
		super();
		this.verificationDao = verificationDao;
	}


	@Override
	public Result add(Verification verification) {
		this.verificationDao.save(verification);
		return new SuccessDataResult<Verification>();
	}


	@Override
	public Result findByToken(String token) {
		
		return new SuccessDataResult<Optional<?>>(this.verificationDao.findByToken(token),"Verification token found");
	}


	@Override
	public Integer setConfirmedAt(String token) {
		 return verificationDao.updateConfirmedAt(
	                token, LocalDateTime.now());
	}

//	@Override
//	public void sendMail(String email) {
//		UUID token = UUID.randomUUID();
//		System.out.println(token+ " " +email);
//		
//	}

}
