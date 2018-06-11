package Median;

import java.util.List;

public class LogThread extends Thread{
	List<String> passwords;
	
	public LogThread(List<String> passwords) {
		this.passwords = passwords;
		this.setDaemon(true);
	}
	
	public void run() {
		while (true) {
			if (passwords.isEmpty()) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				String s = passwords.remove(0);
				System.out.println(s);
			}
		}
	}
}
