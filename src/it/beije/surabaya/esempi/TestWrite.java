package it.beije.surabaya.esempi;
import java.io.*;
import java.util.*;

public class TestWrite {
	public static void main(String[] args) throws Exception{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Salvare contatto?");
		
		String st = s.nextLine();
	LOOP:	while (st!="Q") {
			int z=0;
			
			ArrayList<String> list= new ArrayList<>();
			System.out.println("NOME COGNOME NUMERO");
			
			while (z<3) {
				st = s.nextLine();
				list.add(st);
				z++;
				System.out.println("lista"+list);
				
			}
			System.out.println("CONFERMI?");
			String co = s.nextLine();

			if (co == "no") {
				continue LOOP;
				}
			else {
				CSVutils.appendRowsInFile("C:\\Users\\Padawan01\\Desktop\\Rub.txt", "\n", "\n", "NOME, COGNOME, NUMERO", "\n", "\n");
				StringBuilder sbC= new StringBuilder();
				for (String j:list) {
					sbC.append(j);
					sbC.append(";");
					sbC.append("\t");
				}
				String stringa=sbC.toString();
				CSVutils.appendRowsInFile("C:\\Users\\Padawan01\\Desktop\\Rub.txt", stringa );
				}
//			co = s.nextLine();
//			if (co == "si") {
//				StringBuilder sbC= new StringBuilder();
//				for (String j:list) {
//					sbC.append(j);
//					sbC.append(";");
//					sbC.append("\t");
//				}
//				String stringa=sbC.toString();
//				CSVutils.appendRowsInFile("C:\\Users\\Padawan01\\Desktop\\Rub.txt", stringa );
//				}
//				else {
//					continue LOOP;
//				}
			}
		s.close();
	}
}
