package top100.multithread;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

import com.sun.jmx.snmp.tasks.TaskServer;

import trytry.tryDeque;

public class Scheduler {
	private PriorityQueue<Task> tasks;
	private final Thread taskRunnerThread;
	private volatile boolean running;
	private final AtomicInteger taskId;
	
	public Scheduler() {
		tasks = new PriorityQueue<>();
		taskRunnerThread = new Thread(new TaskRunner());
		running = true;
		taskId = new AtomicInteger(0);
		taskRunnerThread.start();
	}
	
	public void schedule(Task task, Long delayMs) {
		long timeToRun = System.currentTimeMillis() + delayMs;
		task.setTimeToRun(timeToRun);
		task.setId(taskId.incrementAndGet());
		synchronized (this) {
			tasks.offer(task);
			this.notify();
		}
	}
	
	public void stop() throws InterruptedException {
		synchronized (this) {
			running = false;
			this.notify();
		}
		taskRunnerThread.join();
	}
	private class TaskRunner implements Runnable {
		@Override
		public void run() {
			while(running) {
				synchronized (Scheduler.this) {
					try {
						while (running && tasks.isEmpty()) {
							Scheduler.this.wait();
						}
						long now = System.currentTimeMillis();
						Task t = tasks.peek();
						if (t.getTimeToRun() < now) {
							tasks.poll();
							t.run();
						} else {
							Scheduler.this.wait(t.getTimeToRun() - now);
						}
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			}
		}
	}
	
	public void main(String[] args) throws InterruptedException {
		Scheduler scheduler = new Scheduler();
		scheduler.schedule(new Task(), 1000000l);
		scheduler.schedule(new Task(), 1000l);
		Thread.sleep(7000);
		scheduler.stop();
	}
	
}



class Task implements Comparable<Task> {
	private long timeToRun;
	private int id;
	 public void setId(int id) {
		 this.id = id;
	 }
	 
	 public void setTimeToRun(long timeToRun) {
		 this.timeToRun = timeToRun;
	 }
	 
	 public void run() {
		 System.out.println("Running task " + id);
	 }
	 
	 public int compareTo(Task other) {
		 return (int) (timeToRun - other.getTimeToRun());
	 }
	 public long getTimeToRun() {
		 return timeToRun;
	 }
	 
}