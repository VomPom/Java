package WORK.Java.Java812Thread.seconed;

/**
 * Created by Julis on 17/8/12.
 * User:Julis 落叶挽歌
 * Date:17/8/12
 * Time:下午5:25
 */
public class Flag {
    private  int num=0;


    public synchronized void add(){
        synchronized (this){
            while (num>=1){
                try {
                    System.out.println("加法等待,num="+this.num);
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num+=1;
            System.out.println("执行加法,num="+this.num);
            this.notifyAll();

        }
    }


    public void sub() {
        synchronized (this){
            while (num<1){
                try {
                    System.out.println("减法等待,num="+this.num);
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num-=1;
            System.out.println("执行减法,num="+this.num);
            this.notifyAll();

        }
    }
}






