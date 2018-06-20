package Median;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThread {

	public static void main(String[] args) {
//		Hero garen = new Hero("Garen", 616, 50);
//		Hero teemo = new Hero("Teemo", 300, 30);
//		Hero hunter = new Hero("Hunter", 500, 65);
//		Hero leesin = new Hero("Leesin", 455, 80);
		
//		while (!teemo.isDead()) {
//			garen.attackHero(teemo);
//		}
//		
//		while (!leesin.isDead()) {
//			hunter.attackHero(leesin);
//		}
		//1. Inherited from thread
//		KillThread kt1 = new KillThread(garen, teemo);
//		kt1.start();
//		KillThread kt2 = new KillThread(hunter, leesin);
//		kt2.start();
		
		//2. Implement Runnable Interface
//		Battle b1 = new Battle(garen, teemo);
//		new Thread(b1).start();
//		Battle b2 = new Battle(hunter, leesin);
//		new Thread(b2).start();
		
		//3. Anonymous Class
//		Thread t1 = new Thread() {
//			public void run() {
//				while (!teemo.isDead()) {
//					garen.attackHero(teemo);
//				}
//			}
//		};
//		t1.start();
//		Thread t2 = new Thread() {
//			public void run() {
//				while (!leesin.isDead()) {
//					hunter.attackHero(leesin);
//				}
//			}
//		};
//		t2.start();
		
		
		//Common Thread Method
		// .sleep() Suspend the current Thread not effect other threads.
//		Thread t1 = new Thread() {
//			int second = 0;
//			public void run() {
//				while (true) {
//					try {
//						Thread.sleep(1000);
//					}catch(InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println("Having played the LOL for " + (second++) + " seconds");
//				}
//			}
//		};
//		t1.start();
//		System.out.println("123");
		// .join() main thread wait for other thread ending
//		Thread t1 = new Thread() {
//			public void run() {
//				while (!teemo.isDead()) {
//					garen.attackHero(teemo);
//				}
//			}
//		};
//		t1.start();
//		try {
//			t1.join();
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		Thread t2 = new Thread() {
//			public void run() {
//				while (!leesin.isDead()) {
//					hunter.attackHero(leesin);
//				}
//			}
//		};
//		t2.start();

		//.setPriority() Thread Thread priority
//		Hero garen = new Hero("Garen", 616, 1);
//		Hero teemo = new Hero("Teemo", 300, 1);
//		Hero hunter = new Hero("Hunter", 500, 1);
//		Hero leesin = new Hero("Leesin", 455, 1);
//		Thread t1 = new Thread() {
//			public void run() {
//				while (!teemo.isDead()) {
//					garen.attackHero(teemo);
//				}
//			}
//		};
//		Thread t2 = new Thread() {
//			public void run() {
//				while (!leesin.isDead()) {
//					hunter.attackHero(leesin);
//				}
//			}
//		};
//		t1.setPriority(Thread.MAX_PRIORITY);
//		t2.setPriority(Thread.MIN_PRIORITY);
//		t1.start();
//		t2.start();
		
		//.yield() Suspend the thread
//		Hero garen = new Hero("Garen", 616, 1);
//		Hero teemo = new Hero("Teemo", 300, 1);
//		Hero hunter = new Hero("Hunter", 500, 1);
//		Hero leesin = new Hero("Leesin", 455, 1);
//		Thread t1 = new Thread() {
//			public void run() {
//				while (!teemo.isDead()) {
//					garen.attackHero(teemo);
//				}
//			}
//		};
//		Thread t2 = new Thread() {
//			public void run() {
//				while (!leesin.isDead()) {
//					Thread.yield();
//					hunter.attackHero(leesin);
//				}
//			}
//		};
//		t1.setPriority(5);
//		t2.setPriority(5);
//		t1.start();
//		t2.start();
		
		//Daemon Thread: setDaemon()
//		Thread t1 = new Thread() {
//			int second = 0;
//			public void run() {
//				while (true) {
//					try {
//						Thread.sleep(1000);
//					}catch(InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println("Having played LOL for " + (second++) + " seconds");
//				}
//			}
//		};
//		t1.setDaemon(true);
//		t1.start();
//		Hero h = new Hero();
//		h.adugen();
		
		//Synchronized Concurrency
		//sychronized: lock the object and other thread cannot visit it simultaneous.
//		int n = 10000;
//		Hero garen = new Hero("Garen", 10000);
//		System.out.println(garen.hp);
//		Thread[] hurtThread = new Thread[n];
//		Thread[] recoverThread = new Thread[n];
//		for (int i = 0; i < n; i++) {
//			hurtThread[i] = new Thread() {
//				public void run() {
//					garen.hurt();
//					try {
//						Thread.sleep(1);
//					}catch(InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			};
//			hurtThread[i].start();
//		}
//		for (int i = 0; i < n; i++) {
//			recoverThread[i] = new Thread() {
//				public void run() {
//					garen.recover();
//					try {
//						Thread.sleep(1);
//					}catch(InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			};
//			recoverThread[i].start();
//			
//		}
//		for (Thread t : hurtThread) {
//			try {
//				t.join();
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		for (Thread t : recoverThread) {
//			try {
//				t.join();
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println(garen.hp);
		
		
//		Object someObject = new Object();
//		Thread t1 = new Thread() {
//			public void run() {
//				System.out.println(now() + " " + this.getName() + " try to occupy the object");
//				synchronized(someObject){
//					try {
//						System.out.println(now() + " " + this.getName() + " occupied the object");
//						Thread.sleep(5000);
//						System.out.println(now() + " " + this.getName() + " release the object");
//					}catch(InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//				System.out.println(this.getName() + " ended");
//			}
//		};
//		t1.setName("Thread 1");
//		Thread t2 = new Thread() {
//			public void run() {
//				System.out.println(now() + " " + this.getName() + " try to occupy the object");
//				synchronized(someObject){
//					try {
//						System.out.println(now() + " " + this.getName() + " occupied the object");
//						Thread.sleep(5000);
//						System.out.println(now() + " " + this.getName() + " release the object");
//					}catch(InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//				System.out.println(this.getName() + " ended");
//			}
//		};
//		t2.setName("Thread 2");
////		t2.setPriority(Thread.MAX_PRIORITY);
//		t1.start();
//		try {
//			Thread.sleep(2000);
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		t2.start();
		
//		int n = 100;
//		Hero garen = new Hero("Garen", 100);
//		System.out.println(garen.hp);
//		Thread[] hurtThread = new Thread[n];
//		Thread[] recoverThread = new Thread[n];
//		for (int i = 0; i < n; i++) {
//			hurtThread[i] = new Thread() {
//				public void run() {
////					synchronized(garen) {
////						garen.hurt();
////					}
//					garen.hurt();
//					try {
//						Thread.sleep(1);
//					}catch(InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			};
//			hurtThread[i].start();
//		}
//		for (int i = 0; i < n; i++) {
//			recoverThread[i] = new Thread() {
//				public void run() {
////					synchronized(garen) {
////						garen.recover();
////					}
//					
//					garen.recover();//Use synchronized(this)
//					try {
//						Thread.sleep(1);
//					}catch(InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			};
//			recoverThread[i].start();
//			
//		}
//		for (Thread t : hurtThread) {
//			try {
//				t.join();
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		for (Thread t : recoverThread) {
//			try {
//				t.join();
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println(garen.hp);
		
		//Synchronized Class with all the object methods having synchronized decoration.
		// like StringBuffer
		
		//Thread safe Class
		//1. HashMap vs Hashtable
		// 1. The key and value of HashMap can be null but Hashtable cannot.
		// 2. Hashtable is thread safe class HashMap is not
		
		//2. StringBuilder vs StringBuffer
		//1. StringBuffer is thread safe class
		
		//3. ArrayList vs Vector
		// Vector is thread safe class
		//Collections.synchronizedList()
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = Collections.synchronizedList(list);
		
		//Dead Lock
//		Hero teemo = new Hero("teemo");
//		Thread t1 = new Thread() {
//			public void run() {
//				synchronized (teemo) {
//					System.out.println("t1 occupied teemo");
//					try {
//						Thread.sleep(5000);
//					}catch(InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println("t1 try to occupy garen");
//					System.out.println("t1 is waiting for garen");
//					synchronized(garen) {
//						System.out.println("t1 occupied garen");
//					}
//				}	
//			}
//		};
//		t1.start();
//		Thread t2 = new Thread() {
//			public void run() {
//				synchronized (garen) {
//					System.out.println("t2 occupied garen");
//					try {
//						Thread.sleep(5000);
//					}catch(InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println("t2 try to occupy teemo");
//					System.out.println("t2 is waiting for teemo");
//					synchronized(teemo) {
//						System.out.println("t2 occupied teemo");
//					}
//				}	
//			}
//		};
//		t2.start();
		
		//Interaction between threads
		//1 Use while loop
//		Hero teemo = new Hero("teemo", 100);
//		Thread[] hurtThread = new Thread[12];//Cause the blood to be negative change if to while to keep checking the blood
//		for (int i = 0; i < hurtThread.length; i++) {
//			hurtThread[i] = new Thread() {
//				public void run() {
//					while (true) {
//	//					while (teemo.hp == 1)
//	//						continue;
//						teemo.hurt();
//						System.out.println("Hurt Tread hurts teemo, teemo's blood " + teemo.hp);
//						try {
//							Thread.sleep(100);
//						}catch(InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			};
//			hurtThread[i].start();
//		}
//		Thread[] recoverThread = new Thread[2];
//		for (int i = 0; i < recoverThread.length; i++) {
//			recoverThread[i] = new Thread() {
//				public void run() {
//					while (true) {
//						teemo.recover();
//						System.out.println("Recover Tread recovers teemo, teemo's blood " + teemo.hp);
//						try {
//							Thread.sleep(10);
//						}catch(InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//				}
//			};
//			recoverThread[i].start();
//		}
		
		//wait and notify method from Object
		//this.wait(); //Must inside synchronized block. Force the thread hold this to release resource
 		//this.notify(); 
		//this.notifyAll();
		
		//Thread Pool
		//Similar to producer and consumer model
		//Reuse all the existing threads
//		ThreadPool tPool = new ThreadPool(10);
//		int sleep = 1000;
//		while(true) {
//			tPool.add(new Runnable() {
//
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					try {
//						Thread.sleep(3000);
//					}catch(InterruptedException e){
//						e.printStackTrace();
//					}
//					System.out.println("Task");
//				}
//				
//			});
//			try {
//				Thread.sleep(sleep);
//				sleep = sleep > 100 ? sleep - 100 : sleep;
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
//		}
		
//		//Java Thread Pool
//		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60l, TimeUnit.SECONDS, 
//				new LinkedBlockingQueue<Runnable>());
//		threadPool.execute(new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("Mission");
//			}
//			
//		});
		
		//Use Lock Interface
		Lock lock = new ReentrantLock();
		//lock() lock some object and other thread cannot use
		// must use unlock to release while at the end the synchronized block the thread will release the 
		//resource
//		Thread t1 = new Thread() {
//			public void run() {
//				boolean locked = false;
//				try {
//					log("start thread");
//					log("try to occupy the resource");
////					lock.lock();
//					locked = lock.tryLock(1, TimeUnit.SECONDS);//Try to lock
//					if (locked) {
//						log("hold the lock");
//						log("work for five second");
//						Thread.sleep(5000);
//					}
//					
//				}catch(InterruptedException e) {
//					e.printStackTrace();
//				}finally {
//					if (locked) {
//						log("Release Lock");
//						lock.unlock();
//					}
//				}
//				log("Thread ends");
//			}
//		};
//		t1.start();
//		try {
//			Thread.sleep(2000);
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		Thread t2 = new Thread() {
//			public void run() {
//				boolean locked = false;
//				try {
//					log("start thread");
//					log("try to occupy the resource");
////					lock.lock();
//					locked = lock.tryLock(1, TimeUnit.SECONDS);
//					if (locked) {
//						log("hold the lock");
//						log("work for five second");
//						Thread.sleep(5000);
//					}
//				}catch(InterruptedException e) {
//					e.printStackTrace();
//				}finally {
//					if (locked) {
//						log("Release Lock");
//						lock.unlock();
//					}	
//				}
//				log("Thread ends");
//			}
//		};
//		t2.start();
		
		//Interaction
		//Condition: use condition .await() signal signalAll
//		Lock lock1 = new ReentrantLock();
//		Condition condition = lock1.newCondition();
//		Thread t3 = new Thread() {
//			public void run() {
//				try {
//					log("start thread");
//					log("try to occupy the resource");
//					lock1.lock();
//					log("hold the lock");
//					log("work for five seconds");
//					Thread.sleep(5000);
//					log("Release the lock temporarily");
//					condition.await();
//					log("Regain the lock and work for five seconds");
//					Thread.sleep(5000);
//					
//					
//				}catch(InterruptedException e) {
//					e.printStackTrace();
//				}finally {
//					log("Release Lock");
//					lock1.unlock();
//					
//				}
//				log("Thread ends");
//			}
//		};
//		t3.start();
//		try {
//			Thread.sleep(2000);
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		Thread t4 = new Thread() {
//			public void run() {
//				try {
//					log("start thread");
//					log("try to occupy the resource");
//					lock1.lock();
//					log("hold the lock");
//					log("work for five second");
//					Thread.sleep(5000);
//					log("Awaken the thread");
//					condition.signal();
//					
//				}catch(InterruptedException e) {
//					e.printStackTrace();
//				}finally {
//					log("Release Lock");
//					lock1.unlock();	
//				}
//				log("Thread ends");
//			}
//		};
//		t4.start();
		
		//Difference between lock and synchronized
		//1. Lock is interface while synchronized is key word
		//2. Lock can choose to obtain the lock or not, which can avoid dead lock
		//3. Lock must be released by hand
		
		//Atom Operation thread safe int i = 1;
		// i++ three atom opertions 
		AtomicInteger atomicI = new AtomicInteger();
		int a = atomicI.decrementAndGet();
		System.out.println(a);
		int b = atomicI.incrementAndGet();
		System.out.println(b);
		int c = atomicI.addAndGet(3);
		System.out.println(c);
		
		
		Thread[] threads = new Thread[10000];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					value++;
				}
			}); 
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			}catch(InterruptedException e) {	
				e.printStackTrace();
			}
		}
		System.out.println(value);
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					atomicValue.incrementAndGet();
				}
			}); 
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			}catch(InterruptedException e) {	
				e.printStackTrace();
			}
		}
		System.out.println(atomicValue);
		
		
//		producerAndConsumer();
//		decodeCipher();
//		tripleDeadLock();
//		solveTripleDeadLock();
	}
	
	private static int value = 0;
	private static AtomicInteger atomicValue = new AtomicInteger(0);
	
	public static String now() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
	
	public static void log(String msg) {
		System.out.printf("%s %s %s %n", now(), Thread.currentThread().getName(), msg);
	}
	//Practice 
	
	public static void producerAndConsumer() {
		ProducerThread[] producers = new ProducerThread[2];
		ConsumerThread[] consumers = new ConsumerThread[3];
		MyStack<Character> stack = new MyStack<>();
		for (int i = 0; i < producers.length; i++) {
			producers[i] = new ProducerThread("producer " + i, stack);
			producers[i].start();
		}
		for (int i = 0; i < consumers.length; i++) {
			consumers[i] = new ConsumerThread("consumer " + i, stack);
			consumers[i].start();
		}
	}
	
	public static void solveTripleDeadLock() {
		Object a = new Object(), b = new Object(), c = new Object();
		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();
		Lock lock3 = new ReentrantLock();
		Thread t1 = new Thread() {
			boolean locked1 = false;
			boolean locked2 = false;
 			public void run() {
				try {
					locked1 = lock1.tryLock(2, TimeUnit.SECONDS);
					if (locked1) {
						System.out.println("t1 occupied a");
						Thread.sleep(1000);
						System.out.println("t1 try to occupy b");
						System.out.println("t1 is waiting for b");
						locked2 = lock2.tryLock(2, TimeUnit.SECONDS);
						if (locked2) {
							System.out.println("t1 occupied b");
						}
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}finally {
					if (locked2) {
						System.out.println("t1 Release the lock for b");
						lock2.unlock();
					}
					if (locked1) {
						System.out.println("t1 Release the lock for a");
						lock1.unlock();
					}
				}
			}
		};
		t1.start();
		Thread t2 = new Thread() {
			boolean locked2 = false;
			boolean locked3 = false;
 			public void run() {
				try {
					locked2 = lock2.tryLock(2, TimeUnit.SECONDS);
					if (locked2) {
						System.out.println("t2 occupied b");
						Thread.sleep(1000);
						System.out.println("t2 try to occupy c");
						System.out.println("t2 is waiting for c");
						locked3 = lock3.tryLock(2, TimeUnit.SECONDS);
						if (locked3) {
							System.out.println("t2 occupied c");
						}
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}finally {
					if (locked3) {
						System.out.println("t2 Release the lock for c");
						lock3.unlock();
					}
					if (locked2) {
						System.out.println("t2 Release the lock for b");
						lock2.unlock();
					}
				}
			}
		};
		t2.start();
		Thread t3 = new Thread() {
			boolean locked1 = false;
			boolean locked3 = false;
 			public void run() {
				try {
					locked3 = lock3.tryLock(2, TimeUnit.SECONDS);
					if (locked3) {
						System.out.println("t3 occupied c");
						Thread.sleep(1000);
						System.out.println("t3 try to occupy a");
						System.out.println("t3 is waiting for a");
						locked1 = lock1.tryLock(2, TimeUnit.SECONDS);
						if (locked1) {
							System.out.println("t3 occupied a");
						}
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}finally {
					if (locked1) {
						System.out.println("t3 Release the lock for a");
						lock1.unlock();
					}
					if (locked3) {
						System.out.println("t3 Release the lock for c");
						lock3.unlock();
					}
				}
			}
		};
		t3.start();
		
	}
	
	public static void tripleDeadLock() {
		Object a = new Object(), b = new Object(), c = new Object();
		Thread t1 = new Thread() {
			public void run() {
				synchronized(a) {
					System.out.println("t1 occupied a");
					try {
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t1 try to occupy b");
					System.out.println("t1 is waiting for b");
					synchronized(b) {
						System.out.println("t1 occupied b");
					}
				}
			}
		};
		t1.start();
		Thread t2 = new Thread() {
			public void run() {
				synchronized(b) {
					System.out.println("t2 occupied b");
					try {
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t2 try to occupy c");
					System.out.println("t2 is waiting for c");
					synchronized(c) {
						System.out.println("t2 occupied c");
					}
				}
			}
		};
		t2.start();
		Thread t3 = new Thread() {
			public void run() {
				synchronized(c) {
					System.out.println("t3 occupied c");
					try {
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t3 try to occupy a");
					System.out.println("t3 is waiting for a");
					synchronized(a) {
						System.out.println("t3 occupied a");
					}
				}
			}
		};
		t3.start();
		
	}
	
	public static String generateCipher(int n) {
		char[] cipher = new char[n];
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
		    cipher[i] = (char)rand.nextInt(128);
		    while (!(Character.isLetterOrDigit(cipher[i]))) {
			    cipher[i] = (char)rand.nextInt(128);
		    }
		}
		return String.valueOf(cipher);
	}

	public static void decodeCipher() {
		String target = generateCipher(3);
		List<String> list = new LinkedList<>();
		System.out.println("target " + target);
		new PasswordThread(target, list).start();
		new LogThread(list).start();
	}
}