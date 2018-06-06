package Median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


import Basic.ADHero;
import Basic.Hero;
import Basic.LifePotion;

public class CollectionFrameWork {

	public static class Node{
		
		public Node leftNode;
		
		public Node rightNode;
		
		public Object value;
		
		public void add(Object v) {
			if (null == this.value) {
				this.value = v;
				return;
			}
			if ((Integer)this.value - (Integer)v >= 0) {
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
		//ArrayList
		//Method
		//1. Add
		ArrayList heros = new ArrayList();
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
		
		
		findHero();
		
//		sortComparison();
//		treeHeroSort();
//		stackTest();
//		deleteArrayList();
//		myStringBuffer();
	}
	
	//Practice
	
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
