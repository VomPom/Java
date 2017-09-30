package WORK.Java.Java727Interface.Fifth;

/**
 * Created by Julis on 17/7/27.
 * User:Julis 落叶挽歌
 * Date:17/7/27
 * Time:下午2:07
 */
public class Computer implements USB,DVD{
    @Override
    public void playDVD() {
        System.out.println("使用了DVD接口");
    }

    @Override
    public void useUSB() {
        System.out.println("使用了USB接口");
    }
}
