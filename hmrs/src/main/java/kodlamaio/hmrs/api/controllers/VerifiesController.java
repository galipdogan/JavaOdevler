package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.VerifyService;
import kodlamaio.hmrs.entities.concretes.Verify;

@RestController
@RequestMapping("api/verifies")
public class VerifiesController {

	private VerifyService verifyService;

	public VerifiesController(VerifyService verifyService) {
		super();
		this.verifyService = verifyService;
	}
	
	@GetMapping("/getall")
	public List<Verify> getAll(){
		return this.verifyService.getAll();
	}
}
