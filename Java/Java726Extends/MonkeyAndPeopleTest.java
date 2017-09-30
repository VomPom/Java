package WORK.Java.Java726Extends;

/**
 * Created by Julis on 17/7/26.
 * User:Julis 落叶挽歌
 * Date:17/7/26
 * Time:下午12:56
 */
public class MonkeyAndPeopleTest {
    public static void main(String []args){
        Monkey monkey=new Monkey("猴子");
        monkey.speak();

        People people=new People("晓东");
        people.speak();
        people.think();
    }
}
