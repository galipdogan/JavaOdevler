package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobPositionService;
import kodlamaio.hmrs.entities.concretes.JobPosition;

@RestController
@RequestMapping("api/jobpositions")
public class JobPositionController {

	private JobPositionService jbPositionService;
	
	@Autowired
	public JobPositionController(JobPositionService jbPositionService) {
		super();
		this.jbPositionService = jbPositionService;
	}
	
	@GetMapping("/getall")
	public List<JobPosition> getAll(){
		return this.jbPositionService.getAll();
	}
}
