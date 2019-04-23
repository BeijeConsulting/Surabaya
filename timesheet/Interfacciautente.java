package timesheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Interfacciautente {
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "?JamesKirk12";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/beije?serverTimezone=CET";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		
		return conn;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rset= null;
		String idUtente = null;
		String query=null;
//		boolean risultato=true;
		try {
			conn = Interfacciautente.getConnection();
			
			stmt = conn.createStatement();

			//INSERT
//			String insert = "INSERT INTO gestionale.libreria (id, titolo, autore) VALUES (null, 'Ghiaccio Nero', 'Michael Connelly')";
//			stmt.execute(insert);

			//SELECT
			Scanner scan = new Scanner (System.in);
			Scanner scan2 = new Scanner (System.in);
			System.out.println("Cosa vuoi fare ? c-CREARE,m-MODIFICARE,e-ELIMINARE");
//			while (!scan.NextLine().equaLsIgnoreCase("Q"))  
			String scelta = scan.nextLine().toLowerCase();
			
			switch (scelta)  {
			case "c":
				query=TSutils.creaUtente();
				break;
			case "m":
				System.out.println("ID utente da modificare");
				idUtente = scan.nextLine();
				query=TSutils.modificaUtente(idUtente);
				break;
			case "e":
				System.out.println("ID utente da eliminare");
				idUtente = scan.nextLine();
				query=TSutils.eliminaUtente(idUtente);
				System.out.println(query);
				break;
			default:
				System.out.println("ERRORE");
				break;
			}
			
			if (query!=null)  {
				stmt.execute(query);
			}
		
			scan.close();

//			String query = "SELECT * from user";
//			rset = stmt.executeQuery(query);
			
//			while (rset.next()) {
//				int id = rset.getInt("id");
//				String nome = rset.getString("first_name");
//				String cognome = rset.getString("last_name");
//
//				System.out.println	("" + id + ", " + nome + ", " + cognome);
////				System.out.println (nome);
//				
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
//				rset.close();
				stmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
