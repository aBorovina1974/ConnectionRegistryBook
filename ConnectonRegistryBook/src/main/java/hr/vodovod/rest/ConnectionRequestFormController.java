package hr.vodovod.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hr.vodovod.helper.CollectionResult;
import hr.vodovod.model.ConnectionRequestForm;
import hr.vodovod.services.ConnectionRequestFormService;

@RestController
@RequestMapping("requests")
@CrossOrigin(origins = "http://localhost:4200")
public class ConnectionRequestFormController {
	
	@Autowired
	private ConnectionRequestFormService connectionRequestFormService;
	
	
	@GetMapping("/get/lazy/{offset}/{limit}")
	public CollectionResult<ConnectionRequestForm> getRequestsLazy(@RequestParam Map<String, String> params, @PathVariable Integer offset, @PathVariable Integer limit){

		return connectionRequestFormService.getRequestsLazy(offset, limit, params);
	}
}
