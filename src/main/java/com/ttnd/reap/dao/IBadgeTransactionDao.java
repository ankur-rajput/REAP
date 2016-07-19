package com.ttnd.reap.dao;

import java.util.List;

import com.ttnd.reap.pojo.BadgeTransaction;

public interface IBadgeTransactionDao {
	public int save(BadgeTransaction badgeTransaction);

	public List<BadgeTransaction> badgeTransactionList();
	
	public List<BadgeTransaction> allBadgeTransactionOfEmployee(int employeeId);
	
	public List<BadgeTransaction> sharedBadgeTransactionOfEmployee(int employeeId);
	
	public List<BadgeTransaction> receivedBadgeTransactionOfEmployee(int employeeId);
}
