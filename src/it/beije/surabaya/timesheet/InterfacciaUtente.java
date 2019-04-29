package it.beije.surabaya.timesheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


//import java.util.ArrayList;
//import java.util.List;

//import chapter4.CSVutils;

public class InterfacciaUtente {

	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Beije04";
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
			System.out.println("Cosa vuoi fare? c-Crea, m-Modifica, e-Elimina, i-Importa CSV, ex1-Esporta CSV, ex2-Esporta XML");
			
			String scelta=scan.nextLine().toLowerCase();
			String idUtente;
			String path; //Path da inserire quando si sceglie di importare CSV o esportare DB
			String query = null;
			String[] query_array = null;
			
			switch (scelta) {
			//CREAZIONE NUOVO RECORD USER
			case "c":
				query = TSutils.creaUtente();
				String[] campi = query.split(" ");
				String cf = campi[10].substring(1, campi[10].length()-2);
				rset = stmt.executeQuery("SELECT * FROM user WHERE fiscal_code='"+cf+"'");
				if(rset.first()) {
					System.out.println("Questo codice fiscale esiste già");
					query = null;
				}
				break;
			//MODIFICA RECORD USER
			case "m":
				System.out.println("ID da modificare:");				
				idUtente = scan.nextLine();
				query = TSutils.modificaUtente(idUtente);
				//System.out.println(query);
				if(query.indexOf("fiscal_code=")!=-1) {
					cf = query.substring(29, 45);
					System.out.println(cf);
					rset = stmt.executeQuery("SELECT * FROM user WHERE fiscal_code='"+cf+"'");
					if(rset.first()) {
						System.out.println("Questo codice fiscale esiste già");
						query = null;
					}
				}
				//System.out.println(query.substring(29, 45));
				break;
			//ELIMINA RECORD USER
			case "e":
				System.out.println("ID da eliminare:");
				idUtente = scan.nextLine();
				rset = stmt.executeQuery("SELECT * FROM timetable WHERE id_user="+idUtente);
				if(rset.first()) {
					System.out.println("Questo utente ha delle tabelle orario associate, "
							+ "sicuro di volerle cancellare? YES per confermare");
					String sicurezza = scan.nextLine();
					if(sicurezza.equalsIgnoreCase("yes")){
						stmt.execute("DELETE FROM timetable WHERE id_user="+idUtente);
					}else {
						break;
					}
				}
				query = TSutils.eliminaUtente(idUtente);
				break;
			//IMPORTA CSV NEL DB
			case "i":
				System.out.println("Inserisci path file CSV da importare: ");
				path = scan.nextLine();
				query_array = DBImportExport.importCsv(path);
				for (int i=0; i<query_array.length; i++) {
					campi = query_array[i].split(" ");
					cf = campi[10].substring(1, campi[10].length()-2);				
					rset = stmt.executeQuery("SELECT * FROM user WHERE fiscal_code='"+cf+"'");
					if(rset.first()) {
						System.out.println("Questo codice fiscale esiste già");
						query_array[i] = null;
					}
				}
				break;
			//ESPORTA DB IN CSV
			case "ex1":
				System.out.println("Inserisci path file CSV da esportare: ");
				path = scan.nextLine();
				DBImportExport.exportCsv(path, conn, stmt);
				break;
			//ESPORTA DB IN XML
			case "ex2":
				System.out.println("Inserisci path file CSV da esportare: ");
				path = scan.nextLine();
				DBImportExport.exportXml(path, conn, stmt);
				break;
			//DEFAULT CASE
			default: 
				System.out.println("Scelta sbagliata");
			}
			
			//ESECUZIONE QUERY
			if(query!=null) {
				stmt.execute(query);
			}
			
			//ESECUZIONE QUERIES (import CSV into DB, Export DB into CSV or XML)
			for(String q : query_array) {
				if(q!=null) {
					stmt.execute(q);
				}
			}
			
			scan.close();
			
//			String query2 = "SELECT * FROM user";
//			rset = stmt.executeQuery(query2);
//			
//			List<String> utenti = new ArrayList<>();
//			utenti.add("Cognome, Nome, Numero, Email");
//			
//			while (rset.next()) {
//				
//				String nome = rset.getString("first_name");
//				String cognome= rset.getString("last_name");
//				String mail = rset.getString("personal_email");
//				String workMail= rset.getString("work_email");
//				String phone=rset.getString("phone");
//				String cf=rset.getString("fiscal_code");
//				String ad=rset.getString("admin");
//				String pw=rset.getString("password");
//				utenti.add("" + nome+", " + cognome+", "+mail+", "+workMail+", "+phone+", "+cf+", "+ad+", "+pw);
//			
//			}
//			String[] arrayUtenti;
//			arrayUtenti = utenti.toArray(new String[utenti.size()]);
//			for(String utente:utenti) {
//				System.out.println(utente);
//			}
			//CSVutils.writeRowsInFile("C:\\Users\\Padawan04\\Desktop\\Marco\\nomiCognomi\\rubrica_random.csv", arrayUtenti);
			
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