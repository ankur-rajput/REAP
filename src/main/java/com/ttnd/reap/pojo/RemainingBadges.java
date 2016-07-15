package com.ttnd.reap.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class RemainingBadges {
	@Id
	@GeneratedValue
	private int Id;
	private int gold = 3, silver = 2, bronze = 1;
	@OneToOne
	@JoinColumn(name = "employeeId")
	private EmployeeDetails employeeDetails;

	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getSilver() {
		return silver;
	}

	public void setSilver(int silver) {
		this.silver = silver;
	}

	public int getBronze() {
		return bronze;
	}

	public void setBronze(int bronze) {
		this.bronze = bronze;
	}

}
