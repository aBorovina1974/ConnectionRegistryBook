package hr.vodovod.services;

import java.util.Map;

import hr.vodovod.helper.CollectionResult;
import hr.vodovod.model.ConnectionRequestForm;

public interface ConnectionRequestFormService {
	
	CollectionResult<ConnectionRequestForm> getRequestsLazy(Integer offset, Integer limit, Map<String, String> filters);
}
