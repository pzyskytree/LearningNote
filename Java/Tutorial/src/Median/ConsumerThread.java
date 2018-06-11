package Median;

public class ConsumerThread extends Thread {
	private MyStack<Character> stack;
	
	public ConsumerThread (String name, MyStack<Character> stack) {
		this.setName(name);
		this.stack = stack;
	}
	
	public void run() {
		while (true) {
			char c = stack.pull();
			System.out.println(this.getName() + " pulls " + c + " from stack");
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
