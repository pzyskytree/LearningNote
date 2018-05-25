package Basic;

public class InterfaceAndInherit {

	public static void main(String[] args) {
		ADHero ad = new ADHero(); // ad reference type : ADHero, object type ADHero
		//Cast: Reference type and Object type are not consistent 
		//1. Upper Cast: Sub Class to Super Class
		Hero h = new Hero();
		h = ad;
		//2. Down Cast: Super Class to Sub Class
		Hero h1 = new ADHero();
		ADHero ad1 = (ADHero)h1;
		h1 = new Hero();
//		ad1 = (ADHero)h1; //Throw Class Cast Exception;
		h1 = new Support();
//		ad1 = (ADHero)h1; //Throw Class Cast Exception;
		//3. Two class without inhertant relationship 
		ad = new ADHero();
		APHero ap = new APHero();
//		ad = (ADHero)ap; //Compiler Error
		//4. Class to Inteface
		AD adi = ad; //OK
		//5. Inteface to Class
		ADHero ad2 = (ADHero)adi;
//		ADAPHero adap = (ADAPHero)adi; //Throw Class Cast Exception;
		//instanceof check the object type
		System.out.println(h instanceof ADHero);
		System.out.println(h instanceof Hero);
//		System.out.println(h instanceof APHero); //Compiler Error
		
		//Override
//		Item i = new Item();
//		i.effect();
		LifePotion lp = new LifePotion();
		lp.effect();
		
		//Polymorphism
		//Operator +
		int k = 5, j = 6;
		System.out.println(j + k);
		System.out.println("5" + "6");
		//Class Polymorphism Same class same method different behavior.
		//1.Supper Class or Interface reference pointing to the sub class object.
		//2.Subclass has overide method.
		Item i1 = new LifePotion();
		Item i2 = new MagicPotion();
		i1.effect();
		i2.effect();
		
		//Hidden: Override Static Method
		h = new ADHero();
		h.battleWin();// Not Override the static method is only related to the reference type.
		
		//Object class: The default super class
		//toString() method for all object
		System.out.println(h);
		//finalize()//call by JVM when no reference pointing to the object
		//equals: judge whether the content of object equal or not
		System.out.println(h.equals(h1));
		//== whether the reference point to the same object
		System.out.println(h == h1);
		
		//final decorator
		//1: final ClassName: The Class cannot be inherited
		//2: final method: The method cannot be override by subclass
		//3: final Basic Variable: Only once assignment.
		//4: final object reference: Only once assignment to one object.
		final Hero hf = new Hero();
//		hf = h; //Cannot assigned to h;
		
		//Abstract Class:
		//Abstract Method: No implementation
		//Abstract Class Cannot be instance, it can have abstract method or not.
		
		//The difference between abstract class and interface:
		//1: Sub class can only implement one abstract class, subclass
		//2: The attribute in abstract class has no difference with other class. 
		// The attribute in interface can only be public static final.
		
		//Inner Class
		//1. Non-static inner class: new outerclass().new innerclass();
		//Inner class can visit the private part of outer class
		//the inner class is meaningful only if the outer class object exists.
		Hero.BattleScore bs = new Hero("garen").new BattleScore(); 
		bs.legendary();
		//2. Static inner class: new outerclass.innerclass();
		//It is ralted to the outer class not the object. It cannot visit the attribute or method of object
		Hero.EnemyCrystal ec = new Hero.EnemyCrystal();
		ec.checkIfWin();
		//3. Anonymous Class
		//Inside the anonymous class if you visit the outer local varibale the variable must be final.'
		//Inside the anonymous class it will create an attribute with the same value and name as outer
		//local variable, but it is just a copy, the change of its value does not affect the outer variable.
		Item i = new Item() {

			@Override
			public boolean disposable() {
				// TODO Auto-generated method stub
				return false;
			}
		};
		//4. Local Class
		class SomeHero extends Hero{
		}
		SomeHero sh = new SomeHero();
		
		//Default Method: JDK8
//		default key word in interface;
		ad.attack();
		ap.attack();
		new ADAPHero().attack();
		
		testPolymorphism();
		testOverride();
	}
	//Practice
	public static void testPolymorphism() {
		Hero garen = new Hero("Garen", 100);
		garen.kill(new ADHero());
		garen.kill(new APHero());
		garen.kill(new ADAPHero());
	}
	
	public static void testOverride() {
//		Item i1 = new Item("bottle", 100);
//		Item i2 = new Item("bottle", 200);
//		Item i3 = new Item("Stick", 100);
//		System.out.println(i1);
//		System.out.println(i1.equals(i2));
	}
}
