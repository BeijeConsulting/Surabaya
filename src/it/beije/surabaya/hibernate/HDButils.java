package it.beije.surabaya.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HDButils {
	
//	public static Connection getConnection() throws ClassNotFoundException, SQLException {
//		Connection conn = null;
//		
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//		
//		return conn;
//	}

//	public static void main(String argv[]) {
//		
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rset= null;
//
//		try {
//			conn = HDButils.getConnection();
//			
//			stmt = conn.createStatement();
//
//			//INSERT
////			String insert = "INSERT INTO utenti VALUES (null, 'edi3', 'paperetti', 'edi3@paperetti.com', SYSDATE())";
////			stmt.execute(insert);
//
//			//SELECT
//			String query = "SELECT * from utenti";
//			rset = stmt.executeQuery(query);
//
//			while (rset.next()) {
//				int id = rset.getInt("id");
//				String nome = rset.getString("nome");
//				String cognome = rset.getString("cognome");
//				String email = rset.getString(4);
//
//				System.out.println("" + id + ", " + nome + ", " + cognome + ", " +  email);
//			}
//
//		}
//		catch (SQLException se) {
//			System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
//		}
//		catch(Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		finally {
//			try {
////				rset.close();
//				stmt.close();
//				conn.close();
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}

	public static void main(String argv[]) throws Exception {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
				//.addAnnotatedClass(Dipendente.class)
		
		System.out.println("is open?" + factory.isOpen());
		
		factory.close();
		System.out.println("is open?" + factory.isOpen());
	}
}