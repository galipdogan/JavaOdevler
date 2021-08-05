package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.LanguageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.LanguageDao;
import kodlamaio.hmrs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		
		return new DataResult<List<Language>>(this.languageDao.findAll(), true, "Listed");
	}

	@Override
	public Result add(Language language) {
		if(!this.languageChecker(language)) {
			return new ErrorResult("This language already has");
		}
		this.languageDao.save(language);
		return new SuccessDataResult<Language>(language, "added");
	}
	
	private boolean languageChecker(Language language) {
		if(language.getLangName().equals(null) && language.getLangName().equals(language)) {
			return false;
		}
		return true;
	}

	@Override
	public DataResult<Language> findByLangName(String name) {
		
		return new SuccessDataResult<Language>(this.languageDao.findByLangName(name),"Found language");
	}


}


	