package WORK.Java.Java723Object;

/**
 * Created by Julis on 17/7/24.
 * User:Julis 落叶挽歌
 * Date:17/7/24
 * Time:下午2:38
 */
public class StudentTest {
    public static void main(String []args){
        Student student1=new Student(15213,"晓东","男",22,87.7);
        Student student2=new Student(15214,"小红","女",23,97.2);
        System.out.println("平均成绩为:"+(student1.getJava()+student2.getJava())/2);
    }
}
