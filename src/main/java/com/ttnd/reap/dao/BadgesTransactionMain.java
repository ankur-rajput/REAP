/*package com.ttnd.reap.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.ttnd.reap.pojo.BadgeTransaction;
import com.ttnd.reap.pojo.ReceivedBadges;
import com.ttnd.reap.pojo.RemainingBadges;

@SuppressWarnings("deprecation")
public class BadgesTransactionMain {
	
	public static void main(String[] args) {

		BadgeTransaction badgesTransaction = new BadgeTransaction();
		badgesTransaction.setBadge("gold");
		badgesTransaction.setDate(new Date());
		badgesTransaction.setKarma("Pat on the pack");
		badgesTransaction.setReason("Meri marzi");
		badgesTransaction.setSender(null);
		badgesTransaction.setReceiver(null);;

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		try {
			session.save(badgesTransaction);

			Criteria criteria1 = session.createCriteria(RemainingBadges.class)
					.add(Restrictions.eq("employeeId", badgesTransaction.getSenderId()));
			RemainingBadges remainingBadges = (RemainingBadges) criteria1.uniqueResult();
			
			Criteria criteria2 = session.createCriteria(RemainingBadges.class)
					.add(Restrictions.eq("employeeId", badgesTransaction.getReceiverId()));
			ReceivedBadges receivedBadges = (ReceivedBadges) criteria2.uniqueResult();

			if(badgesTransaction.getBadge().equals("gold")){
				int val=remainingBadges.getGold();
				if(val==0)
					throw new Exception();
				val--;
				remainingBadges.setGold(val);
				receivedBadges.setGold(receivedBadges.getGold()+1);
			}
			else if(badgesTransaction.getBadge().equals("silver")){
				int val=remainingBadges.getSilver();
				if(val==0)
					throw new Exception();
				val--;
				remainingBadges.setSilver(val);
				receivedBadges.setSilver(receivedBadges.getSilver()+1);
			}
			else{
				int val=remainingBadges.getBronze();
				if(val==0)
					throw new Exception();
				val--;
				remainingBadges.setBronze(val);
				receivedBadges.setBronze(receivedBadges.getBronze()+1);
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
*/