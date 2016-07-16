package com.ttnd.reap.dao;

import com.ttnd.reap.pojo.EmployeeDetails;

public interface IEmployeeDetailsDao {
	public int save(EmployeeDetails employeeDetails);
	public EmployeeDetails findEmployeeById(int id, String password);
	public EmployeeDetails findEmployeeByEmail(String email, String password);
}
