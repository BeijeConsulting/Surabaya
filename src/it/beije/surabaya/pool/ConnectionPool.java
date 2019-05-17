package it.beije.surabaya.pool;

import java.time.LocalDateTime;
import java.time.Period;


public class ConnectionPool {
	
	private static final int numConnections = 10;
	private static MyConnection[] connections = null;
	
	private static void init() {
		connections = new MyConnection[numConnections];
//		for (MyConnection c : connections) {
//			c = new MyConnection();
//		}
	}
	
	public static MyConnection getConnection() {
		if (connections == null) {
			init();
		}
		
		for (int i=0; i < numConnections; i++) {
			if (connections[i] == null) {
				connections[i] = new MyConnection();
				
				return connections[i];
			} else if (connections[i].isAvailable()) {
				connections[i].setAvailable(false);
				connections[i].setTimestamp(LocalDateTime.now());
				
				return connections[i];
			}
		}
		
		return null;//tenere in attesa il richiedente ?
	}
	
//	public static void closeConnection(MyConnection c) {
//		c.setAvailable(true);
//		c.setTimestamp(null);
//	}
	
	public static void closeConnections(Period expiredTime) {
		for (MyConnection c : connections) {
			if (!c.isAvailable()) {
				if (c.getTimestamp() == null ||
					c.getTimestamp().plus(expiredTime).isBefore(LocalDateTime.now())
					) {
					c.close();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		MyConnection connection = ConnectionPool.getConnection();
		//...
		//ConnectionPool.closeConnection(connection);
		connection.close();
	}
}
