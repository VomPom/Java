package Java.Management.personalmanager.model;

public class Person {

	private Integer id;
	private String name;
	private String sex;
	private String department;
	private Integer salary;

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", sex=" + sex + ", department=" + department + ", salary="
				+ salary + "]";
	}

	public Person() {
		super();
	}

	public Person(Integer id, String name, String sex, String department, Integer salary) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.department = department;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

}
