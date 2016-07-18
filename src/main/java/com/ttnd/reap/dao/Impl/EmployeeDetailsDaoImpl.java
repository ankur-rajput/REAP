package com.ttnd.reap.dao.Impl;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.jasypt.util.password.BasicPasswordEncryptor;
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
		EmployeeDetails employeeDetails = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(EmployeeDetails.class).add(Restrictions.eq("id", id));
			employeeDetails = (EmployeeDetails) criteria.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (employeeDetails != null) {
			if (new BasicPasswordEncryptor().checkPassword(password, employeeDetails.getPassword())) {
				return employeeDetails;
			}
		}
		return null;
	}

	@Override
	public EmployeeDetails findEmployeeByEmail(String email, String password) {
		EmployeeDetails employeeDetails = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(EmployeeDetails.class).add(Restrictions.eq("email", email));
			employeeDetails = (EmployeeDetails) criteria.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (employeeDetails != null) {
			if (new BasicPasswordEncryptor().checkPassword(password, employeeDetails.getPassword())) {
				return employeeDetails;
			}
		}
		return null;
	}

}
