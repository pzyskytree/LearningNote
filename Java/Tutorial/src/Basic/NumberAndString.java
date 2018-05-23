package Basic;

public class NumberAndString {

	public static void main(String[] args) {
		//Encapsulation Class
		int i = 5;
		Integer it = new Integer(i);//Basic variable to Encapsulated Class 
		int i2 = it.intValue();//Encapsulated Class to Basic Variable
		
		//Number Abstract Class
		System.out.println(it instanceof Number);
		Number num = 123.4;
		System.out.println(num);
		num = 20;
		System.out.println(num);
		//Automatic Ecapsulation and decapsulation
		Integer it2 = i;
		i2 = it2;
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		//Number to String
		String s = String.valueOf(i);//String.valueOf()
		System.out.println(s);
		s = it.toString();//toString()
		System.out.println(s);
		//String to Number
		int i3 = Integer.parseInt(s);
		System.out.println(i3);		
		float f = 3.14f;
	    s = String.valueOf(f);
	    f = Float.parseFloat(s);
	    System.out.println(s);
	    System.out.println(f);
	    //Math method java.lang.Math
	    //1.Math.round()
	    float f1 = 5.4f;
	    float f2 = 5.5f;
	    System.out.println(Math.round(f1));//四舍五入
	    System.out.println(Math.round(f2));
		//2.Math.random() 0 - 1 (cannot get 1)
	    System.out.println(Math.random());
	    //1 - 10
	    System.out.println((int)(Math.random() * 9) + 1);
	    //3.Math.sqrt() : Square Root 
	    System.out.println(Math.sqrt(2));
	    //4.Math.pow() Exponetial
	    System.out.println(Math.pow(2, 4));
	    //5.Math.PI pi
	    System.out.println(Math.PI);
	    //6.Math.E
	    System.out.println(Math.E);
	    
	    //Format output %s %d %n
	    String name = "Garen";
	    int kill = 8;
	    String title = "Legendary";
	    String sentence = name + " kills " + kill + " enemies and becomes " + title;
	    System.out.println(sentence);
	    String sentenceFormat = "%s kills %d enemies and becomes %s\n";
	    System.out.printf(sentenceFormat, name, kill, title);
	    System.out.format(sentenceFormat, name, kill, title);
	    
	    int year = 2020;
	    System.out.printf("%d%n", year);
	    System.out.printf("%8d%n", year);//Length = 8, align right
	    System.out.printf("%-8d%n", year);//align left
	    System.out.printf("%08d%n", year);//Padding with 0
	    System.out.printf("%,d%n", year);//thousand comma separator
	    System.out.printf("%.2f", Math.PI);//Decimal Point
	    
	    //Character
	    char c1 = 'a';
	    char c2 = '1';
//	    char c3 = 'ad'; //Only one character
	    Character c = c1;
	    c2 = c;
	    System.out.println(Character.isLetter('a'));
	    
//	    getE();
//	    getPrime();
	    
	}
	//Practice
	public static void testEncapsulation() {
		byte b = 1;
        short s = 2;
        float f = 3.14f;
        double d = 6.18;
        Byte b1 = b;
        Short s1 = s;
        Float f1 = f;
        Double d1 = d;
        b = b1;
        s = s1;
        f = f1;
        d = d1;
 
//        Integer i1 = b; //cannot cast byte to Integer
        Integer it = (int)b;
//        b = new Integer(1); //cannot cast Integer to byte;
        b = (byte)(int)it;
        //Max byte
        System.out.println(Byte.MAX_VALUE);	
	}
	public static void getE() {
		int n = Integer.MAX_VALUE;
		System.out.println(Math.pow(1.0 + 1.0 / n, n));
	    System.out.println(Math.E);
	}
	
	public static void getPrime(){
		int n = (int)1e7;
		int res = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					res++;
					break;
				}
			}
		}
		System.out.println(n - res);
	}
	
}
