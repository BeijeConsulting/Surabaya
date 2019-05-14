package it.beije.surabaya.cap5.savana;

public class Leone implements Predatore, Carnivoro {

	public void mangioCarne() {
		System.out.println("mangio una bistecca...");
	}
	
	public void caccia() {
		System.out.println("ogni mattina etc etc...");
	}
	
	public static void main(String[] args) {
		Leone leone = new Leone();
		
		leone.mangio((Preda)new Gazzella());
		leone.mangio((Carnivoro)new Opossum());
	}

}
