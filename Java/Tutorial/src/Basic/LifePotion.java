package Basic;

public class LifePotion extends Item implements Comparable{

	
	public LifePotion() {
		// TODO Auto-generated constructor stub
	}
	
	public LifePotion(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public void effect() {
		System.out.println("After using life potion, your blood will be recovered");
	}

	@Override
	public boolean disposable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		LifePotion lp = (LifePotion)arg0;
		return (int)(lp.price - this.price);
	}
}
