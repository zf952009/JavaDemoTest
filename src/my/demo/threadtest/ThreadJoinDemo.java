package my.demo.threadtest;

class JoinDemo implements Runnable {
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().getId() + "******" + i);
			Thread.yield();
			// 线程临时暂停，将执行权释放，让其他线程(包括自己)有机会获得执行权
		}

	}

}

public class ThreadJoinDemo {

	public static void main(String[] args) {
		JoinDemo j = new JoinDemo();
		Thread t1 = new Thread(j, "zoufang1");
		Thread t2 = new Thread(j, "zoufang");
		t1.start();
		// 当主线程执行到t1.join()，知道t1要加入执行，主线程释放了执行权
		// 执行资格并处于冻结状态，等到t1线程执行完之后，主线程恢复执行权
		// 用于临时加入一个运算的线程，让该线程执行完，程序才会继续执行
		/*
		 * try { t1.join(); } catch (InterruptedException e) {
		 * 
		 * }
		 */
		t2.start();
		/*
		 * try { t2.join(); } catch (InterruptedException e) {
		 * 
		 * }
		 */
		for (int x = 1; x <= 100; x++) {
			System.out.println("-------" + x);
			Thread.yield();
		}

	}

}
