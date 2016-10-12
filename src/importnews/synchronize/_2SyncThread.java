package importnews.synchronize;
//http://www.importnew.com/21866.html
public class _2SyncThread {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
		Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
		thread1.start();
		thread2.start();
		
		
		
		/*
		SyncThread syncThread1 = new SyncThread();
		SyncThread syncThread2 = new SyncThread();
		Thread thread1 = new Thread(syncThread1, "SyncThread1");
		Thread thread2 = new Thread(syncThread2, "SyncThread2");
		thread1.start();
		thread2.start();
		*/
	}
}
