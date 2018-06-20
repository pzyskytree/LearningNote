package Basic;

public class APHero extends Hero implements AP, Mortal{
	
	@Override
	public void magicAttack() {
		// TODO Auto-generated method stub
		System.out.println("Magical Attack");
	}
	
	@Override
	public void die() {
		System.out.println("Magical Hero Die");
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
