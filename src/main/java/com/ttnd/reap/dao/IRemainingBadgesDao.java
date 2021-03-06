package com.ttnd.reap.dao;

import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.pojo.RemainingBadges;

public interface IRemainingBadgesDao {
	public void save(EmployeeDetails employeeDetails);
	public RemainingBadges getRemainingBadgesOfEmployee(EmployeeDetails employeeDetails);
	public boolean updateGold(int employeeId);
	public boolean updateSilver(int employeeId);
	public boolean updateBronze(int employeeId);
}
