package udacity.multi;

public class _3Synchronized {
	private int count = 0;
	
	public static void main (String[] args) throws InterruptedException {
		_3Synchronized app = new _3Synchronized();
		app.doWork();
	}
	
	public synchronized void increment( ) {
		count++;
	}
	
	public  void doWork() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
					/*synchronized(_3Synchronized.this){
						count++;
					}*/
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					increment();
					/*synchronized(_3Synchronized.this) {
						count++;
					}*/
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Count is: " + count);
	}
	
}
