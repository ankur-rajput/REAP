package com.ttnd.reap.dao.Impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttnd.reap.dao.IRemainingBadgesDao;
import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.pojo.RemainingBadges;

@SuppressWarnings("deprecation")
@Repository
public class RemainingBadgesDaoImpl implements IRemainingBadgesDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(EmployeeDetails employeeDetails) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			RemainingBadges remainingBadges = new RemainingBadges();
			remainingBadges.setEmployeeDetails(employeeDetails);
			session.save(remainingBadges);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public RemainingBadges getRemainingBadgesOfEmployee(EmployeeDetails employeeDetails) {
		RemainingBadges remainingBadges = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(RemainingBadges.class)
					.add(Restrictions.eq("employeeDetails", employeeDetails));
			remainingBadges = (RemainingBadges) criteria.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return remainingBadges;
	}

	@Override
	public boolean updateGold(int employeeId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Criteria criteria = session.createCriteria(RemainingBadges.class).createCriteria("employeeDetails")
					.add(Restrictions.eq("id", employeeId));
			RemainingBadges remainingBadges = (RemainingBadges) criteria.uniqueResult();

			int val = remainingBadges.getGold();
			if (val == 0)
				return false;
			remainingBadges.setGold(val - 1);
			session.update(remainingBadges);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
			System.out.println("inside finally in updateGold after return");
		}
	}

	@Override
	public boolean updateSilver(int employeeId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Criteria criteria = session.createCriteria(RemainingBadges.class).createCriteria("employeeDetails")
					.add(Restrictions.eq("id", employeeId));
			RemainingBadges remainingBadges = (RemainingBadges) criteria.uniqueResult();

			int val = remainingBadges.getSilver();
			if (val == 0)
				return false;
			remainingBadges.setSilver(val - 1);
			session.update(remainingBadges);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean updateBronze(int employeeId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Criteria criteria = session.createCriteria(RemainingBadges.class).createCriteria("employeeDetails")
					.add(Restrictions.eq("id", employeeId));
			RemainingBadges remainingBadges = (RemainingBadges) criteria.uniqueResult();

			int val = remainingBadges.getBronze();
			if (val == 0)
				return false;
			remainingBadges.setBronze(val - 1);
			session.update(remainingBadges);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

}
