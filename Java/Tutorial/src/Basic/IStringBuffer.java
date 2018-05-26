package Basic;

import Median.IndexNegativeException;
import Median.IndexOutOfRangeException;

public interface IStringBuffer {

	public void append(String str) 
			throws IndexNegativeException, IndexOutOfRangeException,NullPointerException;
	
	public void append(char c)
			throws IndexNegativeException, IndexOutOfRangeException,NullPointerException;
	
	public void insert(int pos, char b)
			throws IndexNegativeException, IndexOutOfRangeException,NullPointerException;
	
	public void insert(int post, String b)
			throws IndexNegativeException, IndexOutOfRangeException,NullPointerException;
	
	public void delete(int start) 
			throws IndexOutOfRangeException, IndexNegativeException;
	
	public void delete(int start, int end)
			throws IndexOutOfRangeException, IndexNegativeException;
	
	public void reverse();
	
	public int length();
}
