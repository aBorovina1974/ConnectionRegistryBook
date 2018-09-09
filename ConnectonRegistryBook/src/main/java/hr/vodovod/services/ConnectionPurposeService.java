package hr.vodovod.services;

import java.util.List;

import hr.vodovod.model.ConnectionPurpose;

public interface ConnectionPurposeService {

	List<ConnectionPurpose> getAll();
	ConnectionPurpose getOne(Integer id);
}
