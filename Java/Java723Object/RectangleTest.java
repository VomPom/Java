package WORK.Java.Java723Object;

/**
 * Created by Julis on 17/7/24.
 * User:Julis 落叶挽歌
 * Date:17/7/24
 * Time:下午2:32
 */
public class RectangleTest {
    public static void main(String []args){
        Rectangle rectangleEmpty=new Rectangle();
        rectangleEmpty.getArea();
        rectangleEmpty.getPerimeter();
        Rectangle rectangle=new Rectangle(20.2,5.5);
        rectangle.getArea();
        rectangle.getPerimeter();
    }
}
