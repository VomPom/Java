package WORK.Java.Java725Construction;

/**
 * Created by Julis on 17/7/25.
 * User:Julis 落叶挽歌
 * Date:17/7/25
 * Time:下午1:48
 */
public class UtlitsStringTest {
    public static void main(String []args){
        String string="HJHJKHAsdg78912ds12asg5";
        System.out.println("不为空的情况:"+UtlitsString.trans(string));

        string="";
        System.out.println("为空的情况:"+UtlitsString.trans(string));
        String st=new String();
        st=null;
        System.out.println("为null的情况:"+UtlitsString.trans(st));

    }
}
