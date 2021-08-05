package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Skill;

public interface SkillService {
	DataResult<Skill> findBySkillName(String name);
	DataResult<List<Skill>> getAll();
	Result add(Skill skill);
}
