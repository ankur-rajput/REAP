package com.ttnd.reap.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class EmployeeDetails {
	@Id @GeneratedValue
	private int id;
	@Column(unique = true, nullable = false)
	private String email;
	//@Column(nullable = false)
	private String name, password, serviceLine, practice, role;
	private byte[] photo;

	@OneToOne
	@JoinColumn(name = "RemainingBadges_Id")
	private RemainingBadges remainingBadges;

	@OneToOne
	@JoinColumn(name = "ReceivedBadges_Id")
	private ReceivedBadges receivedBadges;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServiceLine() {
		return serviceLine;
	}

	public void setServiceLine(String serviceLine) {
		this.serviceLine = serviceLine;
	}

	public String getPractice() {
		return practice;
	}

	public void setPractice(String practice) {
		this.practice = practice;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public RemainingBadges getRemainingBadges() {
		return remainingBadges;
	}

	public void setRemainingBadges(RemainingBadges remainingBadges) {
		this.remainingBadges = remainingBadges;
	}

	public ReceivedBadges getReceivedBadges() {
		return receivedBadges;
	}

	public void setReceivedBadges(ReceivedBadges receivedBadges) {
		this.receivedBadges = receivedBadges;
	}
}