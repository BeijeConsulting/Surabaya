package it.beije.surabaya.pool;

import java.time.LocalDateTime;

public class ConnectionPool {
	
	private final static int numConnections = 10;
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
	
	
	
	

}
