package Basic;

public class Value {

	public static void main(String[] args) {
		//Integer Value: int as default, padded by L is long
		//Decimal 0~9, Hexadecimal 0~9 A~F, Octal System: 0~7, Binary: 0,1
		long val = 26L; //[0-9]L
		int decVal = 26;
		int hexVal = 0x1a;//0x[0-9a-f]
		int octVal = 032;//0[0-9]
		int binVal = 0b11010;//0b[0-9]
		System.out.println(val + "," + decVal + "," + hexVal + "," + octVal + "," + binVal);
		
		//Floating Point Value
		float f = 123.4F;//[0-9\\.]F
		double d1 = 123.4;
		double d2 = 1.234e2;//[1\\.0-9]e[0-9]
		
		//Character
		char c = 'c';
		char tab = '\t';
		char carriageReturn = '\r';
		char newLine = '\n';
		char doubleQuote = '\"';
		char singleQuote = '\'';
		char bachSlash = '\\';
		
		
				
		
	}
}
