package it.beije.surabaya.hibernate;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import it.beije.surabaya.hibernate.entities.User;

public class HTSutils {
	
	static SessionFactory factory = new Configuration().configure()
			.addAnnotatedClass(User.class)
			.buildSessionFactory();
	
	public static void main(String[] args) throws Exception {
		
		User result = getUser(6);
		if(result!=null) {
			System.out.println(result.getFirstName());
		}else {
			System.out.println("Nessun utente trovato con questo ID");
		}
		
		result = getUser("ASC456Co67CD78CG");
		if(result!=null) {
			System.out.println(result.getFirstName());
		}else {
			System.out.println("Nessun utente trovato con questo codice fiscale");
		}
		
		List results;
		
		results = getUsers("bauu", "dilllo");
		
		if(results.isEmpty()) {
			System.out.println("Nuessun utente con questo nome e cognome");
		}else {
			for(Object o:results) {
				result = (User) o;
				System.out.println(result.getId());
			}
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("cerca utente per nome e cognome");
		String ricerca = scan.nextLine();
		String[] campi = ricerca.split(" ");
		results = getUsers(campi[0], campi[1]);
		
		if(results.isEmpty()) {
			System.out.println("Nuessun utente con questo nome e cognome");
		}else {
			for(Object o:results) {
				result = (User) o;
				System.out.println(result.getId());
			}
		}
		
//		scan = new Scanner(System.in);
//		System.out.println("cerca utente per nome, cognome e email personale");
//		ricerca = scan.nextLine();
//		campi = ricerca.split(" ");
//		results = getUsers(campi[0], campi[1], campi[2]);
//		
//		if(results.isEmpty()) {
//			System.out.println("Nuessun utente con questo nome, cognome ed email");
//		}else {
//			for(Object o:results) {
//				result = (User) o;
//				System.out.println(result.getId());
//			}
//		}
//		
//		scan = new Scanner(System.in);
//		System.out.println("cerca utente per nome, cognome, email personale e di lavoro");
//		ricerca = scan.nextLine();
//		campi = ricerca.split(" ");
//		results = getUsers(campi[0], campi[1], campi[2], campi[3]);
//		
//		if(results.isEmpty()) {
//			System.out.println("Nuessun utente con questo nome, cognome e queste email");
//		}else {
//			for(Object o:results) {
//				result = (User) o;
//				System.out.println(result.getId());
//			}
//		}
		
	}

	public static SessionFactory getFactory() throws Exception {
		
		if(factory.isClosed()) {
			factory = new Configuration().configure()
					.addAnnotatedClass(User.class)
					.buildSessionFactory();
		}
				
		System.out.println("is open?" + factory.isOpen());
				
		return factory;
	}
	
	public static User getUser(int id) throws Exception {
		
		SessionFactory factory = getFactory();
		Session session = factory.openSession();
		
		User utente = session.get(User.class, id);
		
		session.close();
		factory.close();
		
		return utente;
		
	}
	
	public static User getUser(String fiscalCode) throws Exception {
		
		SessionFactory factory = getFactory();
		Session session = factory.openSession();
		
		Criteria criteria = session.createCriteria(User.class);
		List utente = criteria.add(Restrictions.eq("fiscalCode", fiscalCode)).list();
		System.out.println(utente.get(0));
		session.close();
		factory.close();
		
		return (User) utente.get(0);
		
	}
	
	public static List getUsers(String firstName, String lastName) throws Exception {
		return getUsers(firstName, lastName, null);
	}

	private static List getUsers(String firstName, String lastName, String personalEmail) throws Exception {
		return getUsers(firstName, lastName, personalEmail, null);
	}
	
//	private static void getUsers(String firstName, String lastName, String workEmail) {
//		getUsers(firstName, lastName, null, workEmail);
//	}

	private static List getUsers(String firstName, String lastName, String personalEmail, String workEmail) throws Exception {
		
		SessionFactory factory = getFactory();
		Session session = factory.openSession();
		
		Criteria criteria = session.createCriteria(User.class);
		List utenti = criteria
				.add(Restrictions.eq("firstName", firstName))
				.add(Restrictions.eq("lastName", lastName))
				.list();
		session.close();
		factory.close();
		
		return utenti;
	}
}
