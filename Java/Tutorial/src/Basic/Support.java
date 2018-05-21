package Basic;

public class Support extends Hero{

	public void heal() {
		System.out.println(this.name  + " heals some injured hero" );
	}
	
	public void heal(Hero h) {
		System.out.println(this.name + " heals " + h.name);
	}
	
	public void heal(Hero h1, int hp) {
		h1.hp += hp;
		System.out.println(this.name + " heals " + h1.name + " with " + hp + " bloods");
	}
}
