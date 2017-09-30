package WORK.Java.Java812Thread.seconed;

/**
 * Created by Julis on 17/8/12.
 * User:Julis 落叶挽歌
 * Date:17/8/12
 * Time:下午5:47
 */
public class FlagAddThread extends Thread {
    private Flag flag;
    public FlagAddThread(Flag flag) {
        super();
        this.flag=flag;
    }

    @Override
    public void run() {
       flag.add();
    }
}
