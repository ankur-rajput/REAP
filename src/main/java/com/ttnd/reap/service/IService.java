package com.ttnd.reap.service;

import java.util.List;

import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.pojo.ReceivedBadges;
import com.ttnd.reap.pojo.RemainingBadges;

public interface IService {
	public int save(EmployeeDetails employeeDetails);

	public EmployeeDetails findEmployeeById(int id, String password);

	public EmployeeDetails findEmployeeByEmail(String email, String password);

	public ReceivedBadges getReceivedBadgesOfEmployee(EmployeeDetails employeeDetails);

	public RemainingBadges getRemainingBadgesOfEmployee(EmployeeDetails employeeDetails);

	public List<ReceivedBadges> getReceivedBadgesList();

}
