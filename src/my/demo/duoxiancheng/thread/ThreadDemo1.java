package my.demo.duoxiancheng.thread;


public class ThreadDemo1 {

	public static void main(String[] args) {
		Ticket ts=new Ticket(10);
		Ticket ts1=new Ticket(10);
		Ticket ts2=new Ticket(10);
		ts.start();
		ts.run();
		ts1.start();
		ts1.run();
		ts2.start();
		ts2.run();
		//System.out.println(50);
	}

}
class Ticket extends Thread{
	private int age;
	
	Ticket(int age) {
		super();
		this.age = age;
	}

	public void run() {
		while (age<50) {
			//Thread.currentThread().getName():获取当前线程名称
			System.out.println(Thread.currentThread().getName()+age++);
			
		}
	}
	
}