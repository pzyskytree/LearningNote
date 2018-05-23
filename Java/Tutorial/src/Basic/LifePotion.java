package Basic;

public class LifePotion extends Item{

	public void effect() {
		System.out.println("After using life potion, your blood will be recovered");
	}

	@Override
	public boolean disposable() {
		// TODO Auto-generated method stub
		return true;
	}
}
