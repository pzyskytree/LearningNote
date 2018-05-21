package Basic;

public class Hero {
	
	protected String name = "some hero"; //Name of Hero
	
	protected float hp; //Blood Volume
	
	protected float armor;//Armor
	
	protected int moveSpeed; //Speed
	
	static float maxHP = 100;
	//Initialization Block
	
	static {
		System.out.println("Supper Class static block " + maxHP);
		maxHP = 1000;
	}
	
	public static String copyRight = "Blizzard";
	
	public int itemCapacity = 1;

	{
		System.out.println("Supper Class block " + itemCapacity);
		itemCapacity = 10;
	}
	
	//It will be offered by the system if we don't write it explicitly.
	public Hero() {
		System.out.println("Supper Class Constructor " + maxHP);
		System.out.println("Supper Class Constructor " + itemCapacity);
	}
	
	//Once we provide a parametered constructor, there is no default constructor.
	public Hero(String name) {
		System.out.println("Constructor with one parameter");
		this.name = name;
	}
	
	//Constructor overload
	public Hero(String name, float hp) {
		this(name);
		System.out.println("Constructor with two parameters");
		this.hp = hp;
	}
	
	public Hero(String name, float hp, float armor, int moveSpeed) {
		this(name, hp);//Call other constructor, it must be the first line of the method
		System.out.println("Constructor with four parameters");
		this.armor = armor;
		this.moveSpeed = moveSpeed;
	}
	//this: current object
	public void showAddressInMemory() {
		System.out.println("Show the virtual address of this: " + this);
	}
	
	public void setName(String name) {
		name = name;
	}
	
	public void setNameWithThis(String name) {
		this.name = name;
	}
	
	//Battle win
	public static void battleWin() {
		System.out.println("Battle Win!!");
		copyRight = "Blizzard Company";
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
	float getHp() {
		return this.hp;
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
	
}
