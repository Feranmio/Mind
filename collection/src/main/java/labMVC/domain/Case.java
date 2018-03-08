package labMVC.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "casee")
public class Case {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String reason;
	@Column
	String service;
	@Column
	String date;
	@Column
	Double amount = 0.0d;
	@Column 
	String info;
	@Column
	String debtorName;
	@Column
	String creditorName;
	@Column
	String paid = "no";

	public Case(){}
	
	public Case(int id, String reason, String service, String date, Double amount, String info, String debtorName,
			String creditorName, String paid) {
		super();
		this.id = id;
		this.reason = reason;
		this.service = service;
		this.date = date;
		this.amount = amount;
		this.info = info;
		this.debtorName = debtorName;
		this.creditorName = creditorName;
		this.paid = paid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getDebtorName() {
		return debtorName;
	}

	public void setDebtorName(String debtorName) {
		this.debtorName = debtorName;
	}

	public String getCreditorName() {
		return creditorName;
	}

	public void setCreditorName(String creditorName) {
		this.creditorName = creditorName;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}
	
}
