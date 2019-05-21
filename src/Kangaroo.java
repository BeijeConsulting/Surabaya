class Marsupial {
	boolean isBiped() {
		return false;
	}
	public void getDescription() {
		System.out.println("Marsupial walks on two legs: "+isBiped());
	}
}

public class Kangaroo extends Marsupial {
	boolean isBiped() {
		return true;
	}
//	public void getDescription() {
//		System.out.println("Kangaroo walks on two legs: "+isBiped());
//	}
	public static void main(String[] args) {
		Kangaroo joey = new Kangaroo();
		joey.getDescription();
		
		Marsupial joey2 = new Marsupial();
		joey2.getDescription();
		//joey2.getKangarooDescription();
		
		Marsupial joey3 = new Kangaroo();
		joey3.getDescription();
		//joey3.getKangarooDescription();
	}
}