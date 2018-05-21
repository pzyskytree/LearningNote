package Basic;

public class GiantDragon {

	//Private constructor
	private GiantDragon() {
		
	}
	
	//Private static class attribute;
//	private static GiantDragon instance = new GiantDragon();//Hungry model load immediately.
	
	private static GiantDragon instance;//Lazy model, load when it is used. For thread security use lazy model.
	
	public static GiantDragon getInstance() {
		if (null == instance)
			instance = new GiantDragon();
		return instance;
	}
}
