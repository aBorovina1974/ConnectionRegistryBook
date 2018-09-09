package hr.vodovod.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hr.vodovod.model.ConnectionCategory;
import hr.vodovod.services.ConnectionCategoryService;

@RestController
@RequestMapping("connection/category/")
@CrossOrigin(origins = "http://localhost:4200")
public class ConnectionCategoryController {

	@Autowired
	private ConnectionCategoryService connectionCategoryService;
	
	@GetMapping("/get")
	public List<ConnectionCategory> getAll(){
		return connectionCategoryService.getAll();
	}
}
