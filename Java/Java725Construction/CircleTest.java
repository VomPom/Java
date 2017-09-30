package WORK.Java.Java725Construction;
/**
 * Created by Julis on 17/7/25.
 * User:Julis 落叶挽歌
 * Date:17/7/25
 * Time:下午2:00
 */
public class CircleTest {
    public static void main(String []args){
        Circle circle=new Circle();
        circle.circles=new Circle[10];
        for(int i=0;i<circle.circles.length;i++){
            circle.circles[i]=new Circle();
            circle.circles[i].setRadius(Math.random()*20);
            circle.circles[i].calArea();
        }
        circle.biggest();
        circle.smallets();
        circle.everyArea();

    }
}
