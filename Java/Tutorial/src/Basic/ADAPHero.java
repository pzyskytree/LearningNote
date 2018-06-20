package Basic;

public class ADAPHero implements AD, AP, Mortal{

	@Override
	public void magicAttack() {
		// TODO Auto-generated method stub
		System.out.println("Magical Attack");
	}

	@Override
	public void physicAttack() {
		// TODO Auto-generated method stub
		System.out.println("Physical Attack");
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		System.out.println("All round Hero Die");
	}

	@Override //There exist conflict of the attack method since both AD AP has default method named attack
	public void attack() {
		// TODO Auto-generated method stub
//		AP.super.attack();
//		AD.super.attack();
		System.out.println("APAD attack");
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
