package WORK.Java.Java723Object;

/**
 * Created by Julis on 17/7/24.
 * User:Julis 落叶挽歌
 * Date:17/7/24
 * Time:下午2:29
 */
public class Rectangle {
    private double width;
    private double height;
    static String color;
    Rectangle(){
        this.width=1;
        this.height=1;
        System.out.println("默认构造方法,长和宽都为1");
    }
    Rectangle(double width,double height){
        this.width=width;
        this.height=height;
        System.out.println("自定义长和宽:"+"长="+this.height+"宽="+this.width);
    }
    public void getArea(){
        System.out.println("面积为:"+this.height*this.width);
    }
    public void getPerimeter(){
        System.out.println("周长为:"+2*(this.height+this.width));
    }

}




