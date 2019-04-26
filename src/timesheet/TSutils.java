package timesheet;
import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import static java.time.temporal.ChronoUnit.HOURS;
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
			while (cf.trim().length()!= 16);
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

	public static String InserisciRigaLavorativa(String idUtente) {
		
		String query = null;
		
		System.out.println("Inserisci la data: yyyy-MM-dd");
		String dataInput = scan.nextLine();
		try {
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate data = LocalDate.parse(dataInput, f);
			//System.out.println(data);
			query = "INSERT INTO timetable VALUES (null, "+idUtente+", '"+data+"', 'w', '09:00:00', '13:00:00', '14:00:00', '18:00:00', '8.0')";
			
			System.out.println("Vuoi modificare gli orari di entrata/uscita?\nM per Modificarli\nQualsiasi tasto per 9:00:00-13:00:00 14:00:00-18:00:00");
			String scelta = scan.nextLine();
			if(scelta.equalsIgnoreCase("m")) {
				System.out.println("Orario entrata: (hh:mm:ss)");
				String e1 = scan.nextLine();
//				String[] e1 = scan.nextLine().split(":");
//				int ora = Integer.parseInt(e1[0]);
//				int minuto = Integer.parseInt(e1[1]);
//				LocalTime te1 = LocalTime.of(ora, minuto, 00);
				System.out.println("Orario inizio pausa pranzo: (hh:mm:ss)");
				String u1 = scan.nextLine();
				System.out.println("Orario fine pausa pranzo: (hh:mm:ss)");
				String e2 = scan.nextLine();
				System.out.println("Orario uscita: (hh:mm:ss)");
				String u2 = scan.nextLine();
				query = "INSERT INTO timetable VALUES (null, "+idUtente+", '"+data+"', 'w', '"+e1+"', '"+u1+"', '"+e2+"', '"+u2+"', '8.0')";
				
				System.out.println("Input ore da controllare, totale da calcolare!");
			}
		}catch(DateTimeParseException e) {
			System.out.println("Formato data errato");
		}
		
		System.out.println(query);
		return query;
	}

	public static String InserisciRigaPermesso(String idUtente) {
		String query=null;
		String inizioPermesso=null;
		String finePermesso=null;
		System.out.println("Inserisci la data in cui si è usufruito del permesso:  yyyy-MM-dd");
		String dataPermesso= scan.nextLine();		
		try {
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate data = LocalDate.parse(dataPermesso, f);
			System.out.println("Inserire orario inizio permesso: (hh:mm)");
			String orario=scan.nextLine();
			int ora=Integer.parseInt(orario.substring(0,2));			//prendo ora in un int
			int minuti=Integer.parseInt(orario.substring(3));  			//prendo minuti in un int
//			System.out.println(minuti);
			if (minuti<8)  {
				inizioPermesso=""+ora+":"+"00";
			 } else if (minuti >=8 && minuti <=15)  {
				 inizioPermesso=""+ora+":"+"15";
			 } else if (minuti>15 && minuti <=24)  {
				 inizioPermesso=""+ora+":"+"15";
			 } else if (minuti>24 && minuti <=30)  {
				 inizioPermesso=""+ora+":"+"30";                      //approssimo al quarto d'ora
			 } else if (minuti>30 && minuti <=38)  {
				 inizioPermesso=""+ora+":"+"30";
			 } else if (minuti>38 && minuti <=45)  {
				 inizioPermesso=""+ora+":"+"45";
			 } else if (minuti>45 && minuti <=54)  {
				 inizioPermesso=""+ora+":"+"45";
			 } else {
				 if (ora == 23)
					 inizioPermesso="00:00";
				 ora=ora+1;
				 inizioPermesso=""+ora+":"+"00";
			 }
		
			System.out.println(inizioPermesso);
			System.out.println("Inserire orario fine permesso: (hh:mm)");
			orario=scan.nextLine();
			ora=Integer.parseInt(orario.substring(0,2));			//prendo ora in un int
			minuti=Integer.parseInt(orario.substring(3)); 
			
			if (minuti<8)  {
				finePermesso=""+ora+":"+"00";
			 } else if (minuti >=8 && minuti <=15)  {
				 finePermesso=""+ora+":"+"15";
			 } else if (minuti>15 && minuti <=24)  {
				 finePermesso=""+ora+":"+"15";
			 } else if (minuti>24 && minuti <=30)  {
				 finePermesso=""+ora+":"+"30";                      //approssimo al quarto d'ora
			 } else if (minuti>30 && minuti <=38)  {
				 finePermesso=""+ora+":"+"30";
			 } else if (minuti>38 && minuti <=45)  {
				 finePermesso=""+ora+":"+"45";
			 } else if (minuti>45 && minuti <=54)  {
				 finePermesso=""+ora+":"+"45";
			 } else {
				 if (ora == 23)
					 finePermesso="00:00";
				 ora=ora+1;
				 finePermesso=""+ora+":"+"00";
			 }
			System.out.println(finePermesso);	
		}catch(DateTimeParseException e) {
			System.out.println("Formato data errato");
		}
		//Parte calcolo tempo trascorso
		String p1 []=inizioPermesso.split(":");
		String p2 []=finePermesso.split(":");
		LocalTime t1 = LocalTime.of(Integer.parseInt(p1[0]), Integer.parseInt(p1[1]));
		LocalTime t2 = LocalTime.of(Integer.parseInt(p2[0]), Integer.parseInt(p2[1]));

		int oreTrascorse=(int) HOURS.between(t1, t2);
		query = "INSERT INTO timetable VALUES (null, "+idUtente+", '"+dataPermesso+"', 'p', '"+inizioPermesso+"', '"+finePermesso+"', null, null, '"+oreTrascorse+"')";
		return query;
		
	}

	public static String InserisciRigaFerie(String idUtente) {
		String query=null;
		
		return query;
		
	}

	public static String InserisciRigaMalattia(String idUtente) {
		String query=null;
		
		return query;
		
	}

	public static String ModificaRigaLavorativa(String idUtente) {
		String query=null;
		
		
		return query;
	}

	public static String ModificaRigaPermesso(String idUtente) {
		String query=null;
		
		
		return query;
		
	}

	public static String ModificaRigaFerie(String idUtente) {
		String query=null;
		
		
		return query;
		
	}

	public static String ModificaRigaMalattia(String idUtente) {
		String query=null;
		
		
		return query;
		
	}

	

	
	


}
