package WORK.Java.Java812Thread.seconed;

/**
 * Created by Julis on 17/7/20.
 * User:Julis 落叶挽歌
 * Date:17/7/20
 * Time:下午2:00
 */
public class Test {
    public static void main(String []args){
        Flag flag=new Flag();

       for(int i=0;i<100;i++) {
           new FlagSubThread(flag).start();
           new FlagAddThread(flag).start();
      }


    }
}
