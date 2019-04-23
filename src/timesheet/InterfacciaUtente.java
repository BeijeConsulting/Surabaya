package timesheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

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
			System.out.println("Cosa vuoi fare? c-Crea, m-Modifica, e-Elimina");
			
			String scelta=scan.nextLine().toLowerCase();
			String idUtente;
			String query = null;
			
			switch (scelta) {
			case "c":
				query = TSutils.creaUtente();
				break;
			case "m":
				System.out.println("ID da modificare:");				
				idUtente = scan.nextLine();
				query = TSutils.modificaUtente(idUtente);
				break;
			case "e":
				System.out.println("ID da eliminare:");				
				idUtente = scan.nextLine();
				query = TSutils.eliminaUtente(idUtente);
				break;
			default: 
				System.out.println("Scelta sbagliata");
			}
			
			if(query!=null) {
				stmt.execute(query);
			}
			
			
			String query2 = "SELECT * FROM user";
			rset = stmt.executeQuery(query2);
			
			List<String> utenti = new ArrayList<>();
			utenti.add("Cognome, Nome, Numero, Email");
			
			while (rset.next()) {
				
				String nome = rset.getString("first_name");
				String cognome= rset.getString("last_name");
				String mail = rset.getString("personal_email");
				String workMail= rset.getString("work_email");
				String phone=rset.getString("phone");
				String cf=rset.getString("fiscal_code");
				String ad=rset.getString("admin");
				String pw=rset.getString("password");
				utenti.add("" + nome+", " + cognome+", "+mail+", "+workMail+", "+phone+", "+cf+", "+ad+", "+pw);
			
			}
			String[] arrayUtenti;
			arrayUtenti = utenti.toArray(new String[utenti.size()]);
			for(String utente:utenti) {
				System.out.println(utente);
			}
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
