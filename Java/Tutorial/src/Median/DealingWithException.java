package Median;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Basic.ADHero;

public class DealingWithException {

	public static void main(String[] args) {
		
		File f = new File("d://LOL.exe");
		
//		FileInputStream fis = new FileInputStream(f); Compile Error
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse("2018-5-35");
			System.out.println(date);			
			System.out.println("Try to open LOL.exe");
			FileInputStream fis = new FileInputStream(f);
			System.out.println("Succeed Opening");
		}catch(FileNotFoundException | ParseException e) {
			if (e instanceof FileNotFoundException)
				System.out.println("File Does not exist");
			if (e instanceof ParseException)
				System.out.println("Not a interpretable format");
			e.printStackTrace();
		}finally {
			System.out.println("No matter what happened, it will be executed.");
		}
		
		//throws is in the declaration of method, thorw inside the method;
		//throws does not mean there must be a exception, it is a potential. 
		//But throw will create a exception;
		
		//Exception Classification
		//1: Checked Exception eg: FileNotFound Exception must be handled by try catch.
		//2: Runtime Exception: It is not necessary to be handled by try catch
		//there is no compiling error
		//eg: 1. Arithmetic Exception
//		int k = 5 / 0; //Arithmetic Exception
		//eg: 2. IndexOutOfBoundsException
//		int[] arr = new int[2];
//		arr[2] = 0;//IndexOutOfBoundsException
		//eg: 3. NullPoiterException
//		String str = null;
//		str.length();//NullPointerException
		//3: system error
//		StringBuffer sb = new StringBuffer("");
//		for (int i = 0; i < Integer.MAX_VALUE; i++)
//			sb.append("a");//default memory 16 MB; OutOfMemoryBound
		
		//Throwable class supper class of error and exception
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			Date d = sdf.parse("42.32132:32");
//			System.out.println(d);
//		}catch(Throwable e) {
//			e.printStackTrace();
//		}

		//Test self-defined Exception
		ADHero garen = new ADHero("Garen", 100);
		ADHero teemo = new ADHero("Teemo", 0);
		try {
			garen.attack(teemo);
		} catch (EnemyHeroIsDeadException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
        Account a = new Account(1000);
        a.deposit(1000);
        System.out.println(a.getBalance());
        try {
            a.withdraw(2001);
        } catch (OverDraftException e) {
            System.err.println("Deficit Amount:"+e.getDeficit());
            e.printStackTrace();
        }
		
//		method1();
//		System.out.println(method());
	}
	
	public static void method1() {
		try {
			method2();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void method2() throws FileNotFoundException {
		File file = new File("d://LOL.exe");
		System.out.println("Try to Open the file");
		FileInputStream fis = new FileInputStream(file);
		System.out.println("Successfully open it");
	}
	
	public static int method() {
		try {
			return return1();
		}catch(Exception e) {
			return return2();
		}finally {
			return return3();
		}
	}
	
	public static int return1() {
		System.out.println("return 1");
		return 1;
	}
	
	public static int return2() {
		System.out.println("return 2");
		return 2;
	}
	
	public static int return3() {
		System.out.println("return 3");
		return 3;
	}
}
