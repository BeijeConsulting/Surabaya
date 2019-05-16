package personale;

import java.util.Scanner;
public class Autonoleggio {
	public static void main(String[] args) {
		String[] auto = new String [args.length];
		Boolean[] status = new Boolean [args.length];
		int [] days = new int [args.length];
		int i=0;
			while ( i<args.length) {
				auto[i]=args[i];
				status[i]=true;
				days[i]=-1;
				i++;
			}
		
		int d=0;
		while (d<3) {
			String check="no";
		Scanner s = new Scanner(System.in);
		
		while (!check.equalsIgnoreCase("SI")) {
//				Scanner s = new Scanner(System.in);
		String rs = null;
		String st = null;	
		String tt = null;
	
		System.out.println("Noleggiare, restituire o nulla da fare? N/R");
		rs = s.nextLine();
		if (rs .equalsIgnoreCase("N")){
		System.out.println("Che auto vuoi noleggiare? A, B o C");
		st = s.nextLine();
		
		int k=0;
			while (k<auto.length) {
				if (st .equalsIgnoreCase(auto[k])) {
					if (status[k]==true) {
						status[k]=false;
						days[k]=0;
						System.out.println("auto "+st+" noleggiata");
						System.out.println(days[k]);
					}
					else {System.out.println("auto non disponibile");}
				}
				k++;
			}
		}
		else if (rs .equalsIgnoreCase("R")){
			System.out.println("Che auto vuoi restituire? A, B o C");
			tt = s.nextLine();
			
			int t=0;
			while (t<auto.length) {
				if (tt .equalsIgnoreCase(auto[t])) {
					if (status[t]==false) {
						status[t]=true;
						days[t]=-1;
						System.out.println("auto "+tt+" noleggiata");
					}
					else {System.out.println("auto già restituita");}
				}
				t++;
			}
			
		}
		else {
		System.out.println("Opzione Sbagliata");
		}
		System.out.println("Giornata finita? si/no");
		check=s.nextLine();
		}
		int y=0;
		
		while (y<auto.length) {
			if (days[y] != -1) {
					days[y]+=1;	
				}
			y++;
			}
		int h=0;
		while ( h<args.length) {
			System.out.println("auto: " +auto[h]);
			System.out.println("disponibile: "+status[h]);
			System.out.println("giorni fuori: "+days[h]);
			h++;
		}
		
		
		d++;
		}
		
	}
}
