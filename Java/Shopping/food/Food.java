package WORK.Java.Shopping.food;

/**
 * Created by Julis on 17/7/29.
 * User:Julis 落叶挽歌
 * Date:17/7/29
 * Time:下午3:17
 */
public class Food {
    private String name;

    private int count;
    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
    public Food(String name, int count) {
        this.name = name;
        this.count = count;
    }
    public void setCount(int count) {
        this.count = count;
    }

}
