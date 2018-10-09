package hr.vodovod.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import hr.vodovod.exception.ConstraintException;
import hr.vodovod.helper.CollectionResult;
import hr.vodovod.jpa.repositories.ConnectionRepository;
import hr.vodovod.model.Connection;

@Service
public class ConnectionServiceImpl implements ConnectionService {
	
	@Autowired
	private ConnectionRepository connectionRepository;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional(rollbackOn=ConstraintException.class)
	public Connection save(Connection connection) throws ConstraintException{
		Connection conn = null;
		try
		{
			//conn = connectionRepository.save(connection);
			conn = entityManager.merge(connection);
			
		}
		catch(PersistenceException ex)
		{	
			Throwable th = ex.getCause();
			if(th instanceof ConstraintViolationException)
			{
				if(((ConstraintViolationException)th).getConstraintName().contains("REGISTRY_BOOK_MUNICIPALITY_UNIQUE"))
				{
					throw new ConstraintException(
					"Matièni broj prikljuèka: " + connection.getRegistryBookNo() +
					" veæ se koristi u matiènoj knjizi prikljuèaka za opæinu " +
					connection.getCadastralMunicipality().getName());
				}
				else if(((ConstraintViolationException)th).getConstraintName().contains("OIB_UNIQUE"))
				{
					throw new ConstraintException("Oib: " + 
				    connection.getRequestForm().getSubmitter().getOib() +
				    " se veæ koristi!");
				}
			}
		}
		return conn;
	}
	
	@Override
	public Connection getOne(Integer id) {
		return connectionRepository.getOne(id);
	}
	
	@Override
	public List<Connection> getAll() {
		return connectionRepository.findAll();
	}
	
	@Override
	public CollectionResult<Connection> getConnectionsLazy(Integer offset, Integer limit, @RequestParam Map<String, String> filters){
		
		CollectionResult<Connection> result = new CollectionResult<>();
		
		String selectString = "FROM Connection c WHERE ((((c.registryBookNo LIKE CONCAT('%1', ?, '%')" + 
			    " OR CONCAT(c.requestForm.submitter.name, ' ', c.requestForm.submitter.surnameNickname) LIKE CONCAT('%', ?, '%')" + 
			    " OR c.requestForm.submitter.oib LIKE CONCAT('%', ?, '%')" + 
			    " OR c.address LIKE CONCAT('%', ?, '%'))" +
			    " AND c.registryBookNo LIKE CONCAT('%', ?, '%'))" + 
			    " AND CONCAT(c.requestForm.submitter.name, ' ', c.requestForm.submitter.surnameNickname) LIKE CONCAT('%', ?, '%'))" + 
			    " AND c.requestForm.submitter.oib LIKE CONCAT('%', ?, '%'))" +
			    " AND c.address LIKE CONCAT('%', ?, '%')";

		
		String countString = "SELECT COUNT (c) " + selectString;
		
		TypedQuery<Connection> selectQuery = entityManager.createQuery(selectString, Connection.class);
		selectQuery.setParameter(0, filters.get("global"));
		selectQuery.setParameter(1, filters.get("global"));
		selectQuery.setParameter(2, filters.get("global"));
		selectQuery.setParameter(3, filters.get("global"));
		selectQuery.setParameter(4, filters.get("registryBookNo"));
		selectQuery.setParameter(5, filters.get("fullName"));
		selectQuery.setParameter(6, filters.get("oib"));
		selectQuery.setParameter(7, filters.get("address"));
		selectQuery.setFirstResult(offset);
		selectQuery.setMaxResults(limit);
	    
	    result.setData(selectQuery.getResultList());
	    
	    Query countQuery = entityManager.createQuery(countString);
	    countQuery.setParameter(0, filters.get("global"));
	    countQuery.setParameter(1, filters.get("global"));
	    countQuery.setParameter(2, filters.get("global"));
	    countQuery.setParameter(3, filters.get("global"));
	    countQuery.setParameter(4, filters.get("registryBookNo"));
	    countQuery.setParameter(5, filters.get("fullName"));
	    countQuery.setParameter(6, filters.get("oib"));
	    countQuery.setParameter(7, filters.get("address"));
	    
	    result.setTotalRecords((Long)countQuery.getSingleResult());

	    return result;
	}

	@Override
	public Map<String, Object> newConectionRequestReportData(Integer id) {
		
		Map<String, Object> datasourceParams = new HashMap<>();
		Connection connection = this.getOne(id);

		
		datasourceParams.put("fullName", connection.getRequestForm().getSubmitter().getFullName());
		datasourceParams.put("address", connection.getRequestForm().getSubmitter().getAddress());
		datasourceParams.put("oib", connection.getRequestForm().getSubmitter().getOib());
		datasourceParams.put("phone", connection.getRequestForm().getSubmitter().getPhone());
		datasourceParams.put("cadastralParcelNo", connection.getCadastralParcelNo());
		datasourceParams.put("cadastralMunicipality", connection.getCadastralMunicipality().getName());
		datasourceParams.put("settlementArea", connection.getSettlementArea());
		datasourceParams.put("connectionPurpose", connection.getConnectionPurpose().getName());
		datasourceParams.put("requestPurpose", connection.getRequestForm().getRequestPurpose().getName());
		datasourceParams.put("connectionCategory", connection.getConnectionCategory().getName());
		
		return datasourceParams;
	}

	@Override
	public Connection getConnectionByRequest(Integer requestId) {
		return connectionRepository.getConnectionByRequest(requestId);
	}
}
