package hr.vodovod.services;

import java.util.List;

import hr.vodovod.model.RequestPurpose;

public interface RequestPurposeService {
	List<RequestPurpose> getAll();
	RequestPurpose getOne(Integer id);
}
