package timesheet;

import java.util.Scanner;

public class TSutils {

	public static String creaUtente() {
		
		Scanner scan = new Scanner(System.in);
		
		String nome = null;
		System.out.println("Nome utente");
		nome = "'"+scan.nextLine()+"'";
		while(nome.length()==2) {
			System.out.println("Nome utente (CAMPO OBBLIGATORIO)");
			nome = "'"+scan.nextLine()+"'";
		}
		
		
		String cognome = null;
		System.out.println("Cogome utente");
		cognome = "'"+scan.nextLine()+"'";
		while(cognome.length()==2) {
			System.out.println("Cogome utente (CAMPO OBBLIGATORIO)");
			cognome = "'"+scan.nextLine()+"'";
		}
		
		System.out.println("Email utente (INVIO per saltare CAMPO)");
		String a = scan.nextLine();
		String email = a.length()!=0? "'"+a+"'" : null;
		
		System.out.println("Work Email utente (INVIO per saltare CAMPO)");
		a = scan.nextLine();
		String workEmail = a.length()!=0? "'"+a+"'" : null;
		
		System.out.println("Telefono utente (INVIO per saltare CAMPO)");
		a = scan.nextLine();
		String phone = a.length()!=0? "'"+a+"'" : null;
		
		String cf;
		do{
			System.out.println("CF utente (CAMPO OBBLIGATORIO)(16 cifre!)");
			cf = "'"+scan.nextLine()+"'";
		}while(cf.length()!=18);
		
		System.out.println("Admin? Yes/No (CAMPO OBBLIGATORIO)");
		int admin = scan.nextLine().equalsIgnoreCase("yes")?1:0;
		
		System.out.println("Inserisci una password (INVIO per saltare CAMPO)");
		a = scan.nextLine();
		String pw = a.length()!=0? "'"+a+"'" : null;
		
		String query = "INSERT INTO user "
				+ "VALUES (null, "+nome+", "+cognome+", "+email+", "+workEmail+", "+phone+", "+cf+", "+admin+", "+pw+");";
		
		
		
		return query;
	}

	public static String modificaUtente(String idUtente) {
		String query = null;
		
		return query;
	}

	public static String eliminaUtente(String idUtente) {
		String query = null;
		
		return query;
		
	}

}
