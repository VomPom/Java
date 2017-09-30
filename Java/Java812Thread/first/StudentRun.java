package WORK.Java.Java812Thread.first;

import static java.lang.Thread.currentThread;

/**
 * Created by Julis on 17/8/12.
 * User:Julis 落叶挽歌
 * Date:17/8/12
 * Time:下午4:24
 */
public class StudentRun implements Runnable {
    private String name;

    public StudentRun(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        double sum=0;
        while (sum<=100){
            double random=Math.random()*2.0;
            sum+=random;
            //System.out.println(this.name+"跑了:"+sum);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name+":已经到了终点!");

    }
}


