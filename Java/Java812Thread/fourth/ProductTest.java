package WORK.Java.Java812Thread.fourth;

/**
 * Created by Julis on 17/8/12.
 * User:Julis 落叶挽歌
 * Date:17/8/12
 * Time:下午6:49
 */
public class ProductTest {
    public static void main(String []args){
        Clerk clerk=new Clerk();
        Thread productThread=new Thread(new Producer(clerk));
        Thread consumerThread=new Thread(new Consumer(clerk));


            productThread.start();
            consumerThread.start();
    }
}
