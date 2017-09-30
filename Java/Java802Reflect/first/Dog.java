package WORK.Java.Java802Reflect.first;

/**
 * Created by Julis on 17/8/2.
 * User:Julis 落叶挽歌
 * Date:17/8/2
 * Time:下午12:54
 */
public class Dog{
    private String name;
    private int age;
    public Dog(String name,int age) {
        this.name = name;
        this.age=age;
    }

    public void shout(){
        System.out.println("汪汪汪");
    }
    public void shout(int num){
        System.out.println("汪汪汪了"+num+"次");
    }
}
