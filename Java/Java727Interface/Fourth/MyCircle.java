package WORK.Java.Java727Interface.Fourth;

/**
 * Created by Julis on 17/7/27.
 * User:Julis 落叶挽歌
 * Date:17/7/27
 * Time:下午1:57
 */
public class MyCircle implements Area {
    private double radius;

    public MyCircle(double radius) {
        this.radius = radius;
    }
    @Override
    public double calculateAre() {
        return Math.PI*Math.pow(radius,2.0);
    }
}
