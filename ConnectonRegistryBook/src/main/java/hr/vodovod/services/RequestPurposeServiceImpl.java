package hr.vodovod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.vodovod.jpa.repositories.RequestPurposeRepository;
import hr.vodovod.model.RequestPurpose;

@Service
public class RequestPurposeServiceImpl implements RequestPurposeService {
	
	@Autowired
	private RequestPurposeRepository requestPurposeRepository;

	@Override
	public List<RequestPurpose> getAll() {
		return requestPurposeRepository.findAll();
	}

	@Override
	public RequestPurpose getOne(Integer id) {
		return requestPurposeRepository.getOne(id);
	}

}
