package com.ttnd.reap.service;

import java.util.List;

import com.ttnd.reap.pojo.EmployeeDetails;

public interface IEmailService {
	public void sendMail(List<EmployeeDetails> employeeList);
}
