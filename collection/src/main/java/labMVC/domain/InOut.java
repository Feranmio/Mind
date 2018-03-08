package labMVC.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "InOut")
public class InOut {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	int caseId;
	@Column
	String name;
	@Column
	String date;
	@Column
	String employment;
	@Column
	String dependents;
	@Column
	String housing;
	@Column
	int income;
	@Column
	int outgoing;
	@Column
	int debts;
	@Column
	int available;
	@Column
	String info;
	
	public InOut(){}
	
	public InOut(int id, int caseId, String name, String date, String employment, String dependents, String housing,
			int income, int outgoing, int debts, int available, String info) {
		super();
		this.id = id;
		this.caseId = caseId;
		this.name = name;
		this.date = date;
		this.employment = employment;
		this.dependents = dependents;
		this.housing = housing;
		this.income = income;
		this.outgoing = outgoing;
		this.debts = debts;
		this.available = available;
		this.info = info;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCaseId() {
		return caseId;
	}
	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmployment() {
		return employment;
	}
	public void setEmployment(String employment) {
		this.employment = employment;
	}
	public String getDependents() {
		return dependents;
	}
	public void setDependents(String dependents) {
		this.dependents = dependents;
	}
	public String getHousing() {
		return housing;
	}
	public void setHousing(String housing) {
		this.housing = housing;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getOutgoing() {
		return outgoing;
	}
	public void setOutgoing(int outgoing) {
		this.outgoing = outgoing;
	}
	public int getDebts() {
		return debts;
	}
	public void setDebts(int debts) {
		this.debts = debts;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}	
	
}
