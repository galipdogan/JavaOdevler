package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobSekeerService;
import kodlamaio.hmrs.entities.concretes.JobSekeer;

@RestController
@RequestMapping("/api/jobsekeers")
public class JobSekeersManager {

	private JobSekeerService jobSekeerService;

	public JobSekeersManager(JobSekeerService jobSekeerService) {
		super();
		this.jobSekeerService = jobSekeerService;
	}

	@GetMapping("/getall")
	public List<JobSekeer> getAll() {
		return this.jobSekeerService.getAll();
	}

}
