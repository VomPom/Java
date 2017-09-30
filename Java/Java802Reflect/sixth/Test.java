package WORK.Java.Java802Reflect.sixth;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Julis on 17/8/2.
 * User:Julis 落叶挽歌
 * Date:17/8/2
 * Time:下午3:31
 */
public class Test {
    public static void main(String []args) throws NoSuchFieldException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            getTest();
    }
        public static void  getTest(){
                try {
                    Class clazz=Class.forName("WORK.Java.Java802Reflect.sixth.Outter$Inner");
                    Method test=clazz.getDeclaredMethod("test",null);
                    test.setAccessible(true);
                    Class o=Outter.class;
                    Field field=o.getDeclaredField("in");
                    field.setAccessible(true);
                    Object inner=field.get(o.newInstance());
                    test.invoke(inner);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
        }
        public static void  getTest2(){
                Class clazz = Outter.class;
                try {
                        Field field = clazz.getDeclaredField("in");
                        field.setAccessible(true);
                        Object in =field.get(clazz.newInstance());
                        Class inner=in.getClass();
                        Method method = inner.getDeclaredMethod("test");
                        method.setAccessible(true);
                        method.invoke(in);
                } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                } catch (InstantiationException e) {
                        e.printStackTrace();
                } catch (IllegalAccessException e) {
                        e.printStackTrace();
                } catch (InvocationTargetException e) {
                        e.printStackTrace();
                }

        }

}








