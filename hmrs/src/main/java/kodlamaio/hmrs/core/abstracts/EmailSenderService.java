package kodlamaio.hmrs.core.abstracts;


import kodlamaio.hmrs.core.utilities.results.Result;

public interface EmailSenderService {
	Result send(String email, String token);
}
