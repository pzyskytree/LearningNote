package Basic;

public class LifePotion extends Item{

	
	public LifePotion() {
		// TODO Auto-generated constructor stub
	}

	public void effect() {
		System.out.println("After using life potion, your blood will be recovered");
	}

	@Override
	public boolean disposable() {
		// TODO Auto-generated method stub
		return true;
	}
}
