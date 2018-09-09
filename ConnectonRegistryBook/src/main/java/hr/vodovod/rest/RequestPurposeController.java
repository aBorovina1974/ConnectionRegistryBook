package hr.vodovod.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.vodovod.model.RequestPurpose;
import hr.vodovod.services.RequestPurposeService;

@RestController
@RequestMapping("/request/purpose")
@CrossOrigin(origins = "http://localhost:4200")
public class RequestPurposeController {

	@Autowired
	private RequestPurposeService requestPurposeService;
	
	@GetMapping("/get")
	public List<RequestPurpose> getAll(){
		return requestPurposeService.getAll();
	}
}
