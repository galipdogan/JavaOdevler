package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobSekeerService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobSekeer;

@RestController
@RequestMapping("api/jobsekeers")
public class JobSekeersController {

	private JobSekeerService jobSekeerService;

	@Autowired
	public JobSekeersController(JobSekeerService jobSekeerService) {
		super();
		this.jobSekeerService = jobSekeerService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobSekeer>> getAll() {
		return this.jobSekeerService.getAll();
	}
	

	@PostMapping("/add")
	public Result add(@RequestBody JobSekeer jobSekeer) {
		return this.jobSekeerService.add(jobSekeer);
	}

}
