package hr.vodovod.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import hr.vodovod.model.ConnectionPurpose;

@Service
public class ConnectionPurposeServiceImpl implements ConnectionPurposeService {

	@Autowired
	private JpaRepository<ConnectionPurpose, Integer> repository;
	
	@Override
	public List<ConnectionPurpose> getAll() {
		return repository.findAll();
	}

	@Override
	public ConnectionPurpose getOne(Integer id) {
		return repository.getOne(id);
	}

}
