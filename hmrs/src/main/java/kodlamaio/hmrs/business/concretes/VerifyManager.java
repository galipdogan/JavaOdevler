package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.VerifyService;
import kodlamaio.hmrs.dataAccess.abstracts.VerifyDao;
import kodlamaio.hmrs.entities.concretes.Verify;

@Service
public class VerifyManager implements VerifyService{
	
	VerifyDao verifyDao;
	@Autowired
	public VerifyManager(VerifyDao verifyDao) {
		super();
		this.verifyDao = verifyDao;
	}

	@Override
	public List<Verify> getAll() {
		
		return this.verifyDao.findAll();
	}

}
