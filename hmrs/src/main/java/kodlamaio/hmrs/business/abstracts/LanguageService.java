package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Language;

public interface LanguageService {
	DataResult<Language> findByLangName(String name);
	DataResult<List<Language>> getAll();
	Result add(Language language);
	

}
