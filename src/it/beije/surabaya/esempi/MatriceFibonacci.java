package it.beije.surabaya.esempi;

import java.util.ArrayList;
import java.util.List;

public class MatriceFibonacci {

	public static void main(String[] args) {
		
		List<Integer> fibonacci = new ArrayList<Integer>(10);
		fibonacci.add(1);
		fibonacci.add(1);
		
		for (int i = 2; i <= 5; i++) {
			int n = fibonacci.get(i - 2) + fibonacci.get(i - 1);
			fibonacci.add(n);
		}
		
		System.out.println(fibonacci);
		
		StringBuilder matrice = new StringBuilder();
		StringBuilder riga1 = new StringBuilder();
		for (int i = 0; i < fibonacci.size(); i++) {
			riga1.append(fibonacci.get(i)).append(' ');
			
			StringBuilder riga2 = new StringBuilder();
			for (int j = 0; j < fibonacci.size()-i;  j++) {
				riga2.insert(0, ' ').insert(0, fibonacci.get(j));
			}
			
			matrice.append(riga1.toString().trim()).append("   ")
			.append(riga2.toString().trim()).append('\n');
		}
		
		System.out.println(matrice);
	}

}
