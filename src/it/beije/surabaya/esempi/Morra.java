package it.beije.surabaya.esempi;

import java.util.Arrays;

public class Morra {

	public static void main(String[] args) {
		String[] array = {"carta", "forbice", "sasso"};
		//String[] array = {"asso", "due", "tre", "quattro", "cinque", "sei", "sette", "fante", "donna", "re"};
		int ULTIMO = array.length - 1; 
		
		if (args.length == 2) {
			if (!args[0].equalsIgnoreCase(args[1])) {
				int p1 = -1;
				int p2 = -1;
				
//				cerco con binarySearch
//				p1 = Arrays.binarySearch(array, args[0].toLowerCase());
//				p2 = Arrays.binarySearch(array, args[1].toLowerCase());

//				cerco con for
//				for (int i = 0; i< array.length; i++) {
//					if (array[i].equalsIgnoreCase(args[0])) p1 = i;
//					if (array[i].equalsIgnoreCase(args[1])) p2 = i;
//				}
				
//				cerco con while
				int i = 0;
				while ((p1 < 0 || p2 < 0) && i < array.length) {
				//while (!(p1 >= 0 && p2 >= 0) && i < array.length) {//equivalente
					if (array[i].equalsIgnoreCase(args[0])) p1 = i;
					if (array[i].equalsIgnoreCase(args[1])) p2 = i;
					i++;
				}
				
				System.out.println("p1 : " + p1);
				System.out.println("p2 : " + p2);
				
				if (p1 == 0 && p2 == ULTIMO) {
					System.out.println(args[0] + " batte " + args[1]);
				} else if (p2 == 0 && p1 == ULTIMO) {
					System.out.println(args[0] + " perde con " + args[1]);
				} else if (p1 > p2 ) {
					System.out.println(args[0] + " batte " + args[1]);
				} else if (p1 < p2) {
					System.out.println(args[0] + " perde con " + args[1]);
				} else {
					System.out.println("qualcosa non torna...");
				}
				
			} else System.out.println("PARI PATTA");
		} else System.out.println("il gioco prevede due parole in ingresso!");

	}
	
}
