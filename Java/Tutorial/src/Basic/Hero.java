package Basic;

public class Hero {
	
	String name; //Name of Hero
	
	float hp; //Blood Volume
	
	float armor;//Armor
	
	int moveSpeed; //Speed
	
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
	void recovery(float blood) {
		this.hp += blood;
	}
	
}
