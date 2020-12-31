package my.demo.api.component.list;

public class Student implements Comparable<Student> {
	private String name;
	private int age;
	private int cn;
	private int en;
	private int me;
	private int sum;

	Student() {
		super();
	}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Student(String name, int cn, int en, int me) {
		this.name = name;
		this.cn = cn;
		this.en = en;
		this.me = me;
		this.setSum(cn + en + me);
	}

	public int getCn() {
		return this.cn;
	}

	public void setCn(int cn) {
		this.cn = cn;
	}

	public int getEn() {
		return this.en;
	}

	public void setEn(int en) {
		this.en = en;
	}

	public int getMe() {
		return this.me;
	}

	public void setMe(int me) {
		this.me = me;
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

	@Override
	public String toString() {

		return "姓名:" + this.name + "-总成绩:" + this.sum;
	}

	// 重写compareto方法。建立student对象自己的自然排序方法
	// 按照学生总成绩排序，次要条件按照姓名排序，集合为set的调用
	public int compareTo(Student o) {
		if (!(o instanceof Student)) {
			throw new ClassCastException();
		}
		Student student = (Student) o;
		int temp = this.sum - student.sum;
		return temp == 0 ? this.name.compareTo(student.name) : temp;
	}

	// 判断对象相同的方法
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (this.age != other.age)
			return false;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		return true;
	}
	// 判断对象相同
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.age;
		result = prime * result
				+ ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	// 建立student对象的自己的判断相同的依据
	public boolean equals(Student obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Student)) {
			throw new ClassCastException();
		}
		Student student = (Student) obj;
		return this.name.equals(student.name) && this.age == student.age;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}

}
