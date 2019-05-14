package timesheet;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")


public class metget {
	
	public static Session getSession() throws Exception{
		SessionFactory factory= new Configuration().configure().addAnnotatedClass(metget.class).buildSessionFactory();
		System.out.println("is open? " + factory.isOpen());
		
		return factory.openSession();
	}
	
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="personal_email")
	private String personalEmail;
	
	@Column(name="work_email")
	private String workEmail;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="fiscal_code")
	private String fiscalCode;
	
	@Column(name="admin")
	private Boolean admin;
	
	@Column(name="password")
	private String password;
	
	public static void getUser(int id){
		
	}
	
	public static void getUser(String fiscalCode){
		
	}
	
	public static String[] getUser(String firstName, String lastName) {
		String[] ar=new String[4];
		ar=getUser(firstName, lastName, null, null);
		return ar;
	}
	
	public static String[] getUser(String firstName, String lastName, String personalEmail) {
		String[] ar=new String[4];
		ar=getUser(firstName, lastName, personalEmail, null);
		return ar;
	}
	
	public static String[] getUser(String firstName, String lastName, String personalEmail, String workEmail) {
		String[] ar=new String[4];
		ar[0]=firstName;
		ar[1]=lastName;
		ar[2]=personalEmail;
		ar[3]=workEmail;
		return ar;
	}
	
}
