package kodlamaio.hmrs.core.concretes;

import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.abstracts.EmailSenderService;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessResult;

@Service
public class EmailSenderManager implements EmailSenderService {

	@Override
	public Result send(String email, String token) {
		 return new SuccessDataResult("Email Send. Check your mail box " + email + " "+token);	
	}


}
