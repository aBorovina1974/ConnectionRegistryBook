package hr.vodovod.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.vodovod.exception.ConstraintException;
import hr.vodovod.helper.CollectionResult;
import hr.vodovod.model.Connection;
import hr.vodovod.services.ConnectionService;

@RestController
@RequestMapping("connection")
@CrossOrigin(origins = "http://localhost:4200")
public class ConnectionController {
	
	@Autowired
	private ConnectionService connectionService;
	
	@PostMapping("/save")
	public Connection save(@RequestBody Connection connection) throws ConstraintException {
		return connectionService.save(connection);	
	}
	
	@GetMapping("/get")
	public List<Connection> getAll(){
		return connectionService.getAll();
	}
	
	@GetMapping("/get/lazy/{offset}/{limit}")
	public CollectionResult<Connection> getConnectionsLazy(@RequestParam Map<String, String> params, @PathVariable Integer offset, @PathVariable Integer limit){

		return connectionService.getConnectionsLazy(offset, limit, params);
	}
	
	@GetMapping("/request/{id}")
	public Connection getConnectionByRequest(@PathVariable Integer id) {
		return connectionService.getConnectionByRequest(id);
	}
	
}
