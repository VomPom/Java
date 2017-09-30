package WORK.Java.Java802Reflect.sixth;

/**
 * Created by Julis on 17/8/2.
 * User:Julis 落叶挽歌
 * Date:17/8/2
 * Time:下午3:28
 */
public class Outter {
    private Inner in;
    public Outter(){
        in=new Inner();
    }
    private class Inner{
      private void test(){
            System.out.println("test");
        }
    }


}
