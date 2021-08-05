package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.SkillService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.SkillDao;
import kodlamaio.hmrs.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService {

	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<Skill> findBySkillName(String name) {
		return new SuccessDataResult<Skill>(this.skillDao.findBySkillName(name), "Skill Found");
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		
		return new DataResult<List<Skill>>(this.skillDao.findAll(),true, "Skill listed");
	}

	@Override
	public Result add(Skill skill) {
		this.skillDao.save(skill);
		return new SuccessDataResult<Skill>(skill,"Added");
	}

}
