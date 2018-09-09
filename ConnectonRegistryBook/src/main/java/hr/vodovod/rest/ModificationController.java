package hr.vodovod.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.vodovod.jpa.repositories.ModificationRepository;
import hr.vodovod.model.Modification;

@RestController
@RequestMapping("/modification")
@CrossOrigin(origins = "http://localhost:4200")
public class ModificationController {
	
	@Autowired
	ModificationRepository modificationRepository;
	
	@GetMapping("/get")
	public List<Modification> findAll(){
		return modificationRepository.findAll();
	}
	
	@PostMapping("/save")
	public Modification saveModification(@RequestBody Modification modification) {
		return modificationRepository.save(modification);
	}

}