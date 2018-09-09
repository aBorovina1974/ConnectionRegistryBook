package hr.vodovod.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.vodovod.model.Municipality;
import hr.vodovod.services.MunicipalityService;

@RestController
@RequestMapping("/municipality")
@CrossOrigin(origins = "http://localhost:4200")
public class MunicipalityController {
	
	@Autowired
	private MunicipalityService municipalityService;
	
	@GetMapping("/get")
	public List<Municipality> getAll(){
		return municipalityService.getAll();
	}
}
