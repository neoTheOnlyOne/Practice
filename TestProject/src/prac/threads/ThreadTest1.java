package prac.threads;

public class ThreadTest1 {

	public static void main(String[] args) {
		MyThread thread1 = new MyThread("Thread1..");
		MyThread thread2 = new MyThread("Thread2..");
		thread1.start();
		thread2.start();
		boolean isThread1live = true;
		boolean isThread2live = true;
		do {
			if (isThread1live && !thread1.isAlive()) {
				isThread1live = false;
				System.out.println("Thread 1 is dead.");
			}
			if (isThread2live && !thread2.isAlive()) {
				isThread2live = false;
				System.out.println("Thread 2 is dead.");
			}
		} while (isThread1live || isThread2live);

	}
}

class MyThread extends Thread {
	static String message[] = { "Java", "is", "hot,", "aromatic,", "and", "invigorating." };

	public MyThread(String id) {
		super(id);
	}

	public void run() {
		String name = getName();
		for (int i = 0; i < message.length; i++) {
			randomWait();
			System.out.println(name + message[i]);
		}
	}

	void randomWait() {
		try {
			sleep((long) (3000 * Math.random()));
		} catch (InterruptedException x) {
			System.out.println("Interrupted!");
		}
	}
}