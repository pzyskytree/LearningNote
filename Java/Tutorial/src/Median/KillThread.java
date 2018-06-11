package Median;

import Basic.Hero;

public class KillThread extends Thread {
	Hero h1;
	Hero h2;
	
	public KillThread(Hero h1, Hero h2) {
		this.h1 = h1;
		this.h2 = h2;
	}
	
	public void run() {
		while (!h2.isDead())
			h1.attackHero(h2);
	}
}
