package Basic;

public class Main {

	public static void main(String[] args) {
		Hero garen = new Hero();
		garen.name = "Garen";
		garen.moveSpeed = 350;
		garen.addSpeed(100);
		System.out.println(garen.moveSpeed);
	}
}
