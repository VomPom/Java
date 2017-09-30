package WORK.Java.Java812Thread.fourth;

/**
 * Created by Julis on 17/8/12.
 * User:Julis 落叶挽歌
 * Date:17/8/12
 * Time:下午6:50
 */
public class Clerk {
    private int product=0;
    public synchronized void addProduct(){
        if(this.product>=10){
            try {
                System.out.println("等待中");
                this.wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            product++;
            System.out.println("生产第"+this.product+"个产品");
            this.notifyAll();
        }
    }
    public synchronized void subProduct(){
        if(this.product<0){
            try {
                this.wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("销售第"+this.product+"个产品");
            product--;

            this.notifyAll();
        }
    }
}


