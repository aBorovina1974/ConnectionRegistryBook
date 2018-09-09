package hr.vodovod.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="connection_history")
public class ConnectionHistory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public ConnectionHistory() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="conection_id", referencedColumnName="id")
	private Connection connection;
	
	@ManyToOne
	@JoinColumn(name="modification_id", referencedColumnName="id")
	private Modification modification;
	
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name="author", referencedColumnName="id")
	private User author;
	
	@ManyToOne
	@JoinColumn(name="work_order_id", referencedColumnName="id")
	private WorkOrder workOrder;
	
	@ManyToOne
	@JoinColumn(name="current_owner", referencedColumnName="id")
	private Person currentOwner;
	
	@Column(name="current_registry_book_no")
	private String currentRegistryBookNo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Modification getModification() {
		return modification;
	}

	public void setModification(Modification modification) {
		this.modification = modification;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public WorkOrder getWorkOrder() {
		return workOrder;
	}

	public void setWorkOrder(WorkOrder workOrder) {
		this.workOrder = workOrder;
	}

	public Person getCurrentOwner() {
		return currentOwner;
	}

	public void setCurrentOwner(Person currentOwner) {
		this.currentOwner = currentOwner;
	}

	public String getCurrentRegistryBookNo() {
		return currentRegistryBookNo;
	}

	public void setCurrentRegistryBookNo(String currentRegistryBookNo) {
		this.currentRegistryBookNo = currentRegistryBookNo;
	}

}
