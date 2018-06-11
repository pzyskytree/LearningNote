package Median;

import java.util.LinkedList;
import java.util.List;

public class MyHashMap implements IHashMap{

	private final int size = 2000;
	
	private List<Entry>[] array = new LinkedList[size];

	@Override
	public void put(String key, Object value) {
		// TODO Auto-generated method stub
		int code = hashcode(key);
		if (array[code] == null) {
			array[code] = new LinkedList<>();
		}
		boolean exist = false;
		for (Entry e : array[code]) {
			if (key.equals(e.key)) {
				e.value = value;
				exist = true;
				break;
			}
		}
		if (!exist)
			array[code].add(new Entry(key, value));
	}

	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		int code = hashcode(key);
		if (array[code] == null)
			return null;
		for (Entry e : array[code]) {
			if (e.key.equals(key))
				return e.value;
		}
		return null;
	}
	
	public int hashcode(String str) {
		if (null == str || str.length() == 0)
			return 0;
		int hashcode = 0;
		for (Character c : str.toCharArray())
			hashcode += c;
		hashcode = hashcode * 23 % 2000;
		return hashcode;
	}
	
	public String toString() {
		List<Entry> result = new LinkedList<>();
		for (List list : array) {
			if (list == null)
				continue;
			else
				result.addAll(list);
		}
		return result.toString();
	}
}
