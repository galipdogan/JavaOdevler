package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.JobAdvertisementService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.JobAdvertisement;
import kodlamaio.hmrs.entities.concretes.dtos.JobAdvertisementWithEmployerDto;

@RestController
@RequestMapping("api/jobAdvertisements/")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;
	
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService=jobAdvertisementService;
		
	
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getallIsActive")
	public DataResult<List<JobAdvertisement>> getAllIsActive(){
		return this.jobAdvertisementService.getAllIsActive();
	}
	
	@GetMapping("/getallIsActiveDto")
	public DataResult<List<JobAdvertisementWithEmployerDto>> getAllIsActiveDto(){
		return this.jobAdvertisementService.getAllIsActiveDto();
	}
	
	@GetMapping("/getAllByOrderByCreatedAt")
	public DataResult<List<JobAdvertisement>> getAllByOrderByCreatedAt(){
		return this.jobAdvertisementService.getAllByOrderByCreatedAt();
	}
	
	@GetMapping("/getAllIsActiveByUserId")
	public DataResult<List<JobAdvertisement>> getAllIsActiveByUserId(@RequestParam int id){
		return this.jobAdvertisementService.getAllIsActiveByUserId(id);
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
}
