package WORK.Java.Java802Reflect.seconed;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Julis on 17/8/2.
 * User:Julis 落叶挽歌
 * Date:17/8/2
 * Time:下午1:14
 */
public class ChildrenTest {
    public static void main(String []args){

        String className="WORK.Java.Java802Reflect.seconed.Children";
        try {
            Class clazz=Class.forName(className);
            Children children=(Children)clazz.newInstance();//构造创建一个Children对象
            Method method=clazz.getDeclaredMethod("eat",int.class);//获取名为eat,参数类型为int的成员方法的对象代表
            method.invoke(children,4);//传入参数调用eat方法
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
