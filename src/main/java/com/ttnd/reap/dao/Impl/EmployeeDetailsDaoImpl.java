package com.ttnd.reap.dao.Impl;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ttnd.reap.dao.IEmployeeDetailsDao;
import com.ttnd.reap.pojo.EmployeeDetails;

@SuppressWarnings("deprecation")
@Repository
public class EmployeeDetailsDaoImpl implements IEmployeeDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int save(EmployeeDetails employeeDetails) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(employeeDetails);
			transaction.commit();
			session.close();
			return 1;
		} catch (PersistenceException e) {
			transaction.rollback();
			e.printStackTrace();
			session.close();
			return -1;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			session.close();
			return 0;
		}

	}

	@Override
	public EmployeeDetails findEmployeeById(int id, String password) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(EmployeeDetails.class).add(Restrictions.eq("id", id))
				.add(Restrictions.eq("password", password));
		return (EmployeeDetails) criteria.uniqueResult();
	}

	@Override
	public EmployeeDetails findEmployeeByEmail(String email, String password) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(EmployeeDetails.class).add(Restrictions.eq("email", email))
				.add(Restrictions.eq("password", password));
		return (EmployeeDetails) criteria.uniqueResult();
	}

}
