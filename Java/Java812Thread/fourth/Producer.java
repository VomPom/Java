package WORK.Java.Java812Thread.fourth;

/**
 * Created by Julis on 17/8/12.
 * User:Julis 落叶挽歌
 * Date:17/8/12
 * Time:下午6:49
 */
public class Producer  implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产");
        while (true){
            try {
                Thread.sleep((int)(Math.random()*10)*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }

    }
}




