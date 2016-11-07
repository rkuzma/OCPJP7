import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Threads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Thread t1 = new Thread(new MyRunnable(), "t1");
        Thread t2 = new Thread(new MyRunnable(), "t2");
        Thread t3 = new Thread(new MyRunnable(), "t3");
        
        t1.start();
        
        //start second thread after waiting for 2 seconds or if it's dead
        try {
            t1.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
//        
        t2.start();
        
        //start third thread only when first thread is dead
//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        t3.start();
//		try {
//			t1.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
        //let all threads finish execution before finishing main thread
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("All threads are dead, exiting main thread");
        
        for (int i=0;i<3;++i){
        	System.out.println(i);
        	
        }
        
        final NameList nl = new NameList();
        nl.add("Ozymandias");
        
		class NameDropper extends Thread {
			public void run() {
				String name = nl.removeFirst();
				System.out.println(name);
			}
		}
		
		Thread tx1 = new NameDropper();
		Thread tx2 = new NameDropper();
		tx1.start();
		tx2.start();

	}

}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread started:::"+Thread.currentThread().getName());
        Thread.yield();
        System.out.println("Thread started again:::"+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Thread ended:::"+Thread.currentThread().getName());
    }
    
}

class NameList {
	private List names = Collections.synchronizedList(new LinkedList());

	public synchronized void add(String name) {
		names.add(name);
	}

	public synchronized String removeFirst() {
		if (names.size() > 0)
			return (String) names.remove(0);
		else
			return null;
	}
}

class E implements Closeable { public void close() {} }
