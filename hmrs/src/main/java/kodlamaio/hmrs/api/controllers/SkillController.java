package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.SkillService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Skill;
@RestController
@RequestMapping(value="/api/skills")
public class SkillController {

	private SkillService skillService;

	@Autowired
	public SkillController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	@GetMapping("/getAll")
	private DataResult<List<Skill>> getAll(){
		return this.skillService.getAll();
	}
	
	@GetMapping("/getBySkillName")
	private DataResult<Skill> findBySkillName(@RequestParam String name){
		return this.skillService.findBySkillName(name);
	}
	
	@PostMapping("/add")
	private Result add(@RequestBody Skill skill){
		return this.skillService.add(skill);
		  
	}
}
