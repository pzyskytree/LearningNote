package Median;

import java.util.List;

public interface DAO {

	public int getTotal();
	
	public void add(Hero h);
	
	public void delete(Hero h);
	
	public void update(Hero h);
	
	public Hero get(int id);
	
	public List<Hero> list();
	
	public List<Hero> list(int start, int count);
}
