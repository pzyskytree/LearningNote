package Basic;

public class ClassAndObject {

	public static void main(String[] args) {
		new Hero();//Object
		Hero h = new Hero();//Reference
		Hero h1 = h;//One object multiple referenece
		//Inherit
		Weapon w = new Weapon();
		w.name = "sword";
		w.damage = 100;
		w.price = 1000;
		
		//Overload
		ADHero hunter = new ADHero();
		hunter.name = "Hunter";
		ADHero garen = new ADHero();
		garen.name = "Garen";
		ADHero teemo = new ADHero();
		teemo.name = "Teemo";
		hunter.attack();
//		hunter.attack(garen);
		hunter.attack(garen, teemo);
		
		//This
		h.showAddressInMemory();
		h1.showAddressInMemory();
		hunter.showAddressInMemory();
		garen.showAddressInMemory();
		//Use this to visit attribute
		h.setName("Master");
		System.out.println(h.name);//Null
		h.setNameWithThis("Master");
		System.out.println(h.name);//Master
		h = new Hero("Master", 100.0f, 230.0f, 24);
		
		//Parameter Passing
		//Basic Data Type
		int bloodBottle = 100;
		h.recovery(bloodBottle);
		System.out.println(bloodBottle);//Its value is still 100, bloodBottle is a variable
		teemo = new ADHero("Teemo", 100);
		garen = new ADHero("Garen", 200);
		garen.attack(teemo, 200);
		System.out.println(teemo.hp);
		teemo.revive(teemo);//Value copy of reference
		System.out.println(teemo.hp);
		
		//Relation between Class
		//1. Self
		//2. Subclass in the same package
		//3. Subclass in the different package
		//4. Class in the same package
		//5. Other class
		//private 1.visit 2.not inherit 3.not herit 4.not visit 5.not visit //Attribute
		//default/no modifier: 1: visit 2.inherit 3.not inherit 4. visit 5. not visit
		//protected: 1. visit 2. inherit 3. inherit 4. visit 5. not visit
		//public: 1.visit 2.inherit 3.inherit 4.visit 5. visit //Method
		
		//Class Attribute: static all object share the same value
		Hero.copyRight = "Riot Game";
		System.out.println(garen.name + " " + garen.copyRight);
		garen.copyRight = "Blizzard";
		System.out.println(teemo.name + " " + teemo.copyRight);
		
		//Class Method: static method
		Hero.battleWin();
		garen.battleWin();
		System.out.println(Hero.copyRight);
		
		//Attribute Initialization
		//Object Attribute
		//1. Initialize when declaration. First 
		//2. Initialization Block. Second
		//3. Inside constructor Last
		//Class Attribute
		//1: Initialize when delaration
		//2: static initialization block
//		new ADHero();
		//Order: 
//		1.Supper Class static block
//		2.Subclass static block
//		3.Supper Class block 
//		4.Supper Class Constructor
//		5.Subclass block
//		6.SubClass Constructor
		
		
		//Singleton Pattern
		//1. Private Constructor
		//2. Private Static instance
		//3. Public Static getInstance
		
		//Enumeration
		Season season = Season.SPRING;//Restrict the value to be spring to winter
		switch(season) {
			case SPRING: System.out.println("Spring");
						 break;
			case SUMMER: System.out.println("Summer");
						 break;
			case AUTUMN: System.out.println("Autumn");
			             break;
			case WINTER: System.out.println("Winter");
			             break;
		}
		for (Season s : Season.values()) {
			System.out.println(s);
		}
		
	}
	
	//Practice
	public static void createArmor() {
		Armor cloth = new Armor();
		cloth.name = "cloth";
		cloth.price = 300;
		cloth.ac = 15;
	}
	
	
}
