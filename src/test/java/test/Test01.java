package test;


import java.lang.invoke.MethodHandles;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Test01 {
	/*
	Correct implementation of single thread execution, queue size 0, 
	discard all new task if thread is busy.
	*/ 
	ThreadPoolExecutor executor;
	
	private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	@BeforeEach
	public void init() {
//		executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		// executors = Executors.newSingleThreadExecutor();
		executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, 
				new SynchronousQueue<Runnable>(),
				new ThreadPoolExecutor.DiscardPolicy());
	}

	@Test
	public void test01() {

		log.info("Test01 started");
		for (int i = 0; i < 100; i++) {
			executor.execute(new Task());
			log.info("added new Task");
			try {
				int millis = (new Random()).nextInt(2000);
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		log.info("Test01 ended");
	}

	@AfterEach
	public void cleanup() throws InterruptedException {
		Thread.sleep(10000);
	}

	class Task implements Runnable {

		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			log.info("exec current thread(start): {}", threadName);
//			int millis = (new Random()).nextInt(5000);
			int millis = 5000;
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.info("exec current thread(completed): {}:{}", threadName,  millis);
		}

	}

}
