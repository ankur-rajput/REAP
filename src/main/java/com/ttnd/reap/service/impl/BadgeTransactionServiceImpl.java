package com.ttnd.reap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttnd.reap.dao.IBadgeTransactionDao;
import com.ttnd.reap.pojo.BadgeTransaction;
import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.service.IBadgeTransactionService;

@Service
public class BadgeTransactionServiceImpl implements IBadgeTransactionService {

	@Autowired
	private IBadgeTransactionDao badgeTransactionDao;

	@Override
	public int recognizeKarma(BadgeTransaction badgeTransaction) {
		return badgeTransactionDao.save(badgeTransaction);
	}

	@Override
	public List<BadgeTransaction> wallOfFame() {
		return badgeTransactionDao.badgeTransactionList();
	}

	@Override
	public List<BadgeTransaction> allBadgeTransactionOfEmployee(EmployeeDetails employeeDetails) {
		return badgeTransactionDao.allBadgeTransactionOfEmployee(employeeDetails.getId());
	}

	@Override
	public List<BadgeTransaction> sharedBadgeTransactionOfEmployee(EmployeeDetails employeeDetails) {
		return badgeTransactionDao.sharedBadgeTransactionOfEmployee(employeeDetails.getId());
	}

	@Override
	public List<BadgeTransaction> receivedBadgeTransactionOfEmployee(EmployeeDetails employeeDetails) {
		return badgeTransactionDao.receivedBadgeTransactionOfEmployee(employeeDetails.getId());
	}

	@Override
	public List<BadgeTransaction> allBadgeTransactionOfEmployee(int employeeId) {
		return badgeTransactionDao.allBadgeTransactionOfEmployee(employeeId);
	}

}
