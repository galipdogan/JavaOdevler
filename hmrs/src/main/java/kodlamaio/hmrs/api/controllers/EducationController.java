package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.EducationService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.entities.concretes.Education;

@RestController
@RequestMapping(value="/api/educations")
public class EducationController {

	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}

	@GetMapping("/getall")
	public DataResult<List<Education>> getAll() {
		return this.educationService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Education education) {
		this.educationService.add(education);
		return new SuccessDataResult<Education>("Education added");
	}

}
