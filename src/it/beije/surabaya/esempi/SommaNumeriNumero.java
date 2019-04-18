package it.beije.surabaya.esempi;

public class SommaNumeriNumero {

	//static String numero = "12345";
	
//	public static void main(String[] args) {
//		//String numero = args[0];
//		
//		int somma = 0;
//		for (int i = 0; i < numero.length(); i++) {
//			String c = "" + numero.charAt(i);
//			int v = Integer.parseInt(c);
//			somma += v;
//			//somma += Integer.parseInt(Character.toString(numero.charAt(i)));
//		}
//		
//		System.out.println("somma : " + somma);
//		
//	}

	public static void main(String[] args) {
		String numero = args[0];
		long n = Long.parseLong(numero);
		long somma = 0;
		
		while (n > 0) {
			long cifra = n % 10;
			somma += cifra;
			
			n = n / 10;
		}
		
		System.out.println("somma : " + somma);
	
	}
}
