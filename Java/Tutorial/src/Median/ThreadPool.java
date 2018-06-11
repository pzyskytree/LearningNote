package Median;

import java.util.LinkedList;

public class ThreadPool {
	
	private int threadPoolSize;
	LinkedList<Runnable> tasks = new LinkedList<Runnable>();
	
	public ThreadPool(int size) {
		this.threadPoolSize = size;
		for (int i = 0; i < this.threadPoolSize; i++) {
			new ConsumerThread("Consumer Tread " + i).start();
		}
	}
	
	public void add(Runnable task) {
		synchronized(tasks) {
			tasks.add(task);
			tasks.notifyAll();
		}
	}

	class ConsumerThread extends Thread{
		public ConsumerThread(String name) {
			super(name);
		}
		Runnable task;
		public void run() {
//			System.out.println("Start Thread: " + this.getName());
			while(true) {
				synchronized(tasks) {
					while (tasks.isEmpty()) {
						try {
							tasks.wait();
						}catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
					task = tasks.removeLast();
					tasks.notifyAll();
				}
//				System.out.println(this.getName() + " get the task and complete it");
				task.run();
			}
		}
	}

}
