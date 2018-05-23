package Basic;

public class MagicPotion extends Item{

	public void effect() {
		System.out.println("After using magic potion, you can recover your magic value");
	}

	@Override
	public boolean disposable() {
		// TODO Auto-generated method stub
		return true;
	}
}
