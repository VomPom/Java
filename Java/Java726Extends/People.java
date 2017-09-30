package WORK.Java.Java726Extends;

/**
 * Created by Julis on 17/7/26.
 * User:Julis 落叶挽歌
 * Date:17/7/26
 * Time:下午12:54
 */
public class People extends Monkey {
    People(String s) {
        super(s);
    }

    @Override
    public void speak() {
        System.out.println("小样不错嘛.");
    }
    public void think(){
        System.out.println("别说话!认真思考");
    }

}
