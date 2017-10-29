package Java.Shopping;
import Java.Shopping.food.Food;
import Java.Shopping.person.Customer;

/**
 * Created by Julis on 17/7/29.
 * User:Julis 落叶挽歌
 * Date:17/7/29
 * Time:下午3:20
 */
public class Shop {
    private static Food []foods;
    private Stocker stocker;
    private Saler saler;
    public void setStocker(Stocker stocker) {
        this.stocker = stocker;
    }
    public void setSaler(Saler saler) {
        this.saler = saler;
    }
    public Stocker getStocker() {
        return stocker;
    }
    public Saler getSaler() {
        return saler;
    }
    public Food[] getFoods() {
        return foods;
    }
    public void setFoods(Food[] foods) {
        this.foods = foods;
    }





}
