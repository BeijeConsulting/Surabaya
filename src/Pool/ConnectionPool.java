package Pool;

import java.util.*;

public class ConnectionPool {
	
	static public Connector newConnection(Connector c, String u, Time t ){
		
		c.user = u;
		c.time = t;
		
		return c;
	};
	
	static public void closeConnection(Connector c, String u) {
		
		c.user = null;
		c.time = null;
		
	};
	
	
	//da sostituire con util date e da implementare i metodi per il calcolo con le date 
	public Time getPassedTime(Time t, Time now) {
		
		Time time = now - t;
		
		return  t;};
		
	static public void timeOut(Connector c, Time now)	{};
	
	public static void main(String[] args) {
		
		ArrayList<Connector> str = new ArrayList<Connector>();
		String userRequest = new String();
		String user = new String();
		Time now = new Time();
		
		
		//manca: lettura richiesta utente, lettura nome user
		
		if(userRequest == "add") {
			Connection con = new Connection();
			Connector c = new Connector(con);
			str.add(ConnectionPool.newConnection(c, user, now));
		}else if (userRequest == "remove") {
			for(int i = 0; i < str.size(); i++) {
				if(((Connector)str.get(i)).user == user) {
					ConnectionPool.closeConnection(str.get(i), user);
				};
			}		
		}else {
			for(int i = 0; i < str.size(); i++) {
				ConnectionPool.timeOut(str.get(i), now);
			}
			
		}
	}

}
//da sostituire con le connessioni vere e proprie
class Connection{}

class Time{}

class Connector{
	
	public Connection connection;
	
	public String user;
	
	public Time time;
	
	public Connector(Connection c) {
		
		this.connection = c;
		this.user = null;
		this.time = null;
		
	};
}
