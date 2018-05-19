package Basic;

public class Variable {
	
	public static void main(String[] args) {
		//Basic data type
		//integer: byte(1-byte), short(2-byte), int(4-byte), long(8-byte) Default:0
		byte b1 = -128;
		byte b2 = 127;//Range -128 ~ 127
		
		short s1 = -32768;
		short s2 = 32767;//Range -32768 ~ 32767
		
		int i1 = -2147483648;
		int i2 = 2147483647;//Range -2.1*e9 ~ 2.1*e9
		
		
		long l1 = -9223372036854775808L;
		long l2 = 9223372036854775807L;//Range -9.2*e18 ~ 9.2*e18, 
		//Don't forget L sign at the end;
		
		//Character char(2-byte)
		char c = 'c';
		char zh = '中';
		
		//Floating Point: float(4-byte), double(8-byte) Default:0,0
		float f = 0.4f;//Range 3.4E-38 ~ 3.4E38
		double d = 23.42; //Range 1.7E-308 ~ 1.7E308
		
		//Boolean True or False, size based on OS
		boolean bo1 = true;
		boolean bo2 = false;
		
		//Name Rule:
		//Letters: Number[0-9], English letter[A-Za-z], _, $
		//First Letter: Letter, _, $
		//Cannot be key words, but can contain key words.
		
		//Working Field:
		//1.Attribute or field: Entire Class
		//2.Parameter: Inside the method 
		//3.Local Variable: Start from its declaration position to the end of block
		//If multiple variables with the same name are accessible in this field, pick the closest one.
		//就近原则。
		
		final int j = 11;
		final int i;
		//System.out.println(i); Compile Error
		i = 10;
		//i = 11;  
		//j = 10; Compile Error. Since if a variable is decorated by final, it can only be assigned once.
		
		
	} 
}



