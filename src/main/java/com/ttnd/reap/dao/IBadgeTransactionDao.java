package com.ttnd.reap.dao;

import java.util.List;

import com.ttnd.reap.pojo.BadgeTransaction;

public interface IBadgeTransactionDao {
	public int save(BadgeTransaction badgeTransaction);

	public List<BadgeTransaction> badgeTransactionList();
}
