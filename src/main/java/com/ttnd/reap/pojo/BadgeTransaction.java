package com.ttnd.reap.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BadgeTransaction {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private EmployeeDetails sender,receiver;
	private Date date;
	private String badge, karma, reason;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmployeeDetails getSender() {
		return sender;
	}

	public void setSender(EmployeeDetails sender) {
		this.sender = sender;
	}

	public EmployeeDetails getReceiver() {
		return receiver;
	}

	public void setReceiver(EmployeeDetails receiver) {
		this.receiver = receiver;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public String getKarma() {
		return karma;
	}

	public void setKarma(String karma) {
		this.karma = karma;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
