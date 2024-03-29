package top100.multithread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriterLockCounter {
	private int count;
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void increment() {
		try {
			lock.writeLock().lock();
			count++;
		} finally {
			lock.writeLock().unlock();
		}
	}
	
	public int getCount() {
		try {
			lock.readLock().lock();
			return count;
		} finally {
			lock.readLock().unlock();
		}
	}
}
