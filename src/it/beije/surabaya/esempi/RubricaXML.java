package it.beije.surabaya.esempi;

import java.util.Scanner;

public class RubricaXML {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("Agenda recupero crediti, procediamo? (STOP PER FERMARE)");
		String st = s.nextLine();
		CSVutils.appendRowsInFile("C:\\Users\\Padawan01\\Desktop\\RecuperoCreditoXML.txt", "<? xml version=\"1.0\" ?>");
		CSVutils.appendRowsInFile("C:\\Users\\Padawan01\\Desktop\\RecuperoCreditoXML.txt", "<RUBRICA>");
		while (!st.equalsIgnoreCase("STOP")) {
		int j=0;
		int n=0;
		int c=0;
		int d=0;
		String name=null;
		String surn=null;
		String cash=null;
LOOP:	while (j==0) {
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
				System.out.println("Vuoi cambiare qualcosa (si per confermare)?");
				String change=s.nextLine();	
				if (!change.equalsIgnoreCase("si")) {
				String namexml="<name> "+name+"</name>";
				String surnxml="<surname> "+surn+"</surname>";
				String cashxml="<denaro> "+cash+"<denaro>";
				CSVutils.appendRowsInFile("C:\\Users\\Padawan01\\Desktop\\RecuperoCreditoXML.txt", "<CONTATTO>");
				CSVutils.appendRowsInFile("C:\\Users\\Padawan01\\Desktop\\RecuperoCreditoXML.txt", namexml, surnxml, cashxml);
				CSVutils.appendRowsInFile("C:\\Users\\Padawan01\\Desktop\\RecuperoCreditoXML.txt", "</CONTATTO>");
				j++;
										
				}
				else {
				System.out.println("Cosa vuoi cambiare (nome, cogn, den)?");
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
			System.out.println("Agenda recupero crediti, procediamo con un nuovo contatto? (STOP PER FERMARE)");
			st = s.nextLine();
			}
		}
		CSVutils.appendRowsInFile("C:\\Users\\Padawan01\\Desktop\\RecuperoCreditoXML.txt", "</RUBRICA>");
		s.close();
		}
}
