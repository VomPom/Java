package WORK.Java.Java723Object;

/**
 * Created by Julis on 17/7/24.
 * User:Julis 落叶挽歌
 * Date:17/7/24
 * Time:下午2:25
 */
public class UserTest {
    public static void main(String []args){
        User userEmpty=new User();
        User userWithName=new User("小红");
        User user=new User("晓东","1235i2305");
        user.showUserName();
        user.changeUserName("小东");
    }
}
