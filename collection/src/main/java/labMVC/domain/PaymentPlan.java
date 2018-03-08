package labMVC.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PaymentPlan")
public class PaymentPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String timePeriod;
	@Column
	String debtorName;
	@Column
	Double amount;
	@Column
	String reason;
	
	public PaymentPlan(){}


	public PaymentPlan(int id, String timePeriod, String debtorName, Double amount, String reason) {
		super();
		this.id = id;
		this.timePeriod = timePeriod;
		this.debtorName = debtorName;
		this.amount = amount;
		this.reason = reason;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}
	public String getDebtorName() {
		return debtorName;
	}
	public void setDebtorName(String debtorName) {
		this.debtorName = debtorName;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
