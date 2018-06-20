package Basic;

@FunctionalInterface
public interface AD {

	public void physicAttack();
	
	default public void attack() {
		System.out.println("AD Attack");
	}
}
