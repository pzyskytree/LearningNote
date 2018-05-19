package Basic;

import java.util.Scanner;

public class Operator {

	public static void main(String[] args) {
		//Basic Arithmetic Operator + - * /
		int i = 10;
	    int j = 5;
	    int a = i + j;
	    int b = i - j;
	    int c = i * j;
	    int d = i / j;
	    
	    //As long as one operand's size is larger than int,
	    //the result's size will be the same as the large one
	    long l = 100;
	    int sum = (int)(l + i);
	    long suml = l + i;
	    
	    //Mode %: a % b + b * a / b = a
		i = 23;
		j = 11;
		System.out.println(i % j);
		System.out.println(i / j);
		System.out.println(-i % j);
		System.out.println(-i / j);
		System.out.println(i % -j);
		System.out.println(i / -j);
		System.out.println(-i % -j);
		System.out.println(-i / -j);
		System.out.println();
		//Increment Dcrement
		i = 1;
		System.out.println(i++);
		System.out.println(++i);
		i = 1;
		j = ++i + i++ + ++i + ++i + i++;
		System.out.println(j);
		System.out.println();
		
		//Relation Operator: >, >=, <, <=, ==, !=
		a = 5;
		b = 6;
		c = 5;
		System.out.println(a > b);
		System.out.println(a <= b);
		System.out.println(a != b);
		System.out.println();
		
		//Logical Operator: &,&&,|,||,!,^
		//Short Circuit AND &&:If the first expression is false, it will not test the second one.
		i = 2;
		System.out.println(i > 2 && i++ == 2);
		System.out.println(i);
		//Long Circuit AND &: No matter what the result of the first expression, it will test the second one.
		i = 2;
		System.out.println(i > 2 & i++ == 2);
		System.out.println(i);
		//Short Circuit OR ||:If the first expression is true, it will not test the second one;
		i = 2;
		System.out.println(i == 2 || ++i > 3);
		System.out.println(i);
		//Long Circuit OR |: No matter what the result of the first statement, it will test the second one.
		i = 2;
		System.out.println(i == 2 | ++i > 3);
		System.out.println(i);
		// Not : !
		boolean bool = true;
		System.out.println(bool);
		System.out.println(!bool);
		//Exclusive OR: ^
		boolean bool1 = false;
		System.out.println(bool1 ^ bool);
		System.out.println(bool ^ !bool1);
		System.out.println();
		
		//Bit Operator: &, |, ~, ^, <<, >>, >>>
		i = 5;
		System.out.println(Integer.toBinaryString(i));
		//Bit OR |
		i = 5;//101
		j = 6;//110
		System.out.println(i | j);
		System.out.println(Integer.toBinaryString(i | j));
		//Bit AND &
		System.out.println(i & j);
		System.out.println(Integer.toBinaryString(i & j));
		//Bit NOT ~
		System.out.println(~i);
		System.out.println(Integer.toBinaryString(~i));
		//Bit XOR ^
		System.out.println(i ^ j);
		System.out.println(Integer.toBinaryString(i ^ j));
		//Shift
		i = -1024;
		System.out.println(i);
		System.out.println(Integer.toBinaryString(i));
		System.out.println(i >> 6);// i / 64 Signed Right Shift
		System.out.println(Integer.toBinaryString(i >> 6));
		System.out.println(i >>> 6);//UnSigned Right Shift
		System.out.println(Integer.toBinaryString(i >>> 6));
		System.out.println(i << 4);// i * 16 Left Shift
		System.out.println(Integer.toBinaryString(i));
		System.out.println();
		
		//Assignment = += /= *= -=
		i = 23;
		i += 2;
		System.out.println(i);
		i <<= 2;
		System.out.println(i);
		System.out.println();
		
		//Ternary Operator: ? :
		i = 6;
		String weekDay = i <= 5 && i >= 1 ? "week day" : "weekend";
		System.out.println(weekDay);
		
		//Scanner
		//Read Integer
		Scanner sc = new Scanner(System.in);
		i = sc.nextInt();
		System.out.println(i);
		//Read Float Point
		float f = sc.nextFloat();
		System.out.println(f);
		//Read String
		sc.nextLine();
		String str = sc.nextLine();
		System.out.println(str);
	}
}
