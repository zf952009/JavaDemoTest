package my.demo.duoxiancheng.thread;

public class RunbleDemo1 {

	public static void main(String[] args) {
		for (int i=0; i>0;i++) {
			System.out.println(i);

		}
		TempRunble temp = new TempRunble("zoufang", 18);
		Thread t1=new Thread(temp);
		Thread t2=new Thread(new TempRunble("zoufang2222", 10));
		t2.start();
		t1.start();
	}
}

class TempRunble implements Runnable {
	private String name;
	private int number;

	TempRunble(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public void run() {
		while (true) {
			System.out.println(name + number--);

		}

	}

}
