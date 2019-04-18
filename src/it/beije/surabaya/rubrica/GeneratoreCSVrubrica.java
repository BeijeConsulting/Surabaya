package it.beije.surabaya.rubrica;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import it.beije.surabaya.esempi.CSVutils;

public class GeneratoreCSVrubrica  {
	
	private static List<String> nomi;
	private static List<String> cognomi;
	private static String[] prefissi = {"333", "335", "336", "339", "340", "347", "329", "327", "380", "367" };
	
	static {
		try {
			nomi = CSVutils.getFileAsStrings("C:\\Users\\Padawan01\\Desktop\\nomi.txt");
			cognomi = CSVutils.getFileAsStrings("C:\\Users\\Padawan01\\Desktop\\cognomi.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static String getCSVrandomCognomeNome(char sep)  throws Exception {
		Random random = new Random();
		
		int entropiaCognome = (int) (cognomi.size() * 1.3);
		int rC = random.nextInt(entropiaCognome);
		String cognome = rC < cognomi.size() ? cognomi.get(rC).trim() : "";
		
		int rN;
		if (cognome.length() > 0) {
			int entropiaNome = (int) (nomi.size() * 1.1);
			rN = random.nextInt(entropiaNome);
		} else {
			rN = random.nextInt(nomi.size());
		}
		
		String nome = rN < nomi.size() ? nomi.get(rN).trim() : "";
		
		StringBuilder builder = new StringBuilder(cognome);
		builder.append(sep).append(nome);
		
		return builder.toString();
	}

	private static String getRandomPhone() {
		Random random = new Random();
		int r = random.nextInt(prefissi.length);
		
		StringBuilder builder = new StringBuilder(prefissi[r]);

		for (int i = 1; i <= 7; i++) {
			r = random.nextInt(10);
			builder.append(r);
		}		
		
		return builder.toString();
	}
	
	private static String getCSVrecord(char sep) throws Exception {
		
		String cognomeNome = getCSVrandomCognomeNome(sep);
//		System.out.println("nomeCognome : " + cognomeNome);
		
		String email = cognomeNome.replace(sep, '.')
				.replace(" ", "_")
				.replace('\'', '_')
				.toLowerCase();
		if (email.startsWith(".")) {
			email = email.substring(1);
		} else if (email.endsWith(".")) {
			email = email.substring(0, email.length()-1);
		}
		
		email += "@fakemail.com";
//		System.out.println("email : " + email);

		String telefono = getRandomPhone();
//		System.out.println("telefono : " + telefono);
		
		StringBuilder nominativo = new StringBuilder(cognomeNome);
		nominativo.append(sep).append(telefono)
		.append(sep).append(email).append(sep);
//		System.out.println("nominativo : " + nominativo);
		
		return nominativo.toString();
	}
	
	public static void main(String[] args) throws Exception {
		//cognome, nome, telefono, email
//		System.out.println("nomi : " + nomi.size());
//		System.out.println("cognomi : " + cognomi.size());

		char separatore = ';';
		int numRighe = 100;
		
		String[] records = new String[numRighe + 1];
		records[0] = "cognome;nome;telefono;email;";
		for (int i = 1; i <= numRighe; i++) {
			records[i] = getCSVrecord(separatore);
		}
		
		CSVutils.writeRowsInFile("C:\\Users\\Padawan01\\Desktop\\rubrica_random.txt", records);
		
		System.out.println("FATTO");
	}

}
