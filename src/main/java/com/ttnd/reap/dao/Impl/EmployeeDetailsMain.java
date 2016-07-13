package com.ttnd.reap.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jasypt.util.password.BasicPasswordEncryptor;

import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.pojo.RemainingBadges;

public class EmployeeDetailsMain {
	public static void main(String[] args) {
		
		RemainingBadges remainingBadges=new RemainingBadges();

		EmployeeDetails emp1 = new EmployeeDetails();
		emp1.setId(35);
		emp1.setEmail("ankur@tothenew.com");
		emp1.setName("Ishwar TTND");
		emp1.setPractice("Intern");
		emp1.setServiceLine("TTN-Intern");
		emp1.setRole("CONTRACTUAL");
		emp1.setRemainingBadges(remainingBadges);

		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		emp1.setPassword(passwordEncryptor.encryptPassword("pass"));

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(emp1);
		session.save(remainingBadges);
		session.getTransaction().commit();
		session.close();
	}
}
