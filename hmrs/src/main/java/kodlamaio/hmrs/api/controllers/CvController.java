package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.CvService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.entities.concretes.CV;

@RestController
@RequestMapping("/api/cvs")
public class CvController {

	private CvService cvService;

	@Autowired
	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}

	@GetMapping("/getall")
	public DataResult<List<CV>> getAll() {
		return this.cvService.getAll();
	}
	
	@PostMapping("/add")
	public Result add (@RequestBody CV cv) {
		this.cvService.add(cv);
		return new SuccessDataResult<CV>("Cv Added");
	}

}