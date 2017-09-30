package WORK.Java.Java812Thread.third;

/**
 * Created by Julis on 17/8/12.
 * User:Julis 落叶挽歌
 * Date:17/8/12
 * Time:下午6:44
 */
public class AnimalThread extends Thread {
    private Animal animal;
    public AnimalThread(Animal animal) {
        super();
        this.animal=animal;
    }

    @Override
    public void run() {
        try {
            animal.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
