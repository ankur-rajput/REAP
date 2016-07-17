package com.ttnd.reap.dao;

import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.pojo.ReceivedBadges;

public interface IReceivedBadgesDao {
	public void save(EmployeeDetails employeeDetails);

	public ReceivedBadges getReceivedBadgesOfEmployee(EmployeeDetails employeeDetails);

	public boolean updateGold(int employeeId);

	public boolean updateSilver(int employeeId);

	public boolean updateBronze(int employeeId);
}
