package Basic;

public interface AP {

	public void magicAttack();
	
	default void attack() {
		System.out.println("AP Attack");
	}
}
