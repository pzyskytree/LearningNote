package Basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.Synthesizer;

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
	    System.out.printf("%.2f%n", Math.PI);//Decimal Point
	    
	    //Character
	    char c1 = 'a';
	    char c2 = '1';
//	    char c3 = 'ad'; //Only one character
	    Character c = c1;
	    c2 = c;
	    System.out.println(Character.isLetter('a'));
	    
	    //Method
	    System.out.println(Character.isLetter('c'));
	    System.out.println(Character.isDigit('3'));
	    System.out.println(Character.isWhitespace(' '));
	    System.out.println(Character.isUpperCase('A'));
	    System.out.println(Character.isLowerCase('g'));
	    System.out.println(Character.toLowerCase('A'));
	    System.out.println(Character.toUpperCase('d'));
	    
//	    String a = 'a';//Cannot cast a character to String directly;
	    String a =  Character.toString('a');
	    System.out.println(a);
	    
	    //Special Character
	    //\t align on both sides. The length of \t is 8 character
	    System.out.println("abc\tdef");
        System.out.println("ab\tdef");
        System.out.println("a\tdef");
        System.out.println("12345678def");
        // \n new line
        System.out.println("abc\ndef");
        System.out.println("\'");
        System.out.println("\"");
        System.out.println("\\");
        
        //String
        //Create String
        String garen = "Garen";
        String teemo = new String("Teemo");
        char[] cs = {'h','e','r','o'};
        System.out.println(cs);
        String str = String.valueOf(cs);
        System.out.println(str);
        //String class is decorated by final which cannot be inherited
        //String is immutable which means a string cannot be changed
        System.out.println(garen.length());
        //Test String Method
        //1. charAt()
        for (int j = 0; j < garen.length(); j++) {
        	System.out.println(garen.charAt(j));
        }
        //2.toCharArray()
        char[] hero = garen.toCharArray();
        System.out.println(Arrays.toString(hero));
        //3.substring()
        String sub = garen.substring(1,3);
        System.out.println(sub);
        //4. split()
        garen = "  Garen is a super hero  ";
        String[] strs = garen.split(" ");
        System.out.println(Arrays.toString(strs));
        //5. trim();
        System.out.println(garen.trim());
        //6. toLowerCase(), toUpperCase()
        System.out.println(garen.toLowerCase() + garen.toUpperCase());
        //7.indexOf() contains()
        System.out.println(garen.indexOf("is"));
        System.out.println(garen.contains("super"));
        System.out.println(garen.replace("super", "bad"));
        
        //Compare String
        //1.equals() equalsIgnoreCase()
        String str1 = "The Light";
        String str2 = new String(str1);
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        String str3 = "The Light";
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);
        String str4 = "the light";
        System.out.println(str1.equals(str4));
        System.out.println(str1.equalsIgnoreCase(str4));
        //2. startsWith() endsWith()
        System.out.println(str1.startsWith("The"));
        System.out.println(str2.endsWith("Light"));
        
        //StringBuffer
        str = "let there";
        StringBuffer sb = new StringBuffer(str);
        //append()
        sb.append(" be light");
        System.out.println(sb.toString());
        //delete()
        sb.delete(0, 3);
        System.out.println(sb.toString());
        //insert()
        sb.insert(7, "will ");
        System.out.println(sb.toString());
        //reverse()
        System.out.println(sb.reverse());
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        
        //MyStringBuilder
        MyStringBuffer msb = new MyStringBuffer("Hello World");
        msb.append('f');
        msb.reverse();
        System.out.println(msb);
        msb.delete(4,5);
        System.out.println(msb);
//        getUpperCharacterAndNumber();
//	      getE();
//	      getPrime();
//        System.out.println(generateRandomString(5));
//        testStringSort();
//	    stringMethodTest();
//        compareString();
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
	
	public static void getUpperCharacterAndNumber() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		for (Character c : str.toCharArray()) {
			if (Character.isDigit(c) || Character.isUpperCase(c)) {
				System.out.print(c);
			}
		}
	}
	
	public static String generateRandomString(int length) {
		char[] res = new char[length];
		for (int i = 0; i < length; i++) {
			res[i] = (char)(Math.random() * 255);
			while ((res[i] < 65 || res[i] > 90) && (res[i] < 97 || res[i] > 122) && !Character.isDigit(res[i])) {
				res[i] = (char)(Math.random() * 126);
			}
		}
		
		return String.valueOf(res);
	}
	
	public static void testStringSort() {
		String[] strs = new String[8];
		for (int i = 0; i < strs.length; i++) {
			strs[i] = generateRandomString(5);
		}
		stringSort(strs);
		System.out.println(Arrays.toString(strs));
 	}
	
	public static void stringSort(String[] strs) {
		quickSort(strs, 0, strs.length);
	}
	
	public static void quickSort(String[] strs, int start, int end) {
		if (start < end) {
			int pivot =  getPivot(strs, start, end);
			quickSort(strs, start, pivot);
			quickSort(strs, pivot + 1, end);
		}
	}
	
	public static int getPivot(String[] strs, int start, int end) {
		int i = start, j = start + 1;
		while (j < end) {
			if (Character.toLowerCase(strs[j].charAt(0)) <= Character.toLowerCase(strs[start].charAt(0))) {
				String temp = strs[++i];
				strs[i] = strs[j];
				strs[j] = temp;
			}
			j++;
		}
		String temp = strs[i];
		strs[i] = strs[start];
		strs[start] = temp;
		return i;
	}
	
	public static void stringMethodTest() {
		String sentence = "let there be light";
		String[] words = sentence.split(" ");
		sentence = "";
		for (String word : words) {
			char[] cs = word.toCharArray();
			cs[0] = Character.toUpperCase(cs[0]);
			sentence += (String.valueOf(cs) + " ");
		}
		System.out.println(sentence.trim());
		
		sentence = "peter piper picked a peck of pickled peppers";
		words = sentence.split(" ");
		int res = 0;
		for (String word : words) {
			if (word.charAt(0) == 'p')
				res++;
		}
		System.out.println(res);
		
		sentence = "lengendary";
	    char[] cs = sentence.toCharArray();
	    for (int i = 0; i < cs.length; i += 2) {
	    	cs[i] = Character.toUpperCase(cs[i]);
	    }
	    sentence = String.valueOf(cs);
	    System.out.println(sentence);
	    
	    sentence = "lengendary";
	    cs = sentence.toCharArray();
	    cs[sentence.length() - 1] = Character.toUpperCase(cs[sentence.length() - 1]);
	    sentence = String.valueOf(cs);
	    System.out.println(sentence);
	    
	    sentence = "Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";
	    int index = sentence.lastIndexOf("two");
	    cs = sentence.toCharArray();
	    cs[index] = 'T';
	    System.out.println(String.valueOf(cs));
	    System.out.println(sentence);
	    System.out.println(sentence.replace("two", "Two"));
	}
	
	public static void compareString() {
		String[] strs = new String[100];
		for (int i = 0; i < strs.length; i++)
			strs[i] = generateRandomString(2);
		String res = "";
		for (int i = 0; i < strs.length; i++) {
			System.out.print(strs[i] + " ");
			if (res.contains(strs[i])) {
				continue;
			}
			for (int j = i + 1; j < strs.length; j++) {
				if (strs[i].equalsIgnoreCase(strs[j])) {
					res += (strs[i] + " ");
					break;
				}
			}
		}
		System.out.println();
		String[] duplicate = res.trim().split(" ");
		System.out.println(duplicate.length);
		System.out.println(res.trim());
	}
	
}
