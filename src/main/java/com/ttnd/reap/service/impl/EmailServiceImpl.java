package com.ttnd.reap.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ttnd.reap.MailAPI.SendEmail;
import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.service.IEmailService;

@Service
public class EmailServiceImpl implements IEmailService {

	@Override
	public void sendMail(List<EmployeeDetails> employeeList) {
		SendEmail.sendMail(employeeList);
	}

}
