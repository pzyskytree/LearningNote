package Basic;

import Median.EnemyHeroIsDeadException;

public class ADHero extends Hero implements AD, Mortal{
	
//	static {
//		System.out.println("Subclass static block " + maxHP);
//		maxHP = 2000;
//	}
//	
//	{
//		System.out.println("Subclass block " + itemCapacity);
//		itemCapacity = 20;
//	}
//	
	public ADHero() {
//		super();
//		System.out.println("SubClass Constructor " + maxHP);
//		System.out.println("SubClass Constructor " + itemCapacity);
	}
	
	public ADHero(String name, float hp) {
		super(name, hp);
	}

//	public void attack() {
//		System.out.println(this.name + " attack some hero.");
//	}
//	
	public void attack(Hero h) throws EnemyHeroIsDeadException {
		if (h.hp == 0)
			throw new EnemyHeroIsDeadException();
		System.out.println(this.name + " attack " + h.name);
	}
	
	public void attack(Hero h1, Hero h2) {
		System.out.println(this.name + " attack " + h1.name + " and " + h2.name + " at the same time" );
	}
	//Amount Changable Parameter
	public void attack(Hero...heros) {
		for (Hero h : heros) {
			System.out.println(this.name + " attack " + h.name);
		}
	}
	
	public void attack(Hero h1, int damage) {
		h1.hp -= damage;
	}
	
	public void physicAttack() {
		System.out.println("Physical Attack");
		
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		System.out.println("Physical Hero Die");
		
	}
	
//	@Override
	public static void battleWin(){
		System.out.println("AD Hero Battle Win!!");
	}
}
