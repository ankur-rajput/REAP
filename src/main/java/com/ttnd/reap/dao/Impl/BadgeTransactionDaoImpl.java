package com.ttnd.reap.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttnd.reap.dao.IBadgeTransactionDao;
import com.ttnd.reap.pojo.BadgeTransaction;

@Repository
public class BadgeTransactionDaoImpl implements IBadgeTransactionDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean save(BadgeTransaction badgeTransaction) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(badgeTransaction);
			transaction.commit();
			session.close();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			session.close();
			return false;
		}
	}

}
