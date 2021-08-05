package kodlamaio.hmrs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hmrs.business.abstracts.LanguageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

	private LanguageService languageService;
	
	@Autowired
	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	

	@GetMapping("/getall")
	public DataResult<List<Language>> getAll() {

		return this.languageService.getAll();

	}
	
	@GetMapping("/getByLangName")
	public DataResult<Language> getByLangName(@RequestParam String name) {
		return this.languageService.findByLangName(name);
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Language language) {
		return this.languageService.add(language); 
	}
	
}
