package com.ttnd.reap.service;

import java.util.List;

import com.ttnd.reap.pojo.BadgesTransaction;

public interface IBadgesTransactionService {
	List<BadgesTransaction> findBadgesTransaction(long max, int count);
}
