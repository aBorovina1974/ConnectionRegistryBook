package hr.vodovod.services;

import java.util.List;
import hr.vodovod.model.Municipality;

public interface MunicipalityService {

	List<Municipality> getAll();
	Municipality getOne(Integer id);
}
