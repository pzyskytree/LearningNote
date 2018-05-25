package Basic;

public class TypeCast {

	public static void main(String[] args) {
		short s = 100;
		char c = 'A';
		//s = c; Compile Error
		s = (short)c;
		System.out.println(s);
		
		//Low Precision to High Precision
		//Automatically
		long l = 100;
		int i = 200;
		l = i;
		
		//High Precision to Low Precision
		//Compulsory
		byte b = 10;
		s = 20;
		i = 300;
		
		//b = i; Compile error;
		b = (byte)s;
		b = (byte)i;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString((int)b));
		System.out.println(b);
		
		//Under the arithmetic operation if the operand's size less or equal to int, they are
		//all transfered to int automatically.
		short s1 = 10;
		short s2 = 20;
		//short res = s1 + s2; Compiler Error.Because in such case s1 and s2 are transfered to int
		short res = (short)(s1 + s2);
		System.out.println(res);
		
		
		
	}
}
