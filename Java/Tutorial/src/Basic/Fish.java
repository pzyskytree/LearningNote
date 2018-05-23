package Basic;

public class Fish extends Animal implements Pet{

	private String name;
	
	protected Fish(String name) {
		super(0);
		this.name = name;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Fish " + name + " is playing");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Fish " + name + " is eating");
	}
	
	@Override
	public void walk() {
		System.out.println("Fish cannot walk since it has no legs");
	}
	
}
