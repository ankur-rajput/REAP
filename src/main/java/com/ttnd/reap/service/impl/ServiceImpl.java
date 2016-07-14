package com.ttnd.reap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttnd.reap.dao.IEmployeeDetailsDao;
import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.service.IService;

@Service
public class ServiceImpl implements IService{

	@Autowired
	private IEmployeeDetailsDao employeeDetailsDao;
	
//	@Autowired
//	private HttpSession httpSession;
	
	@Override
	public void save(EmployeeDetails employeeDetails) {
		employeeDetails.setEmail(employeeDetails.getEmail()+"@tothenew.com");
		employeeDetails.setRole("User");
		employeeDetailsDao.save(employeeDetails);
	}

	@Override
	public EmployeeDetails findEmployeeById(int id, String password) {
		return employeeDetailsDao.findEmployeeById(id, password);
	}

	@Override
	public EmployeeDetails findEmployeeByEmail(String email, String password) {
		return employeeDetailsDao.findEmployeeByEmail(email, password);
	}
	
}
