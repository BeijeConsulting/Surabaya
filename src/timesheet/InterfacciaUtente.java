package timesheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import it.beije.surabaya.esempi.DButils;

public class InterfacciaUtente {

	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Beije03";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/beije?serverTimezone=CET";
		
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		
		return conn;
	}
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset= null;
		String idUtente = new String();
		String query = null;

		try {
			conn = InterfacciaUtente.getConnection();
			
			stmt = conn.createStatement();

			//INSERT
//			String insert = "INSERT INTO utenti VALUES (null, 'edi3', 'paperetti', 'edi3@paperetti.com', SYSDATE())";
//			stmt.execute(insert);


//a seguire vanno inseriti i campi necessari
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Cosa vuoi fare? c-Crea, m-Modifica, e-Elimina");
			
			String scelta = scan.nextLine().toLowerCase();
			switch(scelta) {
			case "c":
				query = TSutils.creaUtente();			
				break;
				
			case "m":
				System.out.println("inserire utente da modificare");
				idUtente = scan.nextLine();
				query = TSutils.modificaUtente(idUtente);
				break;
				
			case "e":
				System.out.println("inserire utente da eliminare");
				idUtente = scan.nextLine();
				query = TSutils.eliminaUtente(idUtente);
				break;
				
			default:
				System.out.println("ERRORE");
				break;
			}
			
			if(query != null) {
				stmt.execute(query);
				
			}
			
			
			
			
			//SELECT
//			String query = "SELECT * FROM user";
//			rset = stmt.executeQuery(query);
//			
//			
//			while (rset.next()) {
//				int id = rset.getInt("id");
//				String nome = rset.getString("first_name");
//				String cognome = rset.getString("last_name");
//
//				System.out.println("" + id + ", " + nome + ", " + cognome );
//			}

		}
		catch (SQLException se) {
			System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				//rset.close();
				stmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
