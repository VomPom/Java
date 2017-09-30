package WORK.Java.Java802Reflect.third;

/**
 * Created by Julis on 17/8/2.
 * User:Julis 落叶挽歌
 * Date:17/8/2
 * Time:下午1:32
 */
public class Computer {
    private String brand;

    public Computer(String brand) {
        this.brand = brand;
    }
    public void printBrand(){
        System.out.println("电脑的牌子为:"+this.brand);
    }
}
