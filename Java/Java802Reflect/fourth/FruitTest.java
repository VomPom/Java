package WORK.Java.Java802Reflect.fourth;

/**
 * Created by Julis on 17/8/2.
 * User:Julis 落叶挽歌
 * Date:17/8/2
 * Time:下午1:47
 */
public class FruitTest {
    public static void main(String []args){
        String className="WORK.Java.Java802Reflect.fourth.Fruit";
        try {
            Class clazz=Class.forName(className);//第一种通过类名获取对象
            Fruit fruit=(Fruit)clazz.newInstance();
            Class fruit2=Fruit.class;//第一种通过类名获取对象

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
