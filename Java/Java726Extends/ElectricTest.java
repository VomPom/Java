package WORK.Java.Java726Extends;

/**
 * Created by Julis on 17/7/26.
 * User:Julis 落叶挽歌
 * Date:17/7/26
 * Time:下午12:44
 */
class TV extends Electric{
    @Override
    public void useElectric() {
        System.out.println("TV使用电");
    }
    public void showMovie(){
        System.out.println("TV放电影");
    }
}
class Phone extends Electric{
    @Override
    public void useElectric() {
        System.out.println("Phone使用电");
    }
    public void call(){
        System.out.println("Phone打电话");
    }
}
public class ElectricTest {
    public static void main(String []args){
        TV tv =new TV();
        tv.useElectric();
        tv.showMovie();
        Phone iphone=new Phone();
        iphone.useElectric();
        iphone.call();
    }
}



