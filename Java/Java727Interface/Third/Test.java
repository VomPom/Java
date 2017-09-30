package WORK.Java.Java727Interface.Third;

import WORK.Java.Java727Interface.Third.Cat;

/**
 * Created by Julis on 17/7/27.
 * User:Julis 落叶挽歌
 * Date:17/7/27
 * Time:下午1:53
 */
public class Test {
    public static void main(String []args){
        Cat cat=new Cat();
        System.out.println("Cat类名为:"+cat.getClassName());
        Dog dog=new Dog();
        System.out.println("Dog类名为:"+dog.getClassName());


        for(int i=0;i<8;++i){
            System.out.println(i);
        }


    }
}
