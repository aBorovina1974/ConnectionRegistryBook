package hr.vodovod.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hr.vodovod.jpa.repositories.ConnectionCategoryRepository;
import hr.vodovod.model.ConnectionCategory;

@Service
public class ConnectionCategoryServiceImpl implements ConnectionCategoryService{
	
	@Autowired
	private ConnectionCategoryRepository connectionCategoryRepository;

	@Override
	public List<ConnectionCategory> getAll() {
		return connectionCategoryRepository.findAll();
	}

	@Override
	public ConnectionCategory getOne(Integer id) {
		return connectionCategoryRepository.getOne(id);
	}


}
