package com.ttnd.reap.service;

import java.util.List;

import com.ttnd.reap.pojo.BadgeTransaction;
import com.ttnd.reap.pojo.EmployeeDetails;

public interface IBadgeTransactionService {
	public int recognizeKarma(BadgeTransaction badgeTransaction);

	public List<BadgeTransaction> wallOfFame();

	public List<BadgeTransaction> allBadgeTransactionOfEmployee(EmployeeDetails employeeDetails);

	public List<BadgeTransaction> allBadgeTransactionOfEmployee(int employeeId);

	public List<BadgeTransaction> sharedBadgeTransactionOfEmployee(EmployeeDetails employeeDetails);

	public List<BadgeTransaction> receivedBadgeTransactionOfEmployee(EmployeeDetails employeeDetails);
}
