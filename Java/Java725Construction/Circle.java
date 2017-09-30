package WORK.Java.Java725Construction;

/**
 * Created by Julis on 17/7/25.
 * User:Julis 落叶挽歌
 * Date:17/7/25
 * Time:下午1:51
 */
public class Circle {
    public Circle [] circles;
    private double radius;
    private double area;
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calArea(){
        area=Math.PI*Math.pow(this.radius,2.0);
        System.out.println("半径为:"+this.radius+"  面积为:"+Math.PI*Math.pow(this.radius,2.0));
        return area;
    }
    public void biggest(){
        double max=circles[0].area;
        for(int i=0;i<circles.length;i++){
            max=circles[i].area>max?circles[i].area:max;
        }
        System.out.println("最大圆面积为:"+max);
    }
    public void smallets(){
        double min=circles[0].area;
        for(int i=0;i<circles.length;i++){
            min=circles[i].area<min?circles[i].area:min;
        }
        System.out.println("最小圆面积为:"+min);
    }
    public void everyArea(){
        double sumAreas=0.0;
        for(int i=0;i<circles.length;i++){
            sumAreas+=circles[i].area;
        }
        System.out.println("所有面积和为:"+sumAreas);
    }



}

