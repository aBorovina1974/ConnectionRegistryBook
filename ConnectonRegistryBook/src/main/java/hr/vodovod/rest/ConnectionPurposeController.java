package hr.vodovod.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hr.vodovod.model.ConnectionPurpose;
import hr.vodovod.services.ConnectionPurposeService;

@RestController
@RequestMapping("/connection/purpose")
@CrossOrigin(origins = "http://localhost:4200")
public class ConnectionPurposeController {

	@Autowired
	private ConnectionPurposeService connectionPurposeServiceImpl;
	
	@GetMapping("/get")
	public List<ConnectionPurpose> getAll(){
		return connectionPurposeServiceImpl.getAll();	
	}
}
