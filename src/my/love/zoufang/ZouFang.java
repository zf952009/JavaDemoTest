package my.love.zoufang;


public class ZouFang {

	public static void main(String[] args) {
		ZouFangNameAge love = new ZouFangNameAge();
		love.setAge(18);
		love.setName("邹芳");
		ZouFangNameAge love1 = new ZouFangNameAge("邹大头", 18);

		System.out.println(love1.getAge() + love1.getName());
		System.out.println(love.getAge() + love.getName());

	}

}

class ZouFangNameAge {
	private String name;
	private int age;
	private String images;
	private String add;
	private String qq;
	private String emali;
	private String tel;
	private String love;
	

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmali() {
		return emali;
	}

	public void setEmali(String emali) {
		this.emali = emali;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLove() {
		return love;
	}

	public void setLove(String love) {
		this.love = love;
	}

	ZouFangNameAge(String name, int age) {
		this.name = name;
		this.age = age;
	}

	ZouFangNameAge() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
