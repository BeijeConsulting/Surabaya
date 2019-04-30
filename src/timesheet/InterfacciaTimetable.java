package timesheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
//import java.util.ArrayList;
//import java.util.List;

//import chapter4.CSVutils;

public class InterfacciaTimetable {

	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Beije08";
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
		
		try {
			conn = getConnection();
			
			stmt = conn.createStatement();
			
			//utenti SELECT
			
			Scanner scan=new Scanner(System.in);
			System.out.println("Orari utenti: I-Inserisci, M-Modifica");
			
			String scelta=scan.nextLine().toLowerCase();
			String idUtente;
			String query = null;
			
			scelta=scan.nextLine().toLowerCase();
			
			if(scelta.equalsIgnoreCase("i")) {
				System.out.println("Inserisci ID utente");
				idUtente = scan.nextLine();
				System.out.println("Inserisci riga orario: L-Lavorativo, P-Permesso, F-Ferie, M-Malattia");
				
				switch (scelta) {
				case "l":
					query = TSutils.inserisciRigaLavorativa(idUtente);
					break;
				case "p":
					query =TSutils.inserisciRigaPermesso(idUtente);
					break;
				case "f":
					query =TSutils.inserisciRigaFerie(idUtente);
					break;
				case "m":
					query =TSutils.inserisciRigaMalattia(idUtente);
					break;
				default:
					System.out.println("Scelta sbagliata");
				}
			}else if(scelta.equalsIgnoreCase("m")) {
				System.out.println("Inserisci ID utente");
				idUtente = scan.nextLine();
				System.out.println("Inserisci riga orario: L-Lavorativo, P-Permesso, F-Ferie, M-Malattia");
				scelta=scan.nextLine().toLowerCase();
				switch (scelta) {
				case "l":
					query =TSutils.modificaRigaLavorativa(idUtente);
					break;
				case "p":
					query =TSutils.modificaRigaPermessi(idUtente);
					break;
				case "f":
					query =TSutils.modificaRigaFerie(idUtente);
					break;
				case "m":
					query =TSutils.modificaRigaMalattia(idUtente);
					break;
				default:
					System.out.println("Scelta sbagliata");
				}
			}
			
			
			if(query!=null) {
				stmt.execute(query);
			}
			scan.close();

			
		}catch (SQLException se) {
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