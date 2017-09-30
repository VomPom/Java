package WORK.Java.Java725Construction;

/**
 * Created by Julis on 17/7/25.
 * User:Julis 落叶挽歌
 * Date:17/7/25
 * Time:下午1:18
 */
public class StudentTest {
    public static void main(String []args){
        Student studentInitName=new Student("李东东");
        System.out.println("通过构造方法设置姓名为:"+studentInitName.name);
        Student studentMethod=new Student();
        studentMethod.name="张西西";
        System.out.println("通过普通函数设置姓名为:"+studentMethod.name);
        Student studentDirect=new Student();
        studentDirect.name="王楠楠";
        System.out.println("通过直接调用属性设置姓名为:"+studentDirect.name);
    }
}
