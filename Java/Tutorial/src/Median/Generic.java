package Median;

import java.util.ArrayList;
import java.util.List;

import Basic.ADHero;
import Basic.APHero;
import Basic.Hero;
import Basic.LifePotion;

public class Generic {
	
	public static void main(String[] args) {
		ArrayList heros = new ArrayList();
		heros.add(new APHero());
		heros.add(new ADHero());
		
		APHero ap = (APHero)heros.get(0);
		ADHero ad = (ADHero)heros.get(1);
		
//		ap = (APHero)heros.get(1);	Class Cast exception	
		
		//<Type> type: class, abstract class, interface
		ArrayList<APHero> genericheros = new ArrayList<>();
		genericheros.add(new APHero());
//		genericheros.add(new ADHero()); //Cannot add ADHero into the list
		
		ap = genericheros.get(0);
		
		ArrayList<Hero> generichero = new ArrayList<>();
		generichero.add(new APHero());
		generichero.add(new ADHero());
		
		//WildCard ?
		//1. ? extends 
		List<? extends Hero> heroList = new ArrayList<>(); //HeroList can be list of hero aphero adhero
		//The elements inside list can be cast to Hero, we cannot add element to the list. 
//		heroList.add(new APHero());//Error
		heroList = genericheros;
		Hero h = heroList.get(0);
		System.out.println(h);
//		heroList.add(new APHero());Error cannot add elements
		
		//2. ? super 
		List<? super Hero> heroList2 = new ArrayList<>();// HeroList can be list of hero or object
//		heroList2 = genericheros;Error
		heroList2.add(new Hero());
//		heroList2.add(new LifePotion());Error
		heroList2.add(new ADHero());
		h = (Hero)heroList2.get(1);
		System.out.println(h);
		
		//3 ? any type
		List<?> heroList3 = new ArrayList<>();
//		heroList3.add(new Object()); //Cannot add
		heroList3 = genericheros;
		h = (Hero)heroList3.get(0);
		System.out.println(h);
		
		//Generic Cast
		List<Hero> hList = new ArrayList<>();
		List<ADHero> adList = new ArrayList<>();
//		hList = adList; //Cannot cast subclass to superclass
//		adList = hList; //Cannot cast superclass to subclass
		numberList();
	}
	
	//Practice
	
	public static void numberList() {
		List<Number> list = new ArrayList<>();
		list.add(3);
		list.add(3.4f);
		list.add(32.432d);
//		list.add('c');
		System.out.println(list);
	}

	public static void iterate(List<? extends Hero> list) {
		for (Hero h : list) {
			System.out.println(h.getName());
		}
	}
}
