package WORK.Java.Java812Thread.first;

/**
 * Created by Julis on 17/8/12.
 * User:Julis 落叶挽歌
 * Date:17/8/12
 * Time:下午4:25
 */
public class Test {
    public static void main(String []args){
        Thread  thread1=new Thread(new StudentRun("学生1"));
        Thread  thread2=new Thread(new StudentRun("学生2"));
        Thread  thread3=new Thread(new StudentRun("学生3"));
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
