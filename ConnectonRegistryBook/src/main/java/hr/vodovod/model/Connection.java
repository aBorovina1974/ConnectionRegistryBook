package hr.vodovod.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="connection")
public class Connection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Connection() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="request_form_id", referencedColumnName="id")
	private ConnectionRequestForm requestForm;
	
	@OneToOne
	@JoinColumn(name="contract_id", referencedColumnName="id")
	private Contract contract;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="connection_category", referencedColumnName="id")
	private ConnectionCategory connectionCategory;
	
	@Column(name="connection_date")
	private LocalDate connectionDate;
	
	@ManyToMany
	@JoinTable(name="work_order_connection", 
	joinColumns=@JoinColumn(name="connection_id", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="work_order_id", referencedColumnName="id"))
	private List<WorkOrder> workOrderList = new ArrayList<>();
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="work_order_id", referencedColumnName="id")
//	private WorkOrder workOrder;
	
	@Column(name="registry_book_no")
	private String registryBookNo;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="owner", referencedColumnName="id")
	private Person owner;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="status", referencedColumnName="id")
	private Status status;
	
	@Column(name="cadastral_parcel_no")
	private String cadastralParcelNo;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="cadastral_municipality", referencedColumnName="id")
	private Municipality cadastralMunicipality;
	
	@Column(name="settlement_area")
	private String settlementArea;
	
	private String address;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="connection_purpose", referencedColumnName="id")
	private ConnectionPurpose connectionPurpose;
	
	@Column(name="has_drainage")
	private Boolean hasDrainage;
	
	private String documentation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ConnectionRequestForm getRequestForm() {
		return requestForm;
	}

	public void setRequestForm(ConnectionRequestForm requestForm) {
		this.requestForm = requestForm;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public ConnectionCategory getConnectionCategory() {
		return connectionCategory;
	}

	public void setConnectionCategory(ConnectionCategory connectionCategory) {
		this.connectionCategory = connectionCategory;
	}

	public LocalDate getConnectionDate() {
		return connectionDate;
	}

	public void setConnectionDate(LocalDate connectionDate) {
		this.connectionDate = connectionDate;
	}

	public List<WorkOrder> getWorkOrderList() {
		return workOrderList;
	}

	public void setWorkOrderList(List<WorkOrder> workOrderList) {
		this.workOrderList = workOrderList;
	}
	
//	public WorkOrder getWorkOrder() {
//		return workOrder;
//	}
//
//	public void setWorkOrder(WorkOrder workOrder) {
//		this.workOrder = workOrder;
//	}

	public String getRegistryBookNo() {
		return registryBookNo;
	}

	public void setRegistryBookNo(String registryBookNo) {
		this.registryBookNo = registryBookNo;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCadastralParcelNo() {
		return cadastralParcelNo;
	}

	public void setCadastralParcelNo(String cadastralParcelNo) {
		this.cadastralParcelNo = cadastralParcelNo;
	}

	public Municipality getCadastralMunicipality() {
		return cadastralMunicipality;
	}

	public void setCadastralMunicipality(Municipality cadastralMunicipality) {
		this.cadastralMunicipality = cadastralMunicipality;
	}

	public String getSettlementArea() {
		return settlementArea;
	}

	public void setSettlementArea(String settlementArea) {
		this.settlementArea = settlementArea;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ConnectionPurpose getConnectionPurpose() {
		return connectionPurpose;
	}

	public void setConnectionPurpose(ConnectionPurpose connectionPurpose) {
		this.connectionPurpose = connectionPurpose;
	}
	
	public Boolean getHasDrainage() {
		return hasDrainage;
	}

	public void setHasDrainage(Boolean hasDrainage) {
		this.hasDrainage = hasDrainage;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}




	
	
	
		
}
