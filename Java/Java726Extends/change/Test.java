package WORK.Java.Java726Extends.change;

import java.util.GregorianCalendar;

public class Test {

	public static void main(String[] args) {
		GregorianCalendar calendar=(GregorianCalendar)GregorianCalendar.getInstance();//设置当前日期为普通学生的毕业时间为当前
		Student student=new Student();//普通学生
		Student collegeStudent=new CollegeStudent();//CollegeStudent学生
		student.setTime(calendar);//设置普通学生毕业时间
		collegeStudent.setTime(calendar);
		collegeStudent.graduation();
	}
}


