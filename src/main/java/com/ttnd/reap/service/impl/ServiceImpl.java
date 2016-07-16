package com.ttnd.reap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttnd.reap.dao.IEmployeeDetailsDao;
import com.ttnd.reap.dao.IReceivedBadgesDao;
import com.ttnd.reap.dao.IRemainingBadgesDao;
import com.ttnd.reap.pojo.BadgeTransaction;
import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.pojo.ReceivedBadges;
import com.ttnd.reap.pojo.RemainingBadges;
import com.ttnd.reap.service.IService;

@Service
public class ServiceImpl implements IService {

	@Autowired
	private IEmployeeDetailsDao employeeDetailsDao;

	@Autowired
	private IReceivedBadgesDao receivedBadgesDao;

	@Autowired
	private IRemainingBadgesDao remainingBadgesDao;

	// @Autowired
	// private HttpSession httpSession;

	@Override
	public int save(EmployeeDetails employeeDetails) {
		employeeDetails.setEmail(employeeDetails.getUser_name() + "@tothenew.com");
		//employeeDetails.setRole("User");
		int success=employeeDetailsDao.save(employeeDetails);
		if(success==1){
			receivedBadgesDao.save(employeeDetails);
			remainingBadgesDao.save(employeeDetails);			
		}
		return success;
	}

	@Override
	public EmployeeDetails findEmployeeById(int id, String password) {
		return employeeDetailsDao.findEmployeeById(id, password);
	}

	@Override
	public EmployeeDetails findEmployeeByEmail(String email, String password) {
		if (!email.contains("@tothenew.com"))
			email += "@tothenew.com";

		return employeeDetailsDao.findEmployeeByEmail(email, password);
	}

	@Override
	public void recognizeKarma(BadgeTransaction badgeTransaction) {

	}

	@Override
	public ReceivedBadges getReceivedBadgesOfEmployee(EmployeeDetails employeeDetails) {
		return receivedBadgesDao.getReceivedBadgesOfEmployee(employeeDetails);
	}

	@Override
	public RemainingBadges getRemainingBadgesOfEmployee(EmployeeDetails employeeDetails) {
		return remainingBadgesDao.getRemainingBadgesOfEmployee(employeeDetails);
	}

}
