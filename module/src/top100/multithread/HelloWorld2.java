package top100.multithread;

public class HelloWorld2 {
	public static void main(String[] args) throws InterruptedException{
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("Hello, world!");
			}
		});
		thread.start();
		thread.join();
	}
}
