package WORK.Java.Java726Extends;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Julis on 17/7/26.
 * User:Julis 落叶挽歌
 * Date:17/7/26
 * Time:下午1:01
 */
class CollegeStudent extends Student{
    public void printTime(){
        Date now=new Date();
        Student student=new Student();
        student.time=now;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("普通Student毕业时间"+dateFormat.format(student.time));


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, 1);//计算一个月后的时间
        this.time=calendar.getTime();
        System.out.println("CollegeStudent的毕业时间是："+dateFormat.format(this.time));

    }
}
public class StudentTest {
    public static void main(String []args){
        CollegeStudent collegeStudent=new CollegeStudent();
        collegeStudent.printTime();
    }
}




