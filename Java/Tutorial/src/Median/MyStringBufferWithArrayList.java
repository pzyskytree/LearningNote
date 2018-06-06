package Median;

import java.util.ArrayList;
import java.util.Arrays;

import Basic.IStringBuffer;

public class MyStringBufferWithArrayList implements IStringBuffer {

	private ArrayList letters = new ArrayList();
	
	MyStringBufferWithArrayList(){
		letters = new ArrayList();
	}
	
	MyStringBufferWithArrayList(String s){
		this();
		if (null == s)
			return;
		for (Character c : s.toCharArray()) {
			letters.add(c);
		}
	}
	
	@Override
	public void append(String str) throws IndexNegativeException, IndexOutOfRangeException, NullPointerException {
		// TODO Auto-generated method stub
		this.insert(letters.size(), str);
	}

	@Override
	public void append(char c) throws IndexNegativeException, IndexOutOfRangeException, NullPointerException {
		// TODO Auto-generated method stub
		this.insert(letters.size(), c);
	}

	@Override
	public void insert(int pos, char b) throws IndexNegativeException, IndexOutOfRangeException, NullPointerException {
		// TODO Auto-generated method stub
		this.insert(pos, String.valueOf(b));
		
	}

	@Override
	public void insert(int post, String b)
			throws IndexNegativeException, IndexOutOfRangeException, NullPointerException {
		// TODO Auto-generated method stub
		if (post < 0)
			throw new IndexNegativeException();
		if (post > letters.size())
			throw new IndexOutOfRangeException();
		if (b == null)
			throw new NullPointerException();
		ArrayList temp = new ArrayList();
		for (Character c : b.toCharArray()) {
			temp.add(c);
		}
		letters.addAll(post, temp);
		
	}

	@Override
	public void delete(int start) throws IndexOutOfRangeException, IndexNegativeException {
		// TODO Auto-generated method stub
		this.delete(start, letters.size());
	}

	@Override
	public void delete(int start, int end) throws IndexOutOfRangeException, IndexNegativeException {
		// TODO Auto-generated method stub
		if (start < 0 || end < 0)
			throw new IndexNegativeException();
		if (start > end || start > this.letters.size()) 
			throw new IndexOutOfRangeException();
		for (int i = start; i < end; i++)
			this.letters.remove(start);
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		ArrayList temp = new ArrayList();
		for (Object c : this.letters) {
			temp.add(0, c);
		}
		this.letters = temp;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return letters.size();
	}
	
	public String toString() {
		Character[] temp = (Character[])letters.toArray(new Character[]{});
		return Arrays.toString(temp).replaceAll(", ", "").substring(1, temp.length + 1);
	}

}
