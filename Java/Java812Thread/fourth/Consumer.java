package WORK.Java.Java812Thread.fourth;

import java.io.File;

/**
 * Created by Julis on 17/8/12.
 * User:Julis 落叶挽歌
 * Date:17/8/12
 * Time:下午6:54
 */
public class Consumer  implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者开始消费");
        try {

            Thread.sleep((int)(Math.random()*10)*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clerk.subProduct();

    }
}
