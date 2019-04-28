package timesheet;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import static java.time.temporal.ChronoUnit.HOURS;


import javax.naming.TimeLimitExceededException;

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

	public static String inserisciRigaLavorativa(String idUtente) {

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
				//inizializzazione orari
				LocalTime t1 = LocalTime.of(9, 0), t2 = LocalTime.of(13, 0), t3 = LocalTime.of(14, 0), t4 = LocalTime.of(18, 0);

				//modifica entrata
				System.out.println("Orario entrata 09:00\nDigita + o - per aggingere o togliere 15 minti\nC per Confermare");
				String op = null;
				do {
					op = scan.nextLine();
					while(!(op.equals("+")||op.equals("-")||op.equalsIgnoreCase("c"))) {
						System.out.println("Scelta sbagliata\nDigita + o - per aggingere o togliere 15 minti\\nC per Confermare");
						op = scan.nextLine();
					}
					if(op.equals("+")) {
						t1 = t1.plusMinutes(15);
						System.out.println("Orario entrata: "+t1);
					}else if(op.equals("-")) {
						t1 = t1.minusMinutes(15);
						System.out.println("Orario entrata: "+t1);
					}
				}while(!op.equalsIgnoreCase("c"));

				//modifica pausa
				System.out.println("Orario inizio pausa 13:00\nDigita + o - per aggingere o togliere 15 minti\nC per Confermare");
				op = null;
				do {
					op = scan.nextLine();
					while(!(op.equals("+")||op.equals("-")||op.equalsIgnoreCase("c"))) {
						System.out.println("Scelta sbagliata\nDigita + o - per aggingere o togliere 15 minti\\nC per Confermare");
						op = scan.nextLine();
					}
					if(op.equals("+")) {
						t2 = t2.plusMinutes(15);
						System.out.println("Orario inizio pausa: "+t2);
					}else if(op.equals("-")) {
						t2 = t2.minusMinutes(15);
						System.out.println("Orario inizio pausa: "+t2);
					}
				}while(!op.equalsIgnoreCase("c"));

				//modifica fine pausa
				System.out.println("Orario fine pausa 14:00\nDigita + o - per aggingere o togliere 15 minti\nC per Confermare");
				op = null;
				do {
					op = scan.nextLine();
					while(!(op.equals("+")||op.equals("-")||op.equalsIgnoreCase("c"))) {
						System.out.println("Scelta sbagliata\nDigita + o - per aggingere o togliere 15 minti\\nC per Confermare");
						op = scan.nextLine();
					}
					if(op.equals("+")) {
						t3 = t3.plusMinutes(15);
						System.out.println("Orario fine pausa: "+t3);
					}else if(op.equals("-")) {
						t3 = t3.minusMinutes(15);
						System.out.println("Orario fine pausa: "+t3);
					}
				}while(!op.equalsIgnoreCase("c"));

				//modifica uscita
				System.out.println("Orario uscita 18:00\nDigita + o - per aggingere o togliere 15 minti\nC per Confermare");
				op = null;
				do {
					op = scan.nextLine();
					while(!(op.equals("+")||op.equals("-")||op.equalsIgnoreCase("c"))) {
						System.out.println("Scelta sbagliata\nDigita + o - per aggingere o togliere 15 minti\\nC per Confermare");
						op = scan.nextLine();
					}
					if(op.equals("+")) {
						t4 = t4.plusMinutes(15);
						System.out.println("Orario entrata: "+t4);
					}else if(op.equals("-")) {
						t4 = t4.minusMinutes(15);
						System.out.println("Orario entrata: "+t4);
					}
				}while(!op.equalsIgnoreCase("c"));

				double tot = 8.0;
				if(scelta.equalsIgnoreCase("m")) {
					tot = calcolaTotale(t1, t2, t3, t4);
				}
				query = "INSERT INTO timetable VALUES (null, "+idUtente+", '"+data+"', 'w', '"+t1+"', '"+t2+"', '"+t3+"', '"+t4+"', '"+tot+"')";
			}
		}catch(DateTimeParseException e) {
			System.out.println("Formato data errato");
		}

		System.out.println("query: "+query);
		return query;
	}

	private static double calcolaTotale(LocalTime t1, LocalTime t2, LocalTime t3, LocalTime t4) {
		double tempo = MINUTES.between(t1, t2)+MINUTES.between(t3,t4);
		return tempo/60;
	}

	public static String inserisciRigaPermesso(String idUtente) {
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
			while (orario.charAt(2)!=':' || orario.length()!=5)  {
				System.out.println("Inserire orario inizio permesso: (hh:mm)");
				orario=scan.nextLine();
			}
			inizioPermesso=approssimaOrario(orario);
//			System.out.println(inizioPermesso);
			System.out.println("Inserire orario fine permesso: (hh:mm)");
			orario=scan.nextLine();
			while (orario.charAt(2)!=':' || orario.length()!=5)  {
				System.out.println("Inserire orario fine permesso: (hh:mm)");
				orario=scan.nextLine();
			}

			finePermesso=approssimaOrario(orario);  //passo orario inserito dall'utente a metodo per l'arrotondamento
//			System.out.println(finePermesso);	
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

	public static String inserisciRigaFerie(String idUtente) {
		String query=null;

		System.out.println("Inserisci la data in cui si è usufruito delle ferie:  yyyy-MM-dd");
		String dataFerie= scan.nextLine();		
		try {
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate data = LocalDate.parse(dataFerie, f);
			query = "INSERT INTO timetable VALUES (null, "+idUtente+", '"+data+"', 'w', null, null, null, null, '8.0')";

		}catch(DateTimeParseException e) {
			System.out.println("Formato data errato");
		}
		
		return query;

		
	}

	public static String inserisciRigaMalattia(String idUtente) {
		String query=null;

		System.out.println("Inserisci la data della malattia:  yyyy-MM-dd");
		String dataMalattia= scan.nextLine();		
		try {
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate data = LocalDate.parse(dataMalattia, f);
			query = "INSERT INTO timetable VALUES (null, "+idUtente+", '"+data+"', 'w', null, null, null, null, '8.0')";

		}catch(DateTimeParseException e) {
			System.out.println("Formato data errato");
		}
		
		return query;
		
	}

	public static String modificaRigaLavorativa(String idUtente, LocalDate dataParsato) {
		String campo, date, start1, start2, end1, end2;  
		StringBuilder creaQuery = new StringBuilder("UPDATE timetable set ");
//		LocalTime[] time = new LocalTime[4];

		System.out.println("Cosa vuoi modificare?\ndate, start1, end1, start2, end2");
		campo = scan.nextLine().toLowerCase();
		//modifica il campo scelto dall'utente
		switch(campo) {
		case "date":
			date = prendiCampo(campo + " yyyy-MM-dd");
			try {
				DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				dataParsato = LocalDate.parse(date, f);
			}	catch(DateTimeParseException e) {
				System.out.println("Formato data errato");
				return null;
			}

			creaQuery.append(campo +"="+ "'"+ dataParsato +"'" +",");		//sintassi SQL, come la creazione

			break;
		case "start1":
			start1 = prendiCampo(campo + " ore:minuto");
		//	time[0] = LocalTime.parse(start1);
			start1 = approssimaOrario(start1);
			creaQuery.append(campo +"="+ "'"+start1+":00'"  +",");
			break;
		case "end1":
			end1 = prendiCampo(campo + " ore:minuto");
	//		time[1] = LocalTime.parse(end1);
			end1 = approssimaOrario(end1);
			creaQuery.append(campo +"="+ "'"+end1+":00'"  +",");
			break;
		case "start2":
			start2 = prendiCampo(campo + " ore:minuto");
	//		time[2] = LocalTime.parse(start2);
			start2 = approssimaOrario(start2);
			creaQuery.append(campo +"="+ "'"+start2+":00'"  +",");
			break;
		case "end2":
			end2 = prendiCampo(campo + " ore:minuto");
	//		time[3] = LocalTime.parse(end2);
			end2 = approssimaOrario(end2);
			creaQuery.append(campo +"="+ "'"+end2+":00'"  +",");
			break;
		default:
			System.out.println("Input non valido");
			return null;
		}

	//	double tot = (calcolaTotale(time[0],time[1],time[2],time[3]));

	//	creaQuery.append(" tot= " + tot);
		creaQuery.deleteCharAt(creaQuery.length()-1);    	//in questo modo toglie l'ultimo carattere che è la virgola



		creaQuery.append(" where id = "+ idUtente + " AND date='" + dataParsato +"'");			// finisce di creare la query specificando l'id

		scan.close();

//		System.out.println(creaQuery.toString());
		return creaQuery.toString();

	}

	public static String modificaRigaPermesso(String idUtente, LocalDate dataParsato) {
		String query=null;
		String inizioPermesso=null;
		String finePermesso=null;
		StringBuilder creaQuery = new StringBuilder("UPDATE timetable set ");
		
		System.out.println("Cosa devi modificare: D-data, O-orario");
		String campo=scan.nextLine();
		if (campo .equalsIgnoreCase("D")){
			System.out.println("In che data hai usufruito del permesso?:  yyyy-MM-dd?");
			String date=scan.nextLine();
			LocalDate newDate=null;
			try {
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			newDate = LocalDate.parse(date, f);
			}	catch(DateTimeParseException e) {
			System.out.println("Formato data errato");
			}
			creaQuery.append("date ="+ "'"+ newDate +"'" +",");
			creaQuery.deleteCharAt(creaQuery.length()-1);
		}
		else if (campo .equalsIgnoreCase("O")) {
//			try {
				
				System.out.println("Inserire orario inizio permesso: (hh:mm)");
				String orario=scan.nextLine();
				while (orario.charAt(2)!=':' || orario.length()!=5)  {
					System.out.println("Inserire orario inizio permesso: (hh:mm)");
					orario=scan.nextLine();
				}
				inizioPermesso=approssimaOrario(orario);
//				System.out.println(inizioPermesso);
				System.out.println("Inserire orario fine permesso: (hh:mm)");
				orario=scan.nextLine();
				while (orario.charAt(2)!=':' || orario.length()!=5)  {
					System.out.println("Inserire orario fine permesso: (hh:mm)");
					orario=scan.nextLine();
				}

				finePermesso=approssimaOrario(orario);  //passo orario inserito dall'utente a metodo per l'arrotondamento
//				System.out.println(finePermesso);	
				String p1 []=inizioPermesso.split(":");
				String p2 []=finePermesso.split(":");
				LocalTime t1 = LocalTime.of(Integer.parseInt(p1[0]), Integer.parseInt(p1[1]));
				LocalTime t2 = LocalTime.of(Integer.parseInt(p2[0]), Integer.parseInt(p2[1]));
				int oreTrascorse=(int) HOURS.between(t1, t2);
				int oreLavorate= 8 - oreTrascorse;
				creaQuery.append("start1 = '"+ inizioPermesso+"', "+"end1 ='"+finePermesso+"', tot = '"+oreLavorate+"'");
				System.out.println(creaQuery);
//				creaQuery.deleteCharAt(creaQuery.length()-1);
//			}catch(DateTimeParseException e) {
//				System.out.println("Formato data errato");
//			}
		}
		
		creaQuery.append(" where id_user = "+ idUtente + " AND date='" + dataParsato +"'");
		
		return creaQuery.toString();
		
	}

	public static String modificaRigaFerie(String idUtente, LocalDate dataParsato) {
		StringBuilder creaQuery = new StringBuilder("UPDATE timetable set ");
		
		System.out.println("In che data hai usufruito delle ferie:  yyyy-MM-dd?");
		String date=scan.nextLine();
		LocalDate newDate=null;
		try {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		newDate = LocalDate.parse(date, f);
		}	catch(DateTimeParseException e) {
		System.out.println("Formato data errato");
		}
		creaQuery.append("date ="+ "'"+ newDate +"'" +",");
		creaQuery.deleteCharAt(creaQuery.length()-1);    	//in questo modo toglie l'ultimo carattere che è la virgola



		creaQuery.append(" where id = "+ idUtente + " AND date='" + dataParsato +"'");			// finisce di creare la query specificando l'id
//		System.out.println(creaQuery.toString());
		return creaQuery.toString();
		
		
	}

	public static String modificaRigaMalattia(String idUtente, LocalDate dataParsato) {
StringBuilder creaQuery = new StringBuilder("UPDATE timetable set ");
		
		System.out.println("In che data hai usufruito del permesso di malattia:  yyyy-MM-dd?");
		String date=scan.nextLine();
		LocalDate newDate=null;
		try {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		newDate = LocalDate.parse(date, f);
		}	catch(DateTimeParseException e) {
		System.out.println("Formato data errato");
		}
		creaQuery.append("date ="+ "'"+ newDate +"'" +",");
		creaQuery.deleteCharAt(creaQuery.length()-1);    	//in questo modo toglie l'ultimo carattere che è la virgola



		creaQuery.append(" where id = "+ idUtente + " AND date='" + dataParsato +"'");			// finisce di creare la query specificando l'id
//		System.out.println(creaQuery.toString());
		return creaQuery.toString();
		
	}
	public static String approssimaOrario(String orario)  {
		String nuovoOrario=null;
		orario=orario.substring(0, orario.length());
		orario=orario.trim();
		int ora=Integer.parseInt(orario.substring(0,2));			//prendo ora in un int
		int minuti=Integer.parseInt(orario.substring(3));  			//prendo minuti in un int
//		System.out.println(minuti);
		if (minuti<8)  {
			nuovoOrario=""+ora+":"+"00";
		 } else if (minuti >8 && minuti <=15)  {
			 nuovoOrario=""+ora+":"+"15";
		 } else if (minuti>15 && minuti <=24)  {
			 nuovoOrario=""+ora+":"+"15";
		 } else if (minuti>24 && minuti <=30)  {
			 nuovoOrario=""+ora+":"+"30";                      //approssimo al quarto d'ora
		 } else if (minuti>30 && minuti <=38)  {
			 nuovoOrario=""+ora+":"+"30";
		 } else if (minuti>38 && minuti <=45)  {
			 nuovoOrario=""+ora+":"+"45";
		 } else if (minuti>45 && minuti <=54)  {
			 nuovoOrario=""+ora+":"+"45";
		 } else {
			 if (ora == 23)
				 nuovoOrario="00:00";
			 ora=ora+1;
			 nuovoOrario=""+ora+":"+"00";
		 }

		return nuovoOrario;
	}


}
