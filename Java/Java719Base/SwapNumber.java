package WORK.Java.Java719Base;

/**
 * Created by Julis on 17/7/19.
 * User:Julis 落叶挽歌
 * Date:17/7/19
 * Time:下午4:18
 */
public class SwapNumber {
    public static int a=124;
    public static int b=34;
    public static void swap(){
        int t;
        t=a;
        a=b;
        b=t;
    }
    public static void main(String []args){

        System.out.println("交换前a的值为:"+a+" b的值为:"+b);
        swap();
        System.out.println("交换后a的值为:"+a+" b的值为:"+b);
    }
}
