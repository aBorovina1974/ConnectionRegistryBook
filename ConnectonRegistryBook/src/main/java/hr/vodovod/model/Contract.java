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
@Table(name="contract")
public class Contract implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Contract () {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="signing_date")
	private LocalDate signingDate;
	
	@ManyToOne
	@JoinColumn(name="contractor", referencedColumnName="id")
	private Person contractor;
	
	@Column(name="responsible_person")
	private String responsiblePerson;
	
	@ManyToOne
	@JoinColumn(name="author", referencedColumnName="id")
	private User author;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getSigningDate() {
		return signingDate;
	}

	public void setSigningDate(LocalDate signingDate) {
		this.signingDate = signingDate;
	}

	public Person getContractor() {
		return contractor;
	}

	public void setContractor(Person contractor) {
		this.contractor = contractor;
	}

	public String getResponsiblePerson() {
		return responsiblePerson;
	}

	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	
	
}
