package top100.multithread;


public class SynchronizedExample5 {
	private static final long SLEEP_INTERVAL_MS = 5000;
	private static final Object lock = new Object();
	
	public void foo() {
		synchronized (lock) {
			System.out.println("Inside foo");
			try {
				Thread.sleep(SLEEP_INTERVAL_MS);
			} catch (InterruptedException e) {
				// 
			}
		}
	}
	
	public void bar() {
		synchronized (lock) {
			System.out.println("Inside bar");
		}
	}
	
	public void foobar() {
		System.out.println("Inside foobar");
	}
	
	public static void main(String[] args) throws InterruptedException {
		final SynchronizedExample5 s = new SynchronizedExample5();
		final SynchronizedExample5 s2 = new SynchronizedExample5();
		Thread T1 = new Thread((Runnable) () -> {s.foo();});
		Thread T2 = new Thread((Runnable) () -> {s2.bar();});
		Thread T3 = new Thread(new Runnable() {
			@Override
			public void run() {
				s.foobar();
			}
		});
		T1.start();
		T2.start();
		T3.start();
		
		T1.join();
		T2.join();
		T3.join();
	}
}
