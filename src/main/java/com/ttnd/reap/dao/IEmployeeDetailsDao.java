package com.ttnd.reap.dao;

import java.util.List;

import com.ttnd.reap.pojo.EmployeeDetails;

public interface IEmployeeDetailsDao {
	public int save(EmployeeDetails employeeDetails);

	public EmployeeDetails findEmployeeById(int id, String password);

	public EmployeeDetails findEmployeeByEmail(String email, String password);

	public List<EmployeeDetails> searchNewer(String term);
}
