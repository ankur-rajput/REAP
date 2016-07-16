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

}
