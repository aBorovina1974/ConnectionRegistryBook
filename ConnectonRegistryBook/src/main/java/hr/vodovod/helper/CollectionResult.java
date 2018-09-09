package hr.vodovod.helper;

import java.util.Collection;


public class CollectionResult<T> {

	private Collection<T> data;
	private Long totalRecords;
	
	public Collection<T> getData() {
		return data;
	}
	public void setData(Collection<T> data) {
		this.data = data;
	}
	public Long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
}
