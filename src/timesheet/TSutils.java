package timesheet;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class TSutils {
	static Scanner scan = new Scanner(System.in);
	public static String creaUtente() {
		String query=null;
		
		
		
		String nome=null;
		System.out.println("Nome utente ");
		nome ="'"+ scan.nextLine().trim()+"'";			//Formato per query SQL
		
		while (nome.length()==2) {						//Se il nome è null, allora resteranno solo gli apici ('')
			System.out.println("Nome utente (CAMPO OBBLIGATORIO)");
			nome ="'"+ scan.nextLine().trim()+"'";
		}
		
		
		String cognome=null;
		System.out.println("Cognome utente "); 			//come nome
		cognome ="'"+ scan.nextLine().trim()+"'";
		
		while (cognome.length()==2) {
			System.out.println("Cognome utente (CAMPO OBBLIGATORIO)");
			cognome = "'"+scan.nextLine().trim()+"'";
		}
		
		System.out.println("Mail utente (INVIO PER SALTARE)");		
		String a = scan.nextLine();						//indrizzo mail, se vuoto allora 
		String mail = a.length()!=0? "'"+a+"'": null;	//viene inizializzato a null, altrimenti viene messo tra apici
		
		System.out.println("Mail lavoro utente (INVIO PER SALTARE)");
		String b = scan.nextLine();						//come mail
		String workMail = b.length()!=0? "'"+b+"'": null;
		
		System.out.println("Telefono utente (INVIO PER SALTARE)");
		String c = scan.nextLine();						//come mail
		String phone = c.length()!=0? "'"+c+"'": null;
		
		String cf;
		do {							
			System.out.println("Codice Fiscale utente (16 cifre, CAMPO OBBLIGATORIO)");
			cf="'"+ scan.nextLine()+"'";
		}
		while (cf.length() != 18);		//il codice fiscale avrà lunghezza 18 perchè aggiunti gli apici ('')
		
		System.out.println("Status utente (Yes per admin) CAMPO OBBLIGATORIO");
		int ad =scan.nextLine().equalsIgnoreCase("yes")? 1 : 0;		//SQL prende come valore booleano un bit
																	//1 vero, 0 falso
		System.out.println("Password utente (INVIO PER SALTARE)");
		String d = scan.nextLine();				//come mail
		String pw = d.length()!=0? "'"+d+"'": null;


		query="INSERT INTO user VALUES (null, "+ nome +", "+cognome+", " +mail +", " 
				+workMail+", "+phone+", " +cf+", "+ad+", "+pw +")";    //creazione della query
		return query;

	}

	public static String  modificaUtente(String idUtente) {
		String campo, nome, cognome, p_email, w_email, cell, cf, pass;  

		StringBuilder creaQuery = new StringBuilder("UPDATE user set ");

		System.out.println("Cosa vuoi modificare? first_name");
		System.out.println("first_name, last_name, personal_email, work_email, phone, fiscal_code, password");
		campo = scan.nextLine().toLowerCase();
		//modifica il campo scelto dall'utente
		switch(campo) {
		case "first_name":
			nome = prendiCampo(campo);
			creaQuery.append(campo +"="+ "'"+ nome +"'" +",");		//sintassi SQL, come la creazione
			break;
		case "last_name":
			cognome = prendiCampo(campo);
			creaQuery.append(campo +"="+ "'"+cognome+"'"  +",");
			break;
		case "personal_email":
			p_email = prendiCampo(campo);
			creaQuery.append(p_email.length()==0?campo +"="+ null +",":campo +"="+ "'"+p_email +"'" +",");
//			if (p_email.length()==0) {
//				creaQuery.append(campo +"="+ null +",");   //in questo modo, se il valore viene messo a null non avremo
//			}												// una stringa vuota
//			else {
//			creaQuery.append(campo +"="+ "'"+p_email +"'" +",");
//			}
			break;
		case "work_email":
			w_email = prendiCampo(campo);
			if (w_email.length()==0) {						//vedi sopra 
				creaQuery.append(campo +"="+ null +",");
			}
			else {
			creaQuery.append(campo +"="+ "'"+w_email +"'" +",");
			}
			break;
		case "phone":
			cell=prendiCampo(campo);
			if (cell.length()==0) {
				creaQuery.append(campo +"="+ null +",");			//guarda sù
			}
			else {
			creaQuery.append(campo +"="+ "'"+cell +"'" +",");
			}
			break;
		case "fiscal_code":
			do {							
				System.out.println("Codice Fiscale utente (16 cifre, CAMPO OBBLIGATORIO)");
				cf = prendiCampo(campo);
			}
			while (cf.length()!= 16);
			creaQuery.append(campo +"="+ "'"+cf +"'" +",");
			break;
		case "password":
			pass = prendiCampo(campo);
			if (pass.length()==0) {					//come mail
				creaQuery.append(campo +"="+ null +",");
			}
			else {
			creaQuery.append(campo +"="+ "'"+pass +"'" +",");
			}
			break;
		default:
			System.out.println("Input non valido");
			return null;
		}
		
		creaQuery.deleteCharAt(creaQuery.length()-1);    	//in questo modo toglie l'ultimo carattere che è la virgola
		
		creaQuery.append(" where id = "+ idUtente);			// finisce di creare la query specificando l'id

		scan.close();

		return creaQuery.toString();

	}

	public static String prendiCampo(String c) {			//metodo per inserire il valore del campo modificato
		String nuovoValore;

		System.out.println("Inserisci il nuovo " + c);
		nuovoValore = scan.nextLine().trim();

		return nuovoValore;
	}

	public static String eliminaUtente(String idUtente) {  //eliminazione dell'utente
		String query=null;
		query="DELETE FROM user WHERE id = " + idUtente;    //creazione della query per eliminare
		return query;
	}

	public static String inserisciRigaLavorativa(String idUtente) {

		System.out.println("Inserisci la data: yyyy-MM-dd");
		String dataInput = scan.nextLine();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate data = LocalDate.parse(dataInput, f);
		System.out.println(data);
		return null;
	}

	public static String inserisciRigaPermesso(String idUtente) {

		return null;		
	}

	public static String inserisciRigaFerie(String idUtente) {

		return null;
	}

	public static String inserisciRigaMalattia(String idUtente) {
		return null;
		
	}

	public static String modificaRigaLavorativa(String idUtente) {
		return null;
		
	}

	public static String modificaRigaPermesso(String idUtente) {
		return null;
		
	}

	public static String modificaRigaFerie(String idUtente) {
		return null;
		
	}

	public static String modificaRigaMalattia(String idUtente) {
		return null;
		
	}
	
	

}