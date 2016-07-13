package com.ttnd.reap.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ttnd.reap.pojo.BadgesTransaction;
import com.ttnd.reap.pojo.EmployeeDetails;
import com.ttnd.reap.pojo.RemainingBadges;

public class BadgesTransactionMain {
	public static void main(String[] args) {

		BadgesTransaction badgesTransaction = new BadgesTransaction();
		badgesTransaction.setBadge("gold");
		badgesTransaction.setDate(new Date());
		badgesTransaction.setKarma("Pat on the pack");
		badgesTransaction.setReason("Meri marzi");
		badgesTransaction.setSenderId(35);
		badgesTransaction.setReceiverId(36);

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			session.save(badgesTransaction);

			Criteria criteria = session.createCriteria(EmployeeDetails.class)
					.add(Restrictions.eq("Id", badgesTransaction.getSenderId()))
					.createCriteria("remainingBadges");
			// .setProjection(Projections.property(badgesTransaction.getBadge()));
			//System.out.println(((EmployeeDetails)criteria.uniqueResult()).getName());
			RemainingBadges remainingBadges = (RemainingBadges) criteria.uniqueResult();

			if(badgesTransaction.getBadge().equals("gold")){
				int val=remainingBadges.getGold();
				if(val==0)
					throw new Exception();
				val--;
				remainingBadges.setGold(val);
			}
			else if(badgesTransaction.getBadge().equals("silver")){
				int val=remainingBadges.getSilver();
				if(val==0)
					throw new Exception();
				val--;
				remainingBadges.setSilver(val);
			}
			else{
				int val=remainingBadges.getBronze();
				if(val==0)
					throw new Exception();
				val--;
				remainingBadges.setBronze(val);
			}
			session.update(remainingBadges);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.close();
	}
}
