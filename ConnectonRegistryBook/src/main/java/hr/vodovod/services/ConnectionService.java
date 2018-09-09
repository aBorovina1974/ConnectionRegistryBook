package hr.vodovod.services;

import java.util.List;
import java.util.Map;

import hr.vodovod.helper.CollectionResult;
import hr.vodovod.model.Connection;

public interface ConnectionService{
	
	Connection save(Connection connection);
	
	Connection getOne(Integer id);
	
	Connection getConnectionByRequest(Integer requestId);
	
	List<Connection> getAll();
	
	CollectionResult<Connection> getConnectionsLazy(Integer offset, Integer limit, Map<String, String> filters);
	
	public Map<String, Object> newConectionRequestReportData(Integer id);
}
