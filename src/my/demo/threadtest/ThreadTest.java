package my.demo.threadtest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource {
	private String name;
	private String sex;
	private int cont;
	// 定义标记
	private boolean flag = false;
	// 创建一个锁对象
	private final Lock lock = new ReentrantLock();
	// 通过锁对象获取监视器对象
	private Condition con = lock.newCondition();

	// 赋值功能
	public void set(String sex, String name,int cont) {
		lock.lock();//开启锁
		try {
			if (flag)
				try {
					con.await();//当前线程等待
				} catch (InterruptedException e) {
				}
			this.name = name;
			this.sex = sex;
			this.cont=cont;
			flag = true;
			con.signal();//唤醒线程池的任意一个线程
		} finally {
			lock.unlock();//释放锁
		}
	}

	public void out() {
		lock.lock();//开启锁
		try {
			if (!flag)
				try {
					con.await();//当前线程等待
				} catch (InterruptedException e) {
				}
			System.out.println(name + "----" + sex+"***"+cont);
			flag = false;
			con.signal();//唤醒线程池任意一个线程
		} finally {
			lock.unlock();//释放锁
		}
	}
}

// 创建赋值线程任务
class Input implements Runnable {
	private Resource r;

	public Input(Resource r) {
		this.r = r;
	}

	public void run() {
		int x = 0;
		int cont=1;
		while (true) {
			if (x == 0) {
				r.set("邹芳", "邹芳",cont);
			} else {
				r.set("zoufnag", "zoufang",cont);
			}
			++cont;
			x = (x + 1) % 2;
		}
	}

}

// 获取线程任务
class OutInput implements Runnable {
	private Resource r;

	public OutInput(Resource r) {
		this.r = r;
	}

	public void run() {
		while (true) {
			r.out();
		}

	}

}

public class ThreadTest {

	public static void main(String[] args) {
		Resource r=new Resource();
		Input input=new Input(r);
		OutInput outInput=new OutInput(r);
		Thread inputThread=new Thread(input);
		Thread outThread=new Thread(outInput);
		inputThread.start();
		outThread.start();

	}

}
