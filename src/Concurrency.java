import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Concurrency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter counter = new Counter();
		//Counter counter = new Counter(); // the shared object
		IncrementerThread it1 = new IncrementerThread(counter);
		IncrementerThread it2 = new IncrementerThread(counter);
		it1.start(); // thread 1 increments the count by 10000
		it2.start(); // thread 2 increments the count by 10000
		try {
			it1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // wait for thread 1 to finish
		try {
			it2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // wait for thread 2 to finish
		System.out.println(counter.getValue());
		

		Callable<Integer> c = new MyCallable();
		ExecutorService ex = Executors.newCachedThreadPool();
		Future<Integer> f = ex.submit(c); // finishes in the future
		try {
			Integer v = f.get(); // blocks until done
			System.out.println("Ran:" + v);
		} catch (InterruptedException | ExecutionException iex) {
			System.out.println("Failed");
		}
		
		//Recursive action, ForkJoin
		int[] data = new int[10_000_000];
		ForkJoinPool fjPool = new ForkJoinPool();
		RandomInitRecursiveAction action = new RandomInitRecursiveAction(data, 0, data.length);
		fjPool.invoke(action);

		//Recursive Action
//		int[] data1 = new int[10_000_000];
//		ForkJoinPool fjPool2 = new ForkJoinPool();
		RandomInitRecursiveAction action2 = new RandomInitRecursiveAction(data, 0, data.length);
		fjPool.invoke(action2);
		FindMaxPositionRecursiveTask task = new FindMaxPositionRecursiveTask(data, 0, data.length);
		Integer position = fjPool.invoke(task);
		System.out.println("Position: " + position + ", value: " + data[position]);

	}
}





class Counter {
	private AtomicInteger count = new AtomicInteger();

	public void increment() {
		count.getAndIncrement(); // atomic operation
	}

	public int getValue() {
		return count.intValue();
	}
}


class IncrementerThread extends Thread {
	private Counter counter;

	// all instances are passed the same counter
	public IncrementerThread(Counter counter) {
		this.counter = counter;
	}

	public void run() {
		// "i" is local and thread-safe
		for (int i = 0; i < 10000; i++) {
			counter.increment();
			}
		}
	}

class MaxValueCollection {
	private List<Integer> integers = new ArrayList<>();
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	public void add(Integer i) {
		rwl.writeLock().lock(); // one at a time
		try {
			integers.add(i);
		} finally {
			rwl.writeLock().unlock();
		}
	}

	public int findMax() {
		rwl.readLock().lock(); // many at once
		try {
			return Collections.max(integers);
		} finally {
			rwl.readLock().unlock();
		}
	}
}

class MyCallable implements Callable<Integer> {
	@Override
	public Integer call() {
		// Obtain a random number from 1 to 10
		int count = ThreadLocalRandom.current().nextInt(1, 11);
		for (int i = 1; i <= count; i++) {
			System.out.println("Running..." + i);
		}
		return count;
	}
}

class RandomInitRecursiveAction extends RecursiveAction {
	private static final int THRESHOLD = 10000;
	private int[] data;
	private int start;
	private int end;

	public RandomInitRecursiveAction(int[] data, int start, int end) {
		this.data = data;
		this.start = start; // where does our section begin at?
		this.end = end; // how large is this section?
	}

	@Override
	protected void compute() {
		if (end - start <= THRESHOLD) { // is it a manageable amount of work?
			// do the task
			for (int i = start; i < end; i++) {
				data[i] = ThreadLocalRandom.current().nextInt();
			}
		} else { // task too big, split it
			int halfWay = ((end - start) / 2) + start;
			RandomInitRecursiveAction a1 = new RandomInitRecursiveAction(data, start, halfWay);
			a1.fork(); // queue left half of task
			RandomInitRecursiveAction a2 = new RandomInitRecursiveAction(data, halfWay, end);
			a2.compute(); // work on right half of task
			a1.join(); // wait for queued task to be complete
		}
	}
}

class FindMaxPositionRecursiveTask extends RecursiveTask<Integer> {
	private static final int THRESHOLD = 10000;
	private int[] data;
	private int start;
	private int end;

	public FindMaxPositionRecursiveTask(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() { // return type matches the <generic> type
		if (end - start <= THRESHOLD) { // is it a manageable amount of work?
			int position = 0; // if all values are equal, return position 0
			for (int i = start; i < end; i++) {
				if (data[i] > data[position]) {
					position = i;
				}
			}
			return position;
		} else { // task too big, split it
			int halfWay = ((end - start) / 2) + start;
			FindMaxPositionRecursiveTask t1 = new FindMaxPositionRecursiveTask(data, start, halfWay);
			t1.fork(); // queue left half of task
			FindMaxPositionRecursiveTask t2 = new FindMaxPositionRecursiveTask(data, halfWay, end);
			int position2 = t2.compute(); // work on right half of task
			int position1 = t1.join(); // wait for queued task to be complete
			// out of the position in two subsection which is greater?
			if (data[position1] > data[position2]) {
				return position1;
			} else if (data[position1] < data[position2]) {
				return position2;
			} else {
				return position1 < position2 ? position1 : position2;
			}
		}
	}
}