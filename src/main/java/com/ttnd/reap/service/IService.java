package com.ttnd.reap.service;

import com.ttnd.reap.pojo.EmployeeDetails;

public interface IService {
	public void save(EmployeeDetails employeeDetails);
	public EmployeeDetails findEmployeeById(int id, String password);
	public EmployeeDetails findEmployeeByEmail(String email, String password);
}
