package Java.Shopping.person;

import Java.Shopping.food.Food;

/**
 * Created by Julis on 17/7/29.
 * User:Julis 落叶挽歌
 * Date:17/7/29
 * Time:下午3:25
 */
public class Customer {
    private Food[] foods;
    public void setFoods(Food[] foods) {
        this.foods = foods;
    }
    public  Food[] getFoods() {
        return foods;
    }


}
