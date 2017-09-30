package WORK.Java.Java723Object;

/**
 * Created by Julis on 17/7/24.
 * User:Julis 落叶挽歌
 * Date:17/7/24
 * Time:下午2:37
 */
public class Student {
    private int no;
    private String name;
    private String sex;
    private int age;
    private double java;

    public Student(int no, String name, String sex, int age, double java) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.java = java;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getJava() {
        return java;
    }

    public void setJava(double java) {
        this.java = java;
    }

}




