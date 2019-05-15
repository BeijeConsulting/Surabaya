package it.beije.surabaya.cap5.motorizzazione;

public class run {

	//Quale macchina ha più posti
	public static void comparaCapienzaAuto(Automobile a1, Automobile a2){
		String[] nome1 = a1.getClass().getName().split("\\.");
		String n1 = nome1[nome1.length-1];
		String[] nome2 = a2.getClass().getName().split("\\.");
		String n2 = nome2[nome2.length-1];
		
		System.out.println(n1+" ha "+a1.getNumPosti()+" posti");
		System.out.println(n2+" ha "+a2.getNumPosti()+" posti");
		
		if(a1.getNumPosti()>a2.getNumPosti()) {
			System.out.println(n1+" ha maggiore capienza di "+n2);
		}else if(a1.getNumPosti()<a2.getNumPosti()) {
			System.out.println(n2+" ha maggiore capienza di "+n1);
		}else {
			System.out.println(n1+" ha la stessa capienza di "+n2);
		}
	}
	
	public static void comparaCapienza(Veicolo v1, Veicolo v2){
		String[] nome1 = v1.getClass().getName().split("\\.");
		String n1 = nome1[nome1.length-1];
		String[] nome2 = v2.getClass().getName().split("\\.");
		String n2 = nome2[nome2.length-1];
		int posti1 = 0;
		int posti2 = 0;
		
		if(v1 instanceof Automobile) {
			posti1 = ((Automobile) v1).getNumPosti();
			System.out.println(n1+" ha "+posti1+" posti");
		}else if (v1 instanceof Ciclomotore) {
			posti1 = ((Ciclomotore) v1).getNumPosti();
			System.out.println(n1+" ha "+posti1+" posti");
		}
		if(v2 instanceof Automobile) {
			posti2 = ((Automobile) v2).getNumPosti();
			System.out.println(n2+" ha "+posti2+" posti");
		}else if (v2 instanceof Ciclomotore) {
			posti2 = ((Ciclomotore) v2).getNumPosti();
			System.out.println(n2+" ha "+posti2+" posti");
		}
		
		if(posti1>posti2) {
			System.out.println(n1+" ha maggiore capienza di "+n2);
		}else if(posti1<posti2) {
			System.out.println(n2+" ha maggiore capienza di "+n1);
		}else {
			System.out.println(n1+" ha la stessa capienza di "+n2);
		}
	}
	
	public static void main(String[] args) {
		
		Fiat_500 f = new Fiat_500();
//		System.out.println(f.getNumPosti());
//		f.viaggia();
		//Fiat_500 f2 = new Fiat_500();
		Alfa_Quadrifoglio a = new Alfa_Quadrifoglio();
		comparaCapienzaAuto(f, a);
		
		Kawasaki_Z900 k = new Kawasaki_Z900();
		comparaCapienza(f, k);
	}
}
