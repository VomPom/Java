package WORK.Java.Management.bean;

/**
 * Created by Julis on 17/8/17.
 * User:Julis 落叶挽歌
 * Date:17/8/17
 * Time:下午8:54
 */
public class Person {
    private int id;
    private String name;
    private String sex;
    private String department;
    private float salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
