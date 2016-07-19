package com.ttnd.reap.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BadgeTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int senderId, receiverId;
	@OneToOne
	private EmployeeDetails sender, receiver;
	private Date date;
	private String badge, karma, reason;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
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

}
