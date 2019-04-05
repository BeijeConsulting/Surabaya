package it.beije.surabaya.esempi;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String st = s.nextLine();
		while (!st.equalsIgnoreCase("Q")) {

			System.out.println(st);
			//// CALCOLATRICE

			st = s.nextLine();
		}
		
		System.out.println("BYE!!");
		s.close();

	}

}
