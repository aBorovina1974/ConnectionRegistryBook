package hr.vodovod.services;

import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hr.vodovod.helper.CollectionResult;
import hr.vodovod.model.ConnectionRequestForm;

@Service
public class ConnectionRequestFormServiceImpl implements ConnectionRequestFormService {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public CollectionResult<ConnectionRequestForm> getRequestsLazy(Integer offset, Integer limit, Map<String, String> filters) {

		CollectionResult<ConnectionRequestForm> result = new CollectionResult<>();
		
		String selectString = "FROM ConnectionRequestForm crf WHERE ((((crf.submissionDate LIKE CONCAT('%', ?, '%')" + 
			    " OR CONCAT(crf.submitter.name, ' ', crf.submitter.surnameNickname) LIKE CONCAT('%', ?, '%')" + 
			    " OR crf.submitter.oib LIKE CONCAT('%', ?, '%')" + 
			    " OR crf.requestType.name LIKE CONCAT('%', ?, '%'))" + 
			    " AND crf.submissionDate LIKE CONCAT('%', ?, '%'))" +
			    " AND CONCAT(crf.submitter.name, ' ', crf.submitter.surnameNickname) LIKE CONCAT('%', ?, '%'))" + 
			    " AND crf.submitter.oib LIKE CONCAT('%', ?, '%'))" + 
			    " AND crf.requestType.name LIKE CONCAT('%', ?, '%')";

		
		String countString = "SELECT COUNT (crf) " + selectString;
		
		TypedQuery<ConnectionRequestForm> selectQuery = entityManager.createQuery(selectString, ConnectionRequestForm.class);
		selectQuery.setParameter(0, filters.get("global"));
		selectQuery.setParameter(1, filters.get("global"));
		selectQuery.setParameter(2, filters.get("global"));
		selectQuery.setParameter(3, filters.get("global"));
		selectQuery.setParameter(4, filters.get("submissionDate"));
		selectQuery.setParameter(5, filters.get("fullName"));
		selectQuery.setParameter(6, filters.get("oib"));
		selectQuery.setParameter(7, filters.get("name"));
		selectQuery.setFirstResult(offset);
		selectQuery.setMaxResults(limit);
	    
	    result.setData(selectQuery.getResultList());
	    
	    Query countQuery = entityManager.createQuery(countString);
	    countQuery.setParameter(0, filters.get("global"));
	    countQuery.setParameter(1, filters.get("global"));
	    countQuery.setParameter(2, filters.get("global"));
	    countQuery.setParameter(3, filters.get("global"));
	    countQuery.setParameter(4, filters.get("submissionDate"));
	    countQuery.setParameter(5, filters.get("fullName"));
	    countQuery.setParameter(6, filters.get("oib"));
	    countQuery.setParameter(7, filters.get("name"));

	    result.setTotalRecords((Long)countQuery.getSingleResult());

	    return result;
	}

}
