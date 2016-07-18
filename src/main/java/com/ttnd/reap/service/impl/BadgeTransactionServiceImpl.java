package com.ttnd.reap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttnd.reap.dao.IBadgeTransactionDao;
import com.ttnd.reap.pojo.BadgeTransaction;
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
}
