package ru.rbt.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMultiThread {

	class ChildThread implements Runnable {

		@Override
		public void run() {
			int cnt = 0;
			while(cnt < 10) {
				System.out.println(Thread.currentThread().getName() + " - " + cnt );
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cnt++;
			} 
		}		
	}
	
	public void go() {
		ChildThread ct = new ChildThread();
		Executors.newFixedThreadPool(1).submit(ct);		
//		Thread t = new Thread(ct, "ChildThread");
//		t.setDaemon(true);
//		t.start();
	}
	
	public static final void main(String [] args) {
		System.out.println("Main start");
		TestMultiThread test = new TestMultiThread();
		test.go();
		System.out.println("Main end");
	}
	
}
