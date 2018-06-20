package Median;

public class Hero {

	public int id;
	public String name;
	public float hp;
	public int damage;
	
	public Hero() {
		
	}
	
	public Hero(int id, String name, float hp, int damage) {
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}
	
	public String toString() {
		return id + " " + name + " " + hp + " " + damage;
	}
}
