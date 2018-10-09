package hr.vodovod.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="connection_request_form")
public class ConnectionRequestForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  ConnectionRequestForm() {

	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="submission_date")
	private LocalDate submissionDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="submitter", referencedColumnName="id")
	private Person submitter;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="request_type", referencedColumnName="id")
	private RequestType requestType;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="request_purpose", referencedColumnName="id")
	private RequestPurpose requestPurpose;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="author", referencedColumnName="id")
	private User author;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Person getSubmitter() {
		return submitter;
	}

	public void setSubmitter(Person submitter) {
		this.submitter = submitter;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}
	
	public RequestPurpose getRequestPurpose() {
		return requestPurpose;
	}

	public void setRequestPurpose(RequestPurpose requestPurpose) {
		this.requestPurpose = requestPurpose;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	
}
