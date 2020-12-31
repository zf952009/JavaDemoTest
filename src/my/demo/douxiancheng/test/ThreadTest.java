package my.demo.douxiancheng.test;

public class ThreadTest {

	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		Thread t1 = new Thread(ticket);
		Thread t2 = new Thread(ticket);
		Thread t3 = new Thread(ticket);
		Thread t4 = new Thread(ticket);
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}

class Ticket implements Runnable {
	private int ticket = 1000;
	private Object object = new Object();;

	public Ticket() {
		super();
	}

	public void run() {

		while (true) {
			synchronized (object) {
				if (ticket > 0) {
					try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						
					}
					System.out.println(Thread.currentThread().getName() + ticket--);
				}
			}

			
			
		}
	}

}
