package my.demo.code;


public class ZouFang implements Comparable<Object> {
	private String name;

	private ZouFang() {
		super();
	}

	private ZouFang(String name) {
		super();
		this.setName(name);
	}

	public String toString() {
		return super.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Object o) {
		// TODO 自动生成的方法存根
		return 0;
	}

}
