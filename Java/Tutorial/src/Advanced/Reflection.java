package Advanced;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import Basic.ADHero;
import Basic.APHero;
import Basic.Hero;

public class Reflection {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		//ClassObject
		String className = "Basic.Hero";
		try {
			//Static block will be execute except for Hero.class
			//1. Class.forName
			Class class1 = Class.forName(className);
			System.out.println(class1);
			//2. ClassName.class 
			Class class2 = Hero.class;// It will not initialize the static block
			System.out.println(class2);
			//3. new ClassName().getClass()
			Class class3 = new Hero().getClass();
			System.out.println(class3);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		//synchronized decorate static class: Synchronize class object
//		Thread t1 = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				Reflection.method1();
//			}
//			
//		});
//		t1.start();
//		t1.setName("Thread1");
//		Thread t2 = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				Reflection.method2();
//			}
//		});
//		t2.start();
//		t2.setName("Thread2");
		
		
		//Create Object
		Hero h1 = new Hero("Garen");
		System.out.println(h1);
		try {
			Class hClass = Class.forName("Basic.Hero");
			//Get Constructor
			Constructor cons = hClass.getConstructor(String.class);
			//Create new instance
			Hero h2 = (Hero)cons.newInstance("Teemo");
			System.out.println(h2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//Visit Attribute
		h1 = new Hero();
		h1.name = "Teemo";
		System.out.println(h1);
		try {
			//GetField: Only public attribute including the inherited ones
			//getDelcaredField: All attributes except for the inherited attributes
			Field f = Class.forName("Basic.Hero").getDeclaredField("name");
			f.set(h1, "Garen");
			System.out.println(h1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Call Method
		h1 = new Hero();
		try {
			Method method = h1.getClass().getMethod("setName", String.class);
			method.invoke(h1, "Anna");
			System.out.println(h1.getName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//Use Reflection
		File springConfigFile = new File("e://java//test//spring.txt");
		Properties springConfig = new Properties();
		String cName = null;
		String mName = null;
		try {
			springConfig.load(new FileInputStream(springConfigFile));
			cName = springConfig.getProperty("class");
			mName = springConfig.getProperty("method");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Class sClass = Class.forName(cName);
			Method method = sClass.getMethod(mName);
			Constructor constructor = sClass.getConstructor();
			Object o = constructor.newInstance();
			method.invoke(o);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		//createHeroFromConfig();
		//callMethod();
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void callMethod() {
		File file = new File("e://java//test//hero.config");
		try(FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr)){
			String className1 = br.readLine();
			Class class1 = Class.forName(className1);
			Constructor constructor1 = class1.getConstructor();
			Hero h1 = (Hero)constructor1.newInstance();
			String name1 = br.readLine();
			Field f1 = class1.getField("name");
			f1.set(h1, name1);
			
			String className2 = br.readLine();
			Class class2 = Class.forName(className2);
			Constructor constructor2 = class2.getConstructor();
			Hero h2 = (Hero)constructor2.newInstance();
			String name2 = br.readLine();
			Field f2 = class2.getField("name");
			f2.set(h2, name2);
			
			Method method = class1.getMethod("attackHero", Hero.class);
			method.invoke(h1, h2);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createHeroFromConfig() {
		File file = new File("e://Java//Test//hero.config");
		String className = null;
		try(FileInputStream fis = new FileInputStream(file)){
			byte[] bytes = new byte[(int)file.length()];
			fis.read(bytes);
			className = new String(bytes);
		}catch(IOException e) {
			e.printStackTrace();
		}
		if (className != null) {
			try {
				Class hc = Class.forName(className);
				Constructor cons = hc.getConstructor();
				if (className.endsWith("ADHero")) {
					ADHero hero = (ADHero)cons.newInstance();
					hero.name = "Teemo";
					hero.physicAttack();
				}
				if (className.endsWith("APHero")) {
					APHero hero = (APHero)cons.newInstance();
					hero.name = "Teemo";
					hero.magicAttack();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void method1() {
		synchronized(Reflection.class) {
			System.out.println(Thread.currentThread().getName() + " inside method1");
			try {
				System.out.println("Run method1 for 5 seconds");
				Thread.sleep(5000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized void method2() {
		System.out.println(Thread.currentThread().getName() + " inside method2");
		try {
			System.out.println("Run method2 for 5 seconds");
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
