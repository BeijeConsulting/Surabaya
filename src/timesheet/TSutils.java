package timesheet;

import java.util.Scanner;

public class TSutils {

	static Scanner scan = new Scanner(System.in);
	
	public static String creaUtente() {
		
		String nome = null;
		System.out.println("Nome utente");
		nome = "'"+scan.nextLine().trim()+"'";
		while(nome.length()==2) {
			System.out.println("Nome utente (CAMPO OBBLIGATORIO)");
			nome = "'"+scan.nextLine().trim()+"'";
		}
		
		String cognome = null;
		System.out.println("Cognome utente");
		cognome = "'"+scan.nextLine().trim()+"'";
		while(cognome.length()==2) {
			System.out.println("Cognome utente (CAMPO OBBLIGATORIO)");
			cognome = "'"+scan.nextLine().trim()+"'";
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

	public static String  modificaUtente(String idUtente) {
		String campo, nome, cognome, p_email, w_email, cell, cf, pass;
		
		StringBuilder creaQuery = new StringBuilder("UPDATE user set ");
		
		System.out.println("Cosa vuoi modificare? first_name");
		System.out.println("first_name, last_name, personal_email, work_email, phone, fiscal_code, password");
		campo = scan.nextLine().toLowerCase();
		
		switch(campo) {
		case "first_name":
			nome = prendiCampo(campo);
			creaQuery.append(campo +"="+ "'"+ nome +"'" +",");
			break;
		case "last_name":
			cognome = prendiCampo(campo);
			creaQuery.append(campo +"="+ "'"+cognome+"'"  +",");
			break;
		case "personal_email":
			p_email = prendiCampo(campo);
			creaQuery.append(campo +"="+ "'"+p_email +"'" +",");
			break;
		case "work_email":
			w_email = prendiCampo(campo);
			creaQuery.append(campo +"="+ "'"+w_email+"'"  +",");
			break;
		case "phone":
			cell = prendiCampo(campo);
			creaQuery.append(campo +"="+ "'"+cell +"'" +",");
			break;
		case "fiscal_code":
			cf = prendiCampo(campo);
			creaQuery.append(campo +"="+ "'"+cf +"'" +",");
			break;
		case "password":
			pass = prendiCampo(campo);
			creaQuery.append(campo +"="+ "'"+pass +"'" +",");
			break;
		default:
			System.out.println("Input non valido");		
			return null;
		}
		
		creaQuery.deleteCharAt(creaQuery.length()-1);
		creaQuery.append(" where id = "+ idUtente);
		
		scan.close();
		
		return creaQuery.toString();

	}
	
	public static String prendiCampo(String c) {
		String nuovoValore;
		
		System.out.println("Inserisci il nuovo " + c);
		nuovoValore = scan.nextLine();
		
		return nuovoValore;
	}

	public static String eliminaUtente(String idUtente) {
		String query=null;
		query="DELETE FROM user WHERE id = " + idUtente;
		return query;
	}

}
