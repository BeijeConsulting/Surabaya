package it.beije.surabaya.esempi;

public class StringPool {

	public static void main(String[] args) {
		
		String s1 = "Prova";
		String s2 = new String("Prova");
		String s3 = s1;
		String s4 = "Prova";
		String s5 = "prova";
		
		System.out.println("s1 == s2 ? " + (s1 == s2));
		System.out.println("s1 equals s2 ? " + (s1.equals(s2)));
		System.out.println("s2 == s3 ? " + (s2 == s3));
		System.out.println("s1 == s3 ? " + (s1 == s3));
		System.out.println("s1 == s4 ? " + (s1 == s4));
		System.out.println("s2 == s4 ? " + (s2 == s4));
		System.out.println("s2 equals s4 ? " + (s2.equals(s4)));
		System.out.println("s4 == s5 ? " + (s4 == s5));
		System.out.println("s4 equals s5 ? " + (s4.equals(s5)));
		System.out.println("s4 equals s5 ? " + (s4.equalsIgnoreCase(s5)));

	}

}
