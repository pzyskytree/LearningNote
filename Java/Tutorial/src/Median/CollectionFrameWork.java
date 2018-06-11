package Median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import Basic.ADHero;
import Basic.Hero;
import Basic.Item;
import Basic.LifePotion;

public class CollectionFrameWork {

	private static ArrayList heros;

	public static class Node<T extends Comparable>{
		
		public Node leftNode;
		
		public Node rightNode;
		
		public T value;
		
		public void add(T v) {
			if (null == this.value) {
				this.value = v;
				return;
			}
			if (this.value.compareTo(v) >= 0) {
				if (leftNode == null)
					leftNode = new Node();
				leftNode.add(v);
			}else {
				if (rightNode == null)
					rightNode = new Node();
				rightNode.add(v);
			}
		}
		
		public void preorderTraverseRecursive() {
			System.out.print(value + " ");
			if (leftNode != null)
				leftNode.preorderTraverseRecursive();
			if (rightNode != null)
				rightNode.preorderTraverseRecursive();
		}
		public void preorderTraverseIterative() {
			Stack<Node> stack = new Stack<>();
			Node cur = this;
			while (!stack.isEmpty() || cur != null) {
				while (cur != null) {
					stack.push(cur);
					System.out.print(stack.peek().value + " ");
					cur = cur.leftNode;
				}
				cur = stack.pop().rightNode;
				
			}
		}
		
		public void inorderTraverseRecursive() {
			if (this.leftNode != null) {
				this.leftNode.inorderTraverseRecursive();
			}
//			System.out.print(this.value + " ");
			if (this.rightNode != null) {
				this.rightNode.inorderTraverseRecursive();
			}
			
		}
		
		public void inorderTraverseIterative() {
			Stack<Node> stack = new Stack<>();
			Node cur = this;
			while (!stack.isEmpty() || cur != null) {
				while (cur != null) {
					stack.push(cur);
					cur = cur.leftNode;
				}
//				System.out.print(stack.peek().value + " ");
				cur = stack.pop().rightNode;
			}
		}
		
		public void postorderTraverseRecursive() {
			if (leftNode != null)
				this.leftNode.postorderTraverseRecursive();
			if (rightNode != null)
				this.rightNode.postorderTraverseRecursive();
			System.out.print(this.value + " ");
		}
		
		public void postorederTraverseIterative() {
			Stack<Node> stack = new Stack<>();
			Node cur = this;
			Node pre = null;
			while (!stack.isEmpty() || cur != null) {
				while(cur != null) {
					stack.push(cur);
					cur = cur.leftNode;
				}
				cur = stack.peek().rightNode;
				if (cur == null || cur == pre) {
					pre = stack.pop();
					System.out.print(pre.value + " ");
					cur = null;
				}
			}
		}
		
		public String toString() {
			return String.valueOf(value); 
		}
	}
	public static void main(String[] args) {
		heros = new ArrayList();
		for (int i = 0; i < 5; i++)
			heros.add(new Hero("hero " + i));
		System.out.println(heros);
		heros.add(1, new Hero("hero 10"));
		System.out.println(heros);
		//2. Contains check whether a specific object is in the list or not.
		System.out.println(heros.contains(new Hero("hero 1"))); //Based on the result of equals;
		Hero special = new Hero("Special");
		System.out.println(heros.contains(special));
		heros.add(special);
		System.out.println(heros.contains(special));
		//3.Get: Access to the object
		System.out.println(heros.get(3));
//		System.out.println(heros.get(100)); //IndexOutOfRange Exception
		//4. IndexOf: get elements position
		System.out.println(heros.indexOf(special));
		System.out.println(heros.indexOf(new Hero("hero 1"))); //return -1 if not exist
		//5. Remove
		heros.remove(1);
		System.out.println(heros);
//		heros.remove(10); //IndexOutOfRange
		//6. Set
		heros.set(3, new Hero("new hero 3"));
		System.out.println(heros);
		//7. Size
		System.out.println(heros.size());
		//8. toArray
		Hero[] heroArray = (Hero[])heros.toArray(new Hero[] {});
		System.out.println(heros.toArray());
		System.out.println(Arrays.toString(heroArray));
		//9. AddAll
		ArrayList heros1 = new ArrayList();
		heros1.add(new Hero("hero a"));
		heros1.add(new Hero("hero b"));
		heros1.addAll(heros);
		System.out.println(heros1);
		//10.clear
		heros.clear();
		System.out.println(heros);	
		
		//List Interface
		List heroList = new ArrayList();
		heroList.add(new Hero("teemo"));
		System.out.println(heroList.size());
		//Generic
		heroList.add(new LifePotion());
		Hero h1 = (Hero)heroList.get(0);
//		Hero h2 = (Hero)heroList.get(1); Cast exception
		List<Hero> genericHero = new ArrayList<>();
		genericHero.add(new Hero("teemo"));
//		genericHero.add(new LifePotion()); LifePotion is not a hero
		genericHero.add(new ADHero());
		h1 = genericHero.get(1);
		
		//List Traverse
		//For 
		for (int i = 0; i < heros1.size(); i++) {
			System.out.print(heros1.get(i) + " ");
		}
		System.out.println();
		//Iterator
		Iterator it = heros1.iterator();
		while (it.hasNext()) {
			Hero h = (Hero)it.next();
			System.out.print(h + " ");
		}
		System.out.println();
		//For each
		for (Object h : heros1) {
			System.out.print(h + " ");
		}
		System.out.println();
		
		//LinkedList
		//Deque interface
		Deque<Hero> ll = new LinkedList<>();
		ll.addLast(new Hero("hero 1"));
		ll.addLast(new Hero("hero 2"));
		ll.addLast(new Hero("hero 3"));
	    System.out.println(ll);
		ll.addFirst(new Hero("hero 0"));
		System.out.println(ll);
		
		System.out.println(ll.getFirst());
		System.out.println(ll.getLast());
		
		System.out.println(ll.pop());//Remove First
		System.out.println(ll);
		System.out.println(ll.removeFirst());
		System.out.println(ll);
		System.out.println(ll.removeLast());
		System.out.println(ll);
		
		
		//Queue FIFO
		Queue<Hero> lq = new LinkedList<>();
		System.out.println(lq.peek());//Return null
//		System.out.println(lq.element());//ThrowException
		
		lq.offer(new Hero("hero 1")); //Return special Value
		lq.add(new Hero("hero 2")); // Throw exception
		lq.offer(new Hero("hero 3"));
		System.out.println(lq);
		
		System.out.println(lq.peek());//Return first element return specail element
		System.out.println(lq.element());//Return first element throw exception
		
		System.out.println(lq.poll());
		System.out.println(lq);
		System.out.println(lq.remove());
		System.out.println(lq);
		lq.remove();
		System.out.println(lq.poll());//Return special value null
//		System.out.println(lq.remove());//Throw exception
		
		
		int[] random = new int[] {67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
		Node root = new CollectionFrameWork.Node();
		for (Integer i : random) {
			root.add(i);
		}
		root.preorderTraverseRecursive();
		System.out.println();
		root.preorderTraverseIterative();
		System.out.println();
		root.inorderTraverseRecursive();
		System.out.println();
		root.inorderTraverseIterative();
		System.out.println();
		root.postorderTraverseRecursive();
		System.out.println();
		root.postorederTraverseIterative();
		System.out.println();
		
		
		//HashMap
		HashMap<String, String> dictionary = new HashMap<>();
		dictionary.put("adc", "Physical Hero");
		dictionary.put("apc", "Magical Hero");
		System.out.println(dictionary.get("adc"));
		
		//HashSet
		HashSet<String> set = new HashSet<>();
		set.add("green");
		System.out.println(set);
		set.add("green");
		System.out.println(set);
		//There is no guaranteed order
		set.add("red");
		set.add("yellow");
		System.out.println(set);
		//Traverse  Cannot use get since there is no order
		//1. For each
		for (String s : set) {
			System.out.print(s + " ");
		}
		System.out.println();
		//2. iterator
		it = set.iterator(); 
		while (it.hasNext()) {
			String str = (String)it.next();
			System.out.print(str + " ");
		}
		System.out.println();
		
		//Collections
		//1. reverse list
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			numbers.add(i);
		System.out.println(numbers);
		Collections.reverse(numbers);
		System.out.println(numbers);
		//2. shuffle
		Collections.shuffle(numbers);
		System.out.println(numbers);
		//3. sort
		Collections.sort(numbers);
		System.out.println(numbers);
		//4. Swap
		Collections.swap(numbers, 5, 3);
		System.out.println(numbers);
//		Collections.swap(numbers, 10, 3);// Index out of range exception
		//5. Rotate
		Collections.rotate(numbers, 2);//Right rotate 2 positions
		System.out.println(numbers);
		//6. synchronizedList
		List<Integer> synchronizedNumber = (List<Integer>)Collections.synchronizedList(numbers);
		
		//Difference between arraylist and linkedlist
		List<Integer> list = new ArrayList<>();
//		insertFirst(list, "ArrayList");
		list = new LinkedList<>();
//		insertFirst(list, "LinkedList");
//		modify(list, "LinkedList");
		list = new ArrayList<>();
//		modify(list, "ArrayList");
//		insertMiddle(list, "ArrayList");
		list = new LinkedList<>();
//		insertMiddle(list, "LinkedList");
		
		//HashMap Hashtable
		
		Map<String, String> map = new HashMap<>();
		map.put(null, "value");
		map.put("key", null);//Both key and value can be null;
		map = new Hashtable<>();//Thread safe
//		map.put(null, "value");//Key and value cannot be null
//		map.put("key", null);
		
		HashSet<Integer> hset = new HashSet<>();//Random Order
		hset.add(88);
		hset.add(888);
		hset.add(8);
		System.out.println(hset);
		Set<Integer> tset = new TreeSet<>();// Ascending Order
		tset.add(88);
		tset.add(888);
		tset.add(8);
		System.out.println(tset);
		Set<Integer> lhset = new LinkedHashSet<>(); //Insert order
		lhset.add(88);
		lhset.add(888);
		lhset.add(8);
		System.out.println(lhset);
		
		//HashCode
		
		System.out.println(hashcode("EE96"));
		
		heros = new ArrayList<Hero>();
		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero " + i, (int)(Math.random() * 100)));
		}
		
		System.out.println(heros);
		//Use comparator compare
//		Collections.sort(heros, new Comparator<Hero>() {
//
//			@Override
//			public int compare(Hero arg0, Hero arg1) {
//				// TODO Auto-generated method stub
//				return (int)(arg1.getHp() - arg0.getHp());
//			}
//			
//		});
		Collections.sort(heros, (h, h2)->(int)(((Hero) h2).getHp() - ((Hero) h).getHp()));
		System.out.println(heros);
		
		Collections.sort(heros);
		System.out.println(heros);
		comparableTest();
//		selfTreeset();
//		printPi();
//		reverseKeyAndValue();
//		generateRandomNumber(50);
//		detectDuplicate();
//		findHero();
//		sortComparison();
//		treeHeroSort();
//		stackTest();
//		deleteArrayList();
//		myStringBuffer();
	}
	public static void insertFirst(List<Integer> list, String type) {
		int total = (int)1e5;
		final int num = 10;
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			list.add(0, num);
		}
		System.out.println(type + " costs " + (System.currentTimeMillis() - start) + " milliseconds");
	}
	
	public static void modify(List<Integer> list, String type) {
		int total = (int)1e5;
		int pos = 1000;
		for (int i = 0; i < total; i++) {
			list.add(i);
		}
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			int n = list.get(pos);
			n++;
			list.set(pos, n);
		}
		System.out.println(type + " costs " + (System.currentTimeMillis() - start) + " milliseconds");
		
	}
	
	
	//Practice
	public static void comparableTest() {
		List list = new ArrayList();
		for (int i = 0; i < 10; i++) {
			list.add(new LifePotion("potion", (int)(Math.random() * 100)));
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
	
	
	public static void selfTreeset() {
//		Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer arg0, Integer arg1) {
//				// TODO Auto-generated method stub
//				return arg1 - arg0;
//			}
//			
//		});
//		Set<Integer>set = new TreeSet<>((i0, i1) -> i0 - i1);
		Set<Integer>set = new TreeSet<>(CollectionFrameWork::compare);
		set = new TreeSet<>((i0, i1) -> CollectionFrameWork.compare(i0, i1));
		CollectionFrameWork cf = new CollectionFrameWork();
		set = new TreeSet<>((i0, i1) -> cf.compare1(i0, i1));
		set = new TreeSet<>(cf::compare1);
		for (int i = 0 ; i < 10; i++) {
			set.add((int)(Math.random() * 1000));
		}
		
		System.out.println(set);
	}
	
	public int compare1(Integer i1, Integer i2) {
		return i1 - i2;
	}
	
	public static int compare(Integer i1, Integer i2) {
		return i1 - i2;
	}
	
	public static int hashcode(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int hashcode = 0;
		for (Character c : str.toCharArray())
			hashcode += c;
		hashcode = hashcode * 23 % 2000;
		return hashcode;
	}
	
	
	public static void printPi() {
		String pi = String.valueOf(Math.PI);
		Set<Character> set = new LinkedHashSet<>();
		for (Character c : pi.toCharArray()) {
			if (Character.isDigit(c))
				set.add(c);
		}
		System.out.println(set);
	}
	
	
	public static void reverseKeyAndValue() {
		Map<String, String> map = new Hashtable<>();
		map.put("adc", "Physical Hero");
		map.put("apc", "Magical Hero");
		map.put("t", "tank");
		Map<String, String> temp = new HashMap<>();
		System.out.println(map);
		for (String s : map.keySet()) {
			temp.put(map.get(s), s);
		}
		map.clear();
		map.putAll(temp);
		System.out.println(map);
	}

	public static void insertMiddle(List<Integer> list, String type) {
		int len = (int)1e5;
		int pos = 10;
		long start = System.currentTimeMillis();
		for (int i = 0; i < len; i++) {
			list.add(list.size() / 2, i);
		}
		System.out.println(type + " costs " + (System.currentTimeMillis() - start) + " milliseconds");
		
	}
	
	public static void generateRandomNumber(int n) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int num = (int)(Math.random() * 100000);
			while (set.contains(num)) {
				num = (int)(Math.random() * 100000);
			}
			set.add(num);
		}
		System.out.println(set);
		
	}
	
	public static String generateRandomString(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			char c = (char)(Math.random() * 128);
			while (!(Character.isDigit(c) || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')) {
				c = (char)(Math.random() * 128);
			}
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static void detectDuplicate() {
		String[] strs = new String[100];
		for (int i = 0; i < strs.length; i++) {
			strs[i] = generateRandomString(2);
			System.out.print(strs[i] + " ");
		}
		System.out.println();
		HashSet<String> hs = new HashSet<>();
		for (String str : strs) {
			if (hs.contains(str)) {
				System.out.print(str + " ");
			}
			hs.add(str);
		}
	}
	
	public static void findHero() {
		List<Hero> heros = new ArrayList<>();
		Map<String, List<Hero>> map = new HashMap<>();
		int n = (int)3e6;
		for (int i = 0; i < n; i++) {
			heros.add(new Hero("hero-"+ (int)(Math.random() * 9000 + 1000)));
			String str = heros.get(i).getName();
			if (map.containsKey(str)) {
				map.get(str).add(heros.get(i));
			}else {
				map.put(str, new ArrayList<Hero>());
				map.get(str).add(heros.get(i));
			}
			
		}
		Long start = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			if (heros.get(i).getName().equals("hero-5555")) {
				System.out.print(heros.get(i) + " ");
			}
		}
		System.out.println();
		System.out.println(System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		for (Hero h : map.get("hero-5555")) {
			System.out.print(h + " ");
		}
		System.out.println();
		System.out.println(System.currentTimeMillis() - start);
		
	}
	
	public static void sortComparison() {
		int[] nums = new int[40000];
		Node root = new CollectionFrameWork.Node();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int)(Math.random() * (1000) + 1);
			root.add(nums[i]);
		}
		int[] temp = nums.clone();
		Long start = System.currentTimeMillis();
		selectionSort(temp);
		System.out.println(System.currentTimeMillis() - start);
		System.arraycopy(nums, 0, temp, 0, nums.length);
		start = System.currentTimeMillis();
		bubbleSort(temp);
		System.out.println(System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		root.inorderTraverseIterative();
		System.out.println(System.currentTimeMillis() - start);
		start = System.currentTimeMillis();
		root.inorderTraverseRecursive();
		System.out.println(System.currentTimeMillis() - start);
		
	}
	
	public static void selectionSort(int[] nums) {
		if (nums == null || nums.length == 0)
			return;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					nums[i] ^= nums[j];
					nums[j] ^= nums[i];
					nums[i] ^= nums[j];
				}
			}
		}
	}
	
	public static void bubbleSort(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1)
			return;
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (nums[j] > nums[j + 1]) {
					nums[j] ^= nums[j + 1];
					nums[j + 1] ^= nums[j];
					nums[j] ^= nums[j + 1];
				}
			}
		}
	}
	
	
	private class HeroNode{
		HeroNode left;
		
		HeroNode right;
		
		Hero hero;
		
		public void add(Hero h) {
			if (this.hero == null) {
				this.hero = h;
				return;
			}
			if (this.hero.getHp() < h.getHp()) {
				if (null == this.right) {
					this.right = new HeroNode();
				}
				this.right.add(h);
			}else {
				if (null == this.left) {
					this.left = new HeroNode();
				}
				this.left.add(h);
				
			}
		}
		
		public void inorderTraverse() {
			Stack<HeroNode> stack = new Stack<>();
			HeroNode cur = this;
			while (!stack.isEmpty() || cur != null) {
				while (cur != null) {
					stack.push(cur);
					cur = cur.left;
				}
				System.out.print(stack.peek().hero + " ");
				cur = stack.pop().right;
			}
		}
		
	}
	
	public static void treeHeroSort() {
		HeroNode root = new CollectionFrameWork().new HeroNode();
		for (int i = 0; i < 10; i++) {
			Hero h = new Hero("Hero " + i, (float)(Math.random() * (100 - 10) + 10));
			root.add(h);
			System.out.print(h + " ");
		}
		System.out.println();
		root.inorderTraverse();
		
		
	}
	
	public static void stackTest() {
		MyStack stack = new MyStack();
		System.out.println(stack.peek());
		stack.push(new Hero("hero1"));
		stack.push(new Hero("hero2"));
		stack.push(new Hero("hero3"));
		System.out.println(stack);
		stack.pull();
		System.out.println(stack);
		System.out.println(stack.peek());
	}
	
	public static void myStringBuffer() {
		MyStringBufferWithArrayList msb = new MyStringBufferWithArrayList("Hello ");
		try {
			msb.append("world");
			System.out.println(msb);
			msb.append('y');
			System.out.println(msb);
			msb.insert(3, "good");
			System.out.println(msb);
			msb.insert(4, 'u');
			System.out.println(msb);
			msb.reverse();
			System.out.println(msb);
			msb.delete(0,7);
			System.out.println(msb);
			msb.delete(4);
			System.out.println(msb);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IndexNegativeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IndexOutOfRangeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteArrayList() {
		List<Hero> heros = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			heros.add(new Hero("Hero " + i));
		}
		for (int i = 99; i >= 0 ;i--) {
			if (i % 8 == 0)
				heros.remove(i);
		}
		for (Hero h : heros) {
			System.out.println(h);
		}
	}
}
