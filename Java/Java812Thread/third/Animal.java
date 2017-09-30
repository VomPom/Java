package WORK.Java.Java812Thread.third;

/**
 * Created by Julis on 17/8/12.
 * User:Julis 落叶挽歌
 * Date:17/8/12
 * Time:下午6:39
 */
public class Animal {
    private static boolean flag=false;
    public synchronized void show() throws Exception {
        if(flag){
            throw new Exception("不能再调用");
        }
        System.out.println("Show方法执行");
        flag=true;
    }
}
