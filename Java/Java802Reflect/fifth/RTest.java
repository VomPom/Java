package WORK.Java.Java802Reflect.fifth;

import java.lang.reflect.Field;

/**
 * Created by Julis on 17/8/2.
 * User:Julis 落叶挽歌
 * Date:17/8/2
 * Time:下午3:16
 */
public class RTest {
    public static void main(String []args){
        Class<?> clasz = R.class;
        getR(clasz);
    }

    private static void getR(Class<?> clasz) {
        Class innerClazz[] = clasz.getDeclaredClasses();
        for(Class claszInner : innerClazz){
            Field[] fields = claszInner.getDeclaredFields();
            for(Field field : fields){
                try {
                    Object object = field.get(claszInner);
                    System.out.println("获取到的属性, 属性名字=" + field.getName()+",   值"+ field.get(null));

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}
