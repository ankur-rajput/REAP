package com.ttnd.reap.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttnd.reap.customExceptions.ZeroBadgesException;
import com.ttnd.reap.dao.IBadgeTransactionDao;
import com.ttnd.reap.dao.IReceivedBadgesDao;
import com.ttnd.reap.dao.IRemainingBadgesDao;
import com.ttnd.reap.pojo.BadgeTransaction;
import com.ttnd.reap.service.IBadgeTransactionService;

@Service
public class BadgeTransactionServiceImpl implements IBadgeTransactionService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private IBadgeTransactionDao badgeTransactionDao;

	@Autowired
	private IReceivedBadgesDao receivedBadgesDao;

	@Autowired
	private IRemainingBadgesDao remainingBadgesDao;

	@Override
	public int recognizeKarma(BadgeTransaction badgeTransaction) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean updateSenderBadgesSuccessfully;
		try {
			if (badgeTransaction.getBadge().equals("gold")) {
				updateSenderBadgesSuccessfully = remainingBadgesDao.updateGold(badgeTransaction.getSenderId());
				if (!updateSenderBadgesSuccessfully)
					throw new ZeroBadgesException();
				receivedBadgesDao.updateGold(badgeTransaction.getReceiverId());
			} else if (badgeTransaction.getBadge().equals("silver")) {
				updateSenderBadgesSuccessfully = remainingBadgesDao.updateSilver(badgeTransaction.getSenderId());
				if (!updateSenderBadgesSuccessfully)
					throw new ZeroBadgesException();
				receivedBadgesDao.updateSilver(badgeTransaction.getReceiverId());
			} else {
				updateSenderBadgesSuccessfully = remainingBadgesDao.updateBronze(badgeTransaction.getSenderId());
				if (!updateSenderBadgesSuccessfully)
					throw new ZeroBadgesException();
				receivedBadgesDao.updateBronze(badgeTransaction.getReceiverId());
			}

			badgeTransactionDao.save(badgeTransaction);

			transaction.commit();
			session.close();
			return 1;
		} catch (ZeroBadgesException e) {
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			transaction.rollback();
			session.close();
			e.printStackTrace();
			return 0;
		}
	}

}
