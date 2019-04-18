package it.beije.surabaya.esempi;

import java.io.*;
import java.util.*;
public class RubricaWrite {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("Agenda recupero crediti, procediamo? (STOP PER FERMARE)");
		String st = s.nextLine();
		
		while (!st.equalsIgnoreCase("STOP")) {
		int j=0;
		int n=0;
		int c=0;
		int d=0;
		String name=null;
		String surn=null;
		String cash=null;
LOOP:	while (j==0) {
		//		ArrayList<String> list= new ArrayList<>();
				
				while (n==0){
				System.out.println("NOME");
				String nome = s.nextLine();
				name=nome;
				n++;
				}	
				
				while (c==0) {
				System.out.println("COGNOME");
				String cogn = s.nextLine();
				surn=cogn;
				c++;
				}
				
				while (d==0) {
				System.out.println("DENARO");
				String denaro=s.nextLine();
				cash=denaro;
				d++;
				}
				System.out.println("Vuoi cambiare (nome, cogn, den)?");
				String change=s.nextLine();	
				if (!change.equalsIgnoreCase("si")) {
				String debitore=name+"; "+ surn+"; "+cash;
				CSVutils.appendRowsInFile("C:\\Users\\Padawan01\\Desktop\\RecuperoCredito.txt", "NOME COGNOME DEBITO");
				CSVutils.appendRowsInFile("C:\\Users\\Padawan01\\Desktop\\RecuperoCredito.txt", debitore);
				j++;
										
				}
				else {
				System.out.println("Cosa vuoi cambiare?");
					String cambio=s.nextLine();
					if (cambio.equalsIgnoreCase("nome")) {
						n=0;	
					}
					else if (cambio.equalsIgnoreCase("cogn")) {
						c=0;
					}
					else if (cambio.equalsIgnoreCase("den")) {
						d=0;
					}
					continue LOOP;

				}
			System.out.println("Agenda recupero crediti, procediamo? (STOP PER FERMARE)");
			st = s.nextLine();
			}
		
		}
		s.close();
	}
}
