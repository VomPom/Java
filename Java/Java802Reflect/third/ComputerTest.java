package WORK.Java.Java802Reflect.third;

import WORK.Java.Java802Reflect.seconed.Children;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Julis on 17/8/2.
 * User:Julis 落叶挽歌
 * Date:17/8/2
 * Time:下午1:34
 */
public class ComputerTest {
    public static void main(String []args){
        String className="WORK.Java.Java802Reflect.third.Computer";
        try {
            Class clazz=Class.forName(className);
            Constructor constructor=clazz.getConstructor(String.class); //获取特定参数的构造方法
            Computer computer=(Computer)constructor.newInstance("DELL");//构造创建一个computer对象
            Method method=clazz.getDeclaredMethod("printBrand");//获取名为printBrand的成员方法
            method.invoke(computer);//调用printBrand方法

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
