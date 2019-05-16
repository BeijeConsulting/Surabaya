package it.beije.surabaya.pool;

public class ConnectionPool {

	private static ConnectionPool connessione;
	
	private ConnectionPool() {
		
	}
	
	public static synchronized ConnectionPool getConnection() {
		if ( connessione==null) {
		connessione = new ConnectionPool();
		}
		return connessione;
		}
}