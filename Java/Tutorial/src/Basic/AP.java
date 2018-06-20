package Basic;

//@FunctionalInterface //Cannot use this annotation since it has two abstract method
public interface AP {
	public void magicAttack();
	
	default void attack() {
		System.out.println("AP Attack");
	}
	
	public void test();
}
