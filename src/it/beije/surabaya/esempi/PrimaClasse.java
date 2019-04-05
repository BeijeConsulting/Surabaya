package it.beije.surabaya.esempi;

public class PrimaClasse {
	
	public static void main(String[] args) {
		
		String[] appoggio = new String[args.length];
		int posLib = 0;
		for (String arg : args) {
			if (arg.length() == 1) {
				appoggio[posLib] = arg;//estrapolo elemento
				posLib++;
				//System.out.println(arg);
			}
		}
		
		System.out.println("ne ho trovati " + posLib);
		for (String a : appoggio) {
			if (a != null) System.out.println(a);
		}
	}

}
