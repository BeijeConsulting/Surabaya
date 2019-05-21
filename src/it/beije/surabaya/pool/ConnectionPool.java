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
		if (connections == null) {
			init();
		}
		
		for (int i=0; i < numConnections; i++) {
			if (connections[i] == null) {
				connections[i] = new MyConnection(i);
				
				return connections[i];
			} else if (connections[i].isAvailable()) {
				connections[i].setAvailable(false);
				connections[i].setTimestamp(LocalDateTime.now());
				
				return connections[i];
			}
		}
		
		return null;//tenere in attesa il richiedente ?
	}
	
//	public static void closeConnection(MyConnection c){
//		
//		c.setAvailable(true);
//		c.setTimestamp(null);
//		
//	}
	
	public static void closeConnections(Period expiredTime) {
		
		for(MyConnection c : connections) {
			if(!c.isAvailable()) {
				if (c.getTimestamp() == null || 
					c.getTimestamp().plus(expiredTime).isBefore(LocalDateTime.now())
				) {
					c.close();
				}
			}
		}
	}
	
	
	public static void main(String [] args) {
		
		MyConnection c1 = getConnection();
		
		for(MyConnection c : connections) {
			System.out.println(c);
		}
		System.out.println(c1);
		c1.close();
		
		for(MyConnection c : connections) {
			System.out.println(c);
		}
		
		System.out.println(c1.getId());
		System.out.println(c1.isAvailable());
		
		
		MyConnection c2 = getConnection();
		System.out.println(c1.getId());
		System.out.println(c1.isAvailable());
		System.out.println(c2.getId());
		System.out.println(c2.isAvailable());
		
		for(MyConnection c : connections) {
			System.out.println(c);
		}
		
		MyConnection c3 = getConnection();
		System.out.println(c3.getId());
		System.out.println(c3.isAvailable());
		
		
		for(MyConnection c : connections) {
			System.out.println(c);
		}
		
		MyConnection c4 = getConnection();
		System.out.println(c4.getId());
		System.out.println(c4.isAvailable());
		
		c4.close();
		
		MyConnection c5 = getConnection();
		System.out.println(c5.getId());
		System.out.println(c5.isAvailable());
		
		c3.close();
		
		for(MyConnection c : connections) {
			System.out.println(c);
		}
		

	}
	
}
