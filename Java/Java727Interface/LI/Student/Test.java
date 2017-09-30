package WORK.Java.Java727Interface.LI.Student;
interface L{
	void go();
}
abstract class A implements L{

}
class C extends A{

	@Override
	public void go() {

	}
}
public class Test {

	public static void main(String[] args) {
		C c=new C();
		c.go();
//		Student s1=new Student();
//		s1.setName("小米");
//
//		Student.Course c1=s1.new Course("数学",75);
//		Student.Course c2=s1.new Course("英语",55);
//		Student.Course c3=s1.new Course("程序设计",95);
//		Student.Course []course=new Student.Course[]{c1,c2,c3};
//		s1.setCourse(course);

	}
}
