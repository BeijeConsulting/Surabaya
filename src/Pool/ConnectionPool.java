package Pool;

import java.util.*;

public class ConnectionPool {
	
	public Connector newConnection(Connector c, String u, Time t ){
		
		c.user = u;
		c.time = t;
		
		return c;
	};
	
	public void closeConnection() {};
	
	public Time getPassedTime(Time t, Time now) {
		
		Time time = now - t;
		
		return  t;};
		
	public void timeOut(ArrayList<Connector> str, Time now)	{};
	
	public static void main(String[] args) {
		
		ArrayList<Connector> str = new ArrayList<Connector>();
		String userRequest = new String();
		String user = new String();
		Time now = new Time();
		
		
		//manca: lettura richiesta utente, lettura nome user
		
		if(userRequest == "add") {
			Connection con = new Connection();
			Connector c = new Connector(con);
			str.add(c.newConnection(c, user, now));
		}
		
		
	} 

}

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
