package WORK.Java.Java727Interface.Seconed;

/**
 * Created by Julis on 17/7/27.
 * User:Julis 落叶挽歌
 * Date:17/7/27
 * Time:下午1:36
 */
public class Test {
    public static void main(String[]args){

        String []courseName={"数学","英语","程序设计"};
        double [] coreseSocre={98.0,85.5,100};
        Student student=new Student(111,"小红",courseName,coreseSocre);
        student.showAllScore();
    }
}
