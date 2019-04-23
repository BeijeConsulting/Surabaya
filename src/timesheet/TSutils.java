package timesheet;
import java.util.Scanner;
public class TSutils {

	public static String creaUtente() {
		String query=null;
		
		Scanner scan = new Scanner(System.in);
		
		String nome=null;
		System.out.println("Nome utente ");
		nome ="'"+ scan.nextLine()+"'";
		
		while (nome.length()==2) {
			System.out.println("Nome utente (CAMPO OBBLIGATORIO)");
			nome ="'"+ scan.nextLine()+"'";
		}
		
		
		String cognome=null;
		System.out.println("Cognome utente ");
		cognome ="'"+ scan.nextLine()+"'";
		
		while (cognome.length()==2) {
			System.out.println("Cognome utente (CAMPO OBBLIGATORIO)");
			cognome = "'"+scan.nextLine()+"'";
		}
		
		System.out.println("Mail utente (INVIO PER SALTARE)");
		String a = scan.nextLine();
		String mail = a.length()!=0? "'"+a+"'": null;
		
		System.out.println("Mail lavoro utente (INVIO PER SALTARE)");
		String b = scan.nextLine();
		String workMail = b.length()!=0? "'"+b+"'": null;
		
		System.out.println("Telefono utente (INVIO PER SALTARE)");
		String c = scan.nextLine();
		String phone = c.length()!=0? "'"+c+"'": null;
		
		String cf;
		do {
			System.out.println("Codice Fiscale utente (16 cifre, CAMPO OBBLIGATORIO)");
			cf="'"+ scan.nextLine()+"'";
		}
		while (cf.length() != 18);
		
		System.out.println("Status utente (Yes per admin) CAMPO OBBLIGATORIO");
		int ad =scan.nextLine().equalsIgnoreCase("yes")? 1 : 0;
		
		System.out.println("Password utente (INVIO PER SALTARE)");
		String d = scan.nextLine();
		String pw = d.length()!=0? "'"+d+"'": null;
		
		
		query="INSERT INTO user VALUES (null, "+ nome +", "+cognome+", " +mail +", " 
				+workMail+", "+phone+", " +cf+", "+ad+", "+pw +")";
		return query;
			
	}

	public static String modificaUtente(String idUtente) {

		String query=null;
		
		
		return query;
		
	}

	public static String eliminaUtente(String idUtente) {

		String query=null;
		
		
		return query;
	}

}
