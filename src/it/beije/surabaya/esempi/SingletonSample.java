package it.beije.surabaya.esempi;

public class SingletonSample {
	
	private static SingletonSample sample = null;
	
	public static SingletonSample getSample() {
		if (sample == null) {
			sample = new SingletonSample();
		}
		
		return sample;
	}

	private SingletonSample() {}

}


class Example {
	
	SingletonSample s = SingletonSample.getSample();
					
}