package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CvService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.CvDao;
import kodlamaio.hmrs.entities.concretes.CV;

@Service
public class CvManager implements CvService {

	private CvDao cvDao;
	
	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public DataResult<List<CV>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CV>>(this.cvDao.findAll(), "Listed");
	}

	@Override
	public Result add(CV cv) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<CV>(this.cvDao.save(cv), "Cv Added"); 
	}

}
