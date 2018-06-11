package Median;

public class Entry {

	public Object key;
	
	public Object value;
	
	public Entry(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	public String toString() {
		return "[key=" + key + ", value=" + this.value + "]";
	}
}
