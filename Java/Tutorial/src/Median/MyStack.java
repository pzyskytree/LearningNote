package Median;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyStack<T> implements Stack<T>{

	private List<T> stack;
	
	private Lock lock;
	
	private Condition condition;
	
	public MyStack() {
		stack = Collections.synchronizedList(new LinkedList<>());
		lock = new ReentrantLock();
		condition = lock.newCondition();
	}
	
	
	@Override
	public void push(T h){
		// TODO Auto-generated method stub
		synchronized(this) {
			while (stack.size() >= 200) {
				try {
					this.wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.notifyAll();
			stack.add(h);	
		}
		//Use lock
//		try {
//			lock.lock();
//			while (stack.size() >= 200)
//				condition.await();
//			stack.add(h);
//			condition.signalAll();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			lock.unlock();
//		}
	}

	@Override
	public synchronized T pull() {
		// TODO Auto-generated method stub
		if (stack.size() == 0)
			return null;
		while (stack.size() == 0) {
			try {
				this.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notifyAll();
		return stack.remove(stack.size() - 1);
		//Use Lock
//		T element = null;
//		try {
//			lock.lock();
//			while (stack.size() == 0)
//				condition.await();
//			element = stack.remove(stack.size() - 1);
//			condition.signalAll();
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}finally {
//			lock.unlock();
//			return element;
//		}
//		
		
	}

	//peek method does not change the data
	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if (stack.size() == 0)
			return null;
		return stack.get(stack.size() - 1);
	}

	public String toString() {
		return stack.toString();
	}
}
