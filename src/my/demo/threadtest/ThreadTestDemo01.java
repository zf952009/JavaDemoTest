package my.demo.threadtest;

/*
 * 线程的匿名内部类使用
 * */
public class ThreadTestDemo01 {

	public static void main(String[] args) {
		new Thread() {
			public void run() {
				for (int i = 1; i <= 100; i++) {
					System.out.println(Thread.currentThread().toString() + "---X--" + i);
				}
			}
		}.start();

		Runnable t = new Runnable() {
			public void run() {
				for (int i = 1; i <= 100; i++) {
					System.out.println(Thread.currentThread().toString() + "---Y--" + i);
				}
			}
		};
		new Thread(t).start();
		for (int i = 1; i <= 100; i++) {
			System.out.println(Thread.currentThread().toString() + "---Z--" + i);
		}

		/* 面试题;运行结果 */
		new Thread(new Runnable() {
			public void run() {
				System.out.println("我是runnadle的run!!!!");
			}
		}) {
			public void run() {
				System.out.println("我是Thread的run的方法!!!");
			}
		}.start();

	}

}
