package Median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import Basic.Hero;

public class LambdaExpression {

	public static void main(String[] args) {
		Random rand = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero" + i, rand.nextInt(1000), rand.nextInt(100)));
		}
		System.out.println(heros);
		System.out.println("hp>10 && damage < 50");
		filter(heros);
		
		System.out.println("\nAnonymous1");
		//Anonymous Class
		HeroChecker hc = new HeroChecker() {

			@Override
			public boolean test(Hero h) {
				// TODO Auto-generated method stub
				return (h.hp > 100 && h.damage < 50);
			}
			
		};
		filter(heros, hc);
		
		System.out.println("\nAnonymous2");
		HeroChecker hc2 = (Hero h) -> {return (h.hp > 100 && h.damage < 50);};
		filter(heros, hc2);
		
		System.out.println("\nAnonymous3");
		HeroChecker hc3 = (Hero h) -> (h.hp > 100 && h.damage < 50);
		filter(heros, hc3);
		
		System.out.println("\nAnonymous4");
		HeroChecker hc4 = h -> h.hp > 100 && h.damage < 50;
		filter(heros, hc4);

		System.out.println("\nLambda");
		//Lambda (Anonymous Method)
		filter(heros, h->h.hp > 100 && h.damage < 50);
		
		
		//Reference Static Method
		System.out.println("\nReference Static Method");
		filter(heros, h-> LambdaExpression.testHero(h));
		System.out.println();
		filter(heros, LambdaExpression::testHero);
		
		//Reference Object Method
		System.out.println("\nReference Object Method");
		LambdaExpression le = new LambdaExpression();
		filter(heros, le::testHero2);
		
		//Reference element's Method
		System.out.println("\nReference element's Method");
		filter(heros, h->h.matched());
		System.out.println();
		filter(heros, Hero::matched);
		
		//Reference Constructor
		//Anonymous Class
		Supplier<List> supplier = new Supplier<List>() {

			@Override
			public List get() {
				// TODO Auto-generated method stub
				return new ArrayList();
			}
		};
		getList(supplier);
		
		//Lambda
		System.out.println();
		getList(()->new ArrayList());
		//Reference Constructor
		System.out.println();
		getList(ArrayList::new);
	
		//Aggregation Operation
		for (Hero h : heros) {
			if (h.hp > 100 && h.damage < 50)
				System.out.print(h.getName() + " ");
		}
		
		System.out.println();
		heros
			.stream()
			.filter(h->(h.hp > 100 && h.damage < 50))
			.forEach(h->System.out.print(h.getName() + " "));
		
		//Pipe
		//1. Pipe source: List heros
		//2. Middle Operation: filter() return stream
		//3. End Operation: forEach() return value not stream
		
		//1. Source heros.stream() Arrays.stream(hs) Stream.of()
		System.out.println();
		Hero[] heroArray = heros.toArray(new Hero[] {});
		heroArray = heros.toArray(new Hero[heros.size()]);
		Arrays
			.stream(heroArray)
			.forEach(h->System.out.print(h.getName() + " "));
		System.out.println();
		Stream
			.of(heroArray)
			.forEach(h->System.out.print(h.getName() + " "));
		
		//2. Middle Operation .filter() .distinct(), .sorted() .sorted(Comparator<T>) .limit() .skip()
		// .mapToDouble() .map()
		//.filter()
		System.out.println("\nFilter h.hp > 100 && h.damage < 50");
		heros
			.stream()
			.filter(h->h.hp > 100 && h.damage < 50)
			.forEach(h->System.out.print(h));
		//.distinct()
		System.out.println("\nPick the unique elemet based on equals");
		heros
		.stream()
		.distinct()
		.forEach(h->System.out.print(h));
		//sort based on hp
		System.out.println("\nSorted based on hp");
		heros
		.stream()
		.sorted((h1, h2)-> (int)(h1.hp - h2.hp))
		.forEach(h->System.out.print(h));
		//Remain 3
		System.out.println("\nRemain 3");
		heros
			.stream()
			.limit(3)
			.forEach(h->System.out.print(h));
		//Skip 3
		System.out.println("\nSkip 3");
		heros
			.stream()
			.skip(3)
			.forEach(h->System.out.print(h));
		//Map to Double
		System.out.println("\nMap to Double");
		heros
			.stream()
			.mapToDouble(Hero::getHp)
			.forEach(h->System.out.print(h + " "));
		//Map to any type
		System.out.println("Map to defined string");
		heros
			.stream()
			.map(h -> h.name + " - " + h.hp + " - " + h.damage + " ")
			.forEach(h->System.out.print(h));
		
		//3. End Operation forEach() toArray() min(Comparator<T>) max(Comparator<T>) count() findFirst()
		//forEach Traverse each element
		System.out.println("\nFor Each");
		heros
			.stream()
			.forEach(h -> System.out.print(h + " "));
		//.toArray()
		System.out.println("\nTo Array");
		Object[] hs = heros.stream().toArray();//Object array
		System.out.println(Arrays.toString(hs));
		//.min()
		System.out.println("Return minimum element");
		Hero minDamageHero = heros.stream().min((h1, h2) -> h1.damage - h2.damage).get();
		System.out.println(minDamageHero);
		//.max()
		System.out.println("Return maximum element");
		Hero maxDamageHero = heros.stream().max((h1, h2) -> h1.damage - h2.damage).get();
		System.out.println(maxDamageHero);
		//.count Total number of selected element
		long count = heros.stream().count();
		System.out.println(count);
		//.findFirst() first hero
		Hero firstHero = heros.stream().findFirst().get();
		System.out.println(firstHero);
		
		getHPThirdHero();
	}
	
	public static void getHPThirdHero() {
		Random rand = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("Hero "+ i, rand.nextInt(1000), rand.nextInt(100)));
		}
		heros.stream().forEach(h -> System.out.print(h + " "));
		//Traditional Way
		System.out.println();
		Collections.sort(heros, new Comparator<Hero>() {

			@Override
			public int compare(Hero arg0, Hero arg1) {
				// TODO Auto-generated method stub
				return (int)(arg0.hp - arg1.hp);
			}
			
		});
		System.out.println(heros.get(2).getName());
		//Use stream()
		System.out.println(heros
			.stream()
			.sorted((h1, h2) -> (int)(h1.hp - h2.hp))
			.skip(2)
			.map(h -> h.getName())
			.findFirst()
			.get());
	}
	
	
	public static List getList(Supplier<List> supplier) {
		return supplier.get();
	}
	
	public boolean testHero2(Hero h) {
		return h.hp > 100 && h.damage < 50;
	}
	
	public static boolean testHero(Hero h) {
		return h.hp > 100 & h.damage < 50;
	}
	
	public static void filter(List<Hero> heros, HeroChecker hc) {
		for (Hero h : heros) {
			if (hc.test(h))
				System.out.print(h + " ");
		}
	}
	
	public static void filter(List<Hero> heros) {
		for (Hero h: heros) {
			if (h.hp > 10 && h.damage < 50) {
				System.out.print(h + " ");
			}
		}
	}
}
