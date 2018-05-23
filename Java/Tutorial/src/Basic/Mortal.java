package Basic;

public interface Mortal {

	int age = 100;//public static final
	public void die();
	
	default public void revive() {//There is no change of other class to get this method.
		System.out.println("The hero revive");
	}
}
