package WORK.Java.Java727Interface.Fourth;

/**
 * Created by Julis on 17/7/27.
 * User:Julis 落叶挽歌
 * Date:17/7/27
 * Time:下午1:57
 */
public class MyRectangle implements Area {
    private double width;
    private double height;

    public MyRectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateAre() {
        return width*height;
    }
}
