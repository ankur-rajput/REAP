package com.ttnd.reap.dao.Impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttnd.reap.dao.IReceivedBadgesDao;
import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.pojo.ReceivedBadges;

@SuppressWarnings("deprecation")
@Repository
public class ReceivedBadgesDaoImpl implements IReceivedBadgesDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ReceivedBadges getReceivedBadgesOfEmployee(EmployeeDetails employeeDetails) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ReceivedBadges.class)
				.add(Restrictions.eq("employeeDetails", employeeDetails));
		return (ReceivedBadges) criteria.uniqueResult();
	}

	@Override
	public void save(EmployeeDetails employeeDetails) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			ReceivedBadges receivedBadges = new ReceivedBadges();
			receivedBadges.setEmployeeDetails(employeeDetails);
			session.save(receivedBadges);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			session.close();
		}
	}

	@Override
	public boolean updateGold(int employeeId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ReceivedBadges.class).createCriteria("employeeDetails")
				.add(Restrictions.eq("id", employeeId));
		ReceivedBadges receivedBadges = (ReceivedBadges) criteria.uniqueResult();

		receivedBadges.setGold(receivedBadges.getGold() + 1);

		Transaction transaction = session.beginTransaction();
		try {
			session.update(receivedBadges);
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

	@Override
	public boolean updateSilver(int employeeId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ReceivedBadges.class).createCriteria("employeeDetails")
				.add(Restrictions.eq("id", employeeId));
		ReceivedBadges receivedBadges = (ReceivedBadges) criteria.uniqueResult();

		receivedBadges.setSilver(receivedBadges.getSilver() + 1);

		Transaction transaction = session.beginTransaction();
		try {
			session.update(receivedBadges);
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

	@Override
	public boolean updateBronze(int employeeId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ReceivedBadges.class).createCriteria("employeeDetails")
				.add(Restrictions.eq("id", employeeId));
		ReceivedBadges receivedBadges = (ReceivedBadges) criteria.uniqueResult();

		receivedBadges.setBronze(receivedBadges.getBronze() + 1);

		Transaction transaction = session.beginTransaction();
		try {
			session.update(receivedBadges);
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
