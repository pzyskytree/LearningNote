package bean;

public class Hero {
	public int id;
	public String name;
	public float hp;
	public int damage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getHp() {
		return this.hp;
	}
	public void setHp(float hp) {
		this.hp = hp;
	}
	public int getDamage() {
		return this.damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
}
