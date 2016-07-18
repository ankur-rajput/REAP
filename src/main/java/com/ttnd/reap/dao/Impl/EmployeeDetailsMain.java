package com.ttnd.reap.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jasypt.util.password.BasicPasswordEncryptor;

import com.ttnd.reap.pojo.EmployeeDetails;

public class EmployeeDetailsMain {

	public static void main(String[] args) {

		EmployeeDetails emp1 = new EmployeeDetails();
		emp1.setId(35);
		emp1.setEmail("ishwar@tothenew.com");
		emp1.setName("Ishwar TTND");
		emp1.setPractice("Intern");
		emp1.setServiceLine("TTN-Intern");
		// emp1.setPassword("pass");
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		emp1.setPassword(passwordEncryptor.encryptPassword("pass"));

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
	}
}
