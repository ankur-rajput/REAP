package com.ttnd.reap.service;

import java.util.List;

import com.ttnd.reap.pojo.BadgeTransaction;

public interface IBadgeTransactionService {
	public int recognizeKarma(BadgeTransaction badgeTransaction);

	public List<BadgeTransaction> wallOfFame();
}
