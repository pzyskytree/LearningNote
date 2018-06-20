package Basic;

import java.io.Serializable;

public class Hero implements Serializable, Comparable{
	
	private static final long serialVersionUID = 1L; 
	
	public String name = "some hero"; //Name of Hero
	
	public float hp; //Blood Volume
	
	public int damage;
	
	protected float armor;//Armor
	
	protected int moveSpeed; //Speed
	
	static float maxHP = 1000;
	//Initialization Block
	
	static {
		//System.out.println("Supper Class static block " + maxHP);
		System.out.println("Static initialize");
		maxHP = 1000;
	}
//	
	public static String copyRight = "Blizzard";
	
	public int itemCapacity = 1;

//	{
//		System.out.println("Supper Class block " + itemCapacity);
//		itemCapacity = 10;
//	}
	
	//It will be offered by the system if we don't write it explicitly.
	public Hero() {
//		System.out.println("Supper Class Constructor " + maxHP);
//		System.out.println("Supper Class Constructor " + itemCapacity);
	}
	
	//Once we provide a parametered constructor, there is no default constructor.
	public Hero(String name) {
//		System.out.println("Constructor with one parameter");
		this.name = name;
	}
	
	//Constructor overload
	public Hero(String name, float hp) {
		this(name);
//		System.out.println("Constructor with two parameters");
		this.hp = hp;
	}
	
	public Hero(String name, float hp, float armor, int moveSpeed) {
		this(name, hp);//Call other constructor, it must be the first line of the method
		System.out.println("Constructor with four parameters");
		this.armor = armor;
		this.moveSpeed = moveSpeed;
	}
	
	public Hero(String name, float hp, int damage) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}

	//this: current object
	public void showAddressInMemory() {
		System.out.println("Show the virtual address of this: " + this);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNameWithThis(String name) {
		this.name = name;
	}
	
	//Battle win
	public static void battleWin() {
		System.out.println("Battle Win!!");
//		copyRight = "Blizzard Company";
//		this.name = "wrong";//All the variables in static Mathod is static
//		showAddressInMemory();// All the Method in the static method should be static
	}
	
	
	//Keng teammate
	void keng() {
		System.out.println("Keng teammates");
	}
	
	//Get armor
	float getArmor() {
		return this.armor;
	}
	
	//Add Speed
	void addSpeed(int speed) {
		this.moveSpeed += speed;
	}
	
	//Legendary 
	void legendary() {
		System.out.println("Legendary!");
	}
	
	//Get Blood Volume;
	public float getHp() {
		return this.hp;
	}
	
	public String getName() {
		return this.name;
	}
	
	//Blood recovery
	public void recovery(int blood) {
		this.hp += blood;
		blood = 0;
	}
	
	//Revive
	public void revive(Hero h) {
		h = new Hero("Teemo", 100);
	}
	
	public void kill(Mortal m) {
		m.die();
	}
	
	@Override
	public String toString() {
		return "Hero [name= " +  name + " hp= " + hp + " damage= " + damage + " ]";
	}
	

	
	
//	public boolean equals(Object o) {
//		if (o instanceof Hero) {
//			Hero h = (Hero) o;
//			return h.name.equals(this.name);
//		}
//		return false;
//	}
//	
	
	public class BattleScore{
		int kill;
		int ide;
		int assist;
		
		public void legendary() {
			if (kill >= 8) {
				System.out.println(name + " Legendary");
			}else {
				System.out.println(name + " Non-Legendary");
			}
		}
	}
	
	public static class EnemyCrystal{
		int hp = 5000;
		public void checkIfWin() {
			if (hp == 0) {
				Hero.battleWin();
//				System.out.println(name + "wins the game"); static inner class cannot 
				//visit non-static atrribute name
			}
			System.out.println(Hero.copyRight);
		}
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		Hero h = (Hero)arg0;
		return (int)(this.damage - h.damage);
	}
	
	public boolean matched() {
		return this.hp > 100 && this.damage < 50;
	}
	
	
	public void attackHero(Hero h) {
//		try {
//			Thread.sleep(1000);
//		} catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		
		h.hp -= this.damage;
		System.out.format("%s is attacking %s, %s's blood become %.0f\n", this.name, h.name, h.name, h.hp);
		if (h.isDead())
			System.out.println(h.name + " is dead");
	}
	
	public boolean isDead() {
		return this.hp <= 0;
	}
	//synchronized method = synchronized(this)
	public synchronized void hurt() {
//		if (this.hp == 1) {
		while (this.hp == 1) {
			try {
				this.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.hp--;
		this.notify();//May notify the hurt thread
	}
	
	public void recover() {
		synchronized(this) {
//			if (this.hp >= Hero.maxHP){
			while (this.hp >= Hero.maxHP) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.hp++;
			this.notify();
		}
		
	}
	
	public void adugen() {
		Thread t1 = new Thread() {
			public void run() {
				while(true) {
					try {
						for (int i = 0; i < 3; i++) {
							System.out.println("Adugen " + (i + 1));
							Thread.sleep(1000);
						}
						System.out.println("Charging for 5 seconds");
						Thread.sleep(5000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
	}
}
