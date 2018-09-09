package hr.vodovod.services;

import java.util.List;

import hr.vodovod.model.ConnectionCategory;

public interface ConnectionCategoryService {
	List<ConnectionCategory> getAll();
	ConnectionCategory getOne(Integer id);
}
