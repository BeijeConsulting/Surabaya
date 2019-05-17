package it.beije.surabaya.pool;

import java.time.LocalDateTime;
import java.time.Period;

public class ConnectionPool {
	
	private final static int numConnections = 3;
	private static MyConnection[] connections = null;

	private static void init() {
		connections = new MyConnection[numConnections];
//		for(MyConnection c : connections) {
//			c = new MyConnection();
//		}
	}
	
	public static MyConnection getConnection() {
		
		if(connections==null) {
			init();
		}
		
		for(MyConnection c : connections) {
			
			if(c==null) {
				c = new MyConnection();
				return c;
			}else if(c.isAvailable()) {
				c.setAvailable(false);
				c.setTimestamp(LocalDateTime.now());
				return c;
			}
		}
		
		return null; //tenere in attesa il richiedente ?
	}
	
	public static void closeConnection(MyConnection c){
		
		c.setAvailable(true);
		c.setTimestamp(null);
		
	}
	
	public static void closeConnections(Period time) {
		
	}
	
	
	public static void main(String [] args) {
		
		MyConnection c1 = getConnection();
		System.out.println(c1.isAvailable());
		
		for(MyConnection c : connections) {
			System.out.println(c);
		}
		
		closeConnection(c1);
		
		for(MyConnection c : connections) {
			System.out.println(c);
		}
		
		System.out.println(c1.isAvailable());
		
		System.out.println(connections);
		
		MyConnection c2 = getConnection();
		System.out.println(c1.isAvailable());
		System.out.println(c2.isAvailable());
		
		System.out.println(connections);

	}
	

}
