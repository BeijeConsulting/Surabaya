package it.beije.surabaya.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.surabaya.hibernate.entities.TimeTable;
import it.beije.surabaya.hibernate.entities.User;

public class HibernateUtils {

	public static Session getSession() throws Exception {
		
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(TimeTable.class)
				.buildSessionFactory();
		
	System.out.println("is open?" + factory.isOpen());
	return factory.openSession();}
	
	public int getUrser(int id) {
		return id;
	}
	
}
