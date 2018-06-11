package Median;

public class ProducerThread extends Thread {
	private MyStack<Character> stack;
	
	public ProducerThread(String name, MyStack<Character> stack) {
		this.setName(name);
		this.stack = stack;
	}
	
	public void run() {
		while (true) {
			char c = (char)((int)(Math.random() * 26) +  'A');
			stack.push(c);
			System.out.println(this.getName() + " push " + c + " into stack");
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
