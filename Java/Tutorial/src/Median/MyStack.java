package Median;

import java.util.Deque;
import java.util.LinkedList;

import Basic.Hero;

public class MyStack implements Stack{

	private Deque<Hero> stack;
	
	public MyStack() {
		stack = new LinkedList<>();
	}
	
	@Override
	public void push(Hero h) {
		// TODO Auto-generated method stub
		stack.addLast(h);
	}

	@Override
	public Hero pull() {
		// TODO Auto-generated method stub
		if (stack.size() == 0)
			return null;
		return stack.removeLast();
	}

	@Override
	public Hero peek() {
		// TODO Auto-generated method stub
		if (stack.size() == 0)
			return null;
		return stack.getLast();
	}

	public String toString() {
		return stack.toString();
	}
}
