package com.ttnd.reap.dao.Impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttnd.reap.customExceptions.ZeroBadgesException;
import com.ttnd.reap.dao.IBadgeTransactionDao;
import com.ttnd.reap.dao.IReceivedBadgesDao;
import com.ttnd.reap.dao.IRemainingBadgesDao;
import com.ttnd.reap.pojo.BadgeTransaction;

@SuppressWarnings("deprecation")
@Repository
public class BadgeTransactionDaoImpl implements IBadgeTransactionDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private IReceivedBadgesDao receivedBadgesDao;

	@Autowired
	private IRemainingBadgesDao remainingBadgesDao;

	@Override
	public int save(BadgeTransaction badgeTransaction) {
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
			session.save(badgeTransaction);
			transaction.commit();
			return 1;
		} catch (ZeroBadgesException e) {
			transaction.rollback();
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return 0;
		} finally {
			session.close();
		}
	}

	@Override
	public List<BadgeTransaction> badgeTransactionList() {
		List<BadgeTransaction> badgeTransactions = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(BadgeTransaction.class).addOrder(Order.desc("date"));
			badgeTransactions = criteria.list();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return badgeTransactions;
	}

}
