package timesheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class InterfacciaTimetable {

	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Beije05";
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
						
			Scanner scan=new Scanner(System.in);
			
			//SELEZIONE SCELTA INIZIALE
			String scelta = null;
			System.out.println("Orari utenti: I-Inserisci, M-Modifica");
			scelta=scan.nextLine().toLowerCase();
			while(!(scelta.equalsIgnoreCase("i")||scelta.equalsIgnoreCase("m"))) {
				System.out.println("Scelta sbagliata!");
				System.out.println("Orari utenti: I-Inserisci, M-Modifica");
				scelta=scan.nextLine().toLowerCase();
			}
			
			//COLNTROLLO ID UTENTE SELEZIONATO
			String idUtente;
			System.out.println("Inserisci ID utente");
			idUtente = scan.nextLine();
			String check = "SELECT * FROM user WHERE id="+idUtente;
			rset = stmt.executeQuery(check);
			while(!rset.first()) {
				System.out.println("Utente inesistente per questo ID");
				System.out.println("Inserisci ID utente");
				idUtente = scan.nextLine();
				check = "SELECT * FROM user WHERE id="+idUtente;
				rset.close();
				rset = stmt.executeQuery(check);
			}
			rset.close();
			
			String query = null;
			
			//CREAZIONE RECORD TIMETABLE
			if(scelta.equalsIgnoreCase("i")) {
				
				System.out.println("Inserisci riga orario: L-Lavorativo, P-Permesso, F-Ferie, M-Malattia ");
				scelta=scan.nextLine().toLowerCase();
				switch (scelta) {
				case "l":
					query = TSutils.inserisciRigaLavorativa(idUtente);
					System.out.println(query);
					break;
				case "p":
					query = TSutils.inserisciRigaPermesso(idUtente);
					break;
				case "f":
					query = TSutils.inserisciRigaFerie(idUtente);
					break;
				case "m":
					query = TSutils.inserisciRigaMalattia(idUtente);
					break;	
				default: 
					System.out.println("Scelta sbagliata");
				}
				
			//MODIFICA RECORD TIMETABLE
			}else{
				
				//COLNTROLLO DATA SELEZIONATO
				String cercaData;
				LocalDate dataParsato = null;
				System.out.println("In quale data? yyyy-MM-dd");
				cercaData = scan.nextLine();
			
				try {
					DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					dataParsato = LocalDate.parse(cercaData, f);
				}	catch(DateTimeParseException e) {
					System.out.println("Formato data errato");
				}
							
				String controlla = "SELECT * FROM timetable WHERE id_user=" + idUtente + " AND date='"+dataParsato+"'";
				System.out.println(controlla);
				rset = stmt.executeQuery(controlla );
				while(!rset.first()) {
					System.out.println("Data inesistente per questo ID");
					System.out.println("In quale data? yyyy-MM-dd");
					cercaData = scan.nextLine();
					controlla = "SELECT * FROM timetable WHERE id_user=" + idUtente + " AND date='"+dataParsato+"'";
					rset.close();
					System.out.println(controlla);
					rset = stmt.executeQuery(controlla);
				}
				rset.close();
				query = null;
							
				
				System.out.println("Modifica orario: L-Lavorativo, P-Permesso, F-Ferie, M-Malattia");
				scelta=scan.nextLine().toLowerCase();
				switch (scelta) {
				case "l":
					query = TSutils.modificaRigaLavorativa(idUtente, dataParsato);
					break;
				case "p":
					query = TSutils.modificaRigaPermesso(idUtente);
					break;
				case "f":
					query = TSutils.modificaRigaFerie(idUtente);
					break;
				case "m":
					query = TSutils.modificaRigaMalattia(idUtente);
					break;
				default: 
					System.out.println("Scelta sbagliata");
				}
			}
			
			//ESECUZIONE QUERY (se non nulla)
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
