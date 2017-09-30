package WORK.Java.Java802Reflect.first;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {
    public static void main(String []args){
        String className="WORK.Java.Java802Reflect.seconed.Dog";
        try {
            Class clazz=Class.forName(className);//获取指定类的Class对象
            Constructor[] constructors=clazz.getConstructors();//获取类的构造方法
            for(Constructor constructor:constructors){
                System.out.println(constructor);
                String name=constructor.getName();
                String modifiter= Modifier.toString(constructor.getModifiers());//获取修饰符
                System.out.println("构造方法名称为:"+name+"    修饰符为:"+modifiter+"\n参数列表有:");
                Class []paramTypes=constructor.getParameterTypes();//获取方法的参数列表
                for(int i=0;i<paramTypes.length;i++){
                    System.out.println(paramTypes[i]);
                }
            }
            Method[] methods=clazz.getMethods();//获取类的成员方法
            for(Method method:methods){
                String name=method.getName();
                String modifiter= Modifier.toString(method.getModifiers());//获取修饰符
                Class returnType=method.getReturnType();//获取返回类型
                System.out.println("方法名称为:"+name+"    修饰符为:"+modifiter+"  返回类型为:"+returnType+"\n参数列表有:");
                Class []paramTypes=method.getParameterTypes();//获取方法的参数列表
                for(int i=0;i<paramTypes.length;i++){
                    System.out.println(paramTypes[i]);
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}















