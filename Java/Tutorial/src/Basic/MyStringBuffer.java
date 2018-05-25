package Basic;

import java.util.Arrays;

public class MyStringBuffer implements IStringBuffer {

	private char[] letters;
	private int capacity = 10;
	private int length = 0;
	
	public MyStringBuffer(String str) {
		this.capacity = Math.max(this.capacity, 2 * str.length());
		this.letters = new char[this.capacity];
		this.length = str.length();
	    System.arraycopy(str.toCharArray(), 0, this.letters, 0, this.length);
	}
	
	@Override
	public void append(String str) {
		// TODO Auto-generated method stub
		insert(this.length, str);
	}

	@Override
	public void append(char c) {
		// TODO Auto-generated method stub
		insert(this.length, c);
	}

	@Override
	public void insert(int pos, char b) {
		// TODO Auto-generated method stub
		insert(pos, String.valueOf(b));
	}

	@Override
	public void insert(int post, String b) {
		// TODO Auto-generated method stub
		if (post > this.length || post < 0)
			return;
		if (b == null || b.length() == 0)
			return;
		
		if (b.length() + this.length > capacity) {
			char[] temp = new char[2 * (b.length() + this.length)];
			System.arraycopy(this.letters, 0, temp, 0, this.length);
			capacity = 2 * (b.length() + this.length);
		}
		this.length += b.length();
		System.arraycopy(this.letters, post, this.letters, post + b.length(), this.length - post);
		System.arraycopy(b.toCharArray(), 0, this.letters, post, b.length());
	}

	@Override
	public void delete(int start) {
		// TODO Auto-generated method stub
		this.delete(start, this.length);
	}

	@Override
	public void delete(int start, int end) {
		// TODO Auto-generated method stub
		if (start < 0 || end < 0 || start >= this.length || end > this.length) {
			return;
		}
		if (start > end)
			return;
		System.arraycopy(this.letters, end, this.letters, start, this.length - end);
		this.length -= (end - start);
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.length / 2; i++) {
			char temp = this.letters[this.length - 1 - i];
			this.letters[this.length - 1 - i] = this.letters[i];
			this.letters[i] = temp;
		}
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return this.length;
	}
	
	public String toString() {
		char[] temp = Arrays.copyOfRange(this.letters, 0, this.length);
		return String.valueOf(temp);
	}

}
