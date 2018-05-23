package Basic;

public abstract class Item {
	
	String name;//Item name
	
	int price; //Item price
	
	public Item() {
		
	}
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void buy() {
		System.out.println("Buy");
	}
	
	public void effect() {
		System.out.println("After using this item, it has this effect");
	}
	
	public String toString() {
		return this.name + this.price;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Item) {
			Item i = (Item)o;
			return i.price == this.price;
		}
		return false;
	}
	
	public abstract boolean disposable();
}
