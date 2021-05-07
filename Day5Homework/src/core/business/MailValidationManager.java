package core.business;

import core.abstracts.MailValidationService;

public class MailValidationManager implements MailValidationService {

	@Override
	public void sendMail() {
		System.out.println("Send verify mail check your mailbox");

	}

}
