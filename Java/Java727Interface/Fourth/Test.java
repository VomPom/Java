package WORK.Java.Java727Interface.Fourth;

/**
 * Created by Julis on 17/7/27.
 * User:Julis 落叶挽歌
 * Date:17/7/27
 * Time:下午1:59
 */
public class Test {
    public static void main(String []args){
        MyCircle myCircle=new MyCircle(3.5);
        System.out.println("圆的面积为:"+myCircle.calculateAre());
        MyRectangle myRectangle=new MyRectangle(4.5,2.5);
        System.out.println("矩形面积为:"+myRectangle.calculateAre());
    }
}
