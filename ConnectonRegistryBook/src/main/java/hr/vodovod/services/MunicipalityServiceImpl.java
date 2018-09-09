package hr.vodovod.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.vodovod.jpa.repositories.MunicipalityRepository;
import hr.vodovod.model.Municipality;

@Service
public class MunicipalityServiceImpl implements MunicipalityService {
	
	@Autowired
	private MunicipalityRepository municipalityRepository;

	@Override
	public List<Municipality> getAll() {
		return municipalityRepository.findAll();
	}

	@Override
	public Municipality getOne(Integer id) {
		return municipalityRepository.getOne(id);
	}

}
