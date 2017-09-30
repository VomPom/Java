package WORK.Java.Java803Collection.fourth;

import WORK.Java.Shopping.food.Food;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Julis on 17/8/3.
 * User:Julis 落叶挽歌
 * Date:17/8/3
 * Time:下午5:18
 */
public class KeyTest {
    public static void main(String []args){
        Map<Fruit,String> fruitMap =new HashMap<>();
        initData(fruitMap);

        Fruit pear=new Fruit("梨子");

        if(fruitMap.containsKey(pear)){
            System.out.println("找得到");
            System.out.println("value:"+fruitMap.get(pear));
        }else{
            System.out.println("找不到");
        }


    }
    public static void initData( Map<Fruit,String> fruitMap){
        Fruit waterlemon=new Fruit("西瓜");
        Fruit pear=new Fruit("梨子");
        Fruit walnut=new Fruit("核桃");
        Fruit longan=new Fruit("桂圆");
        fruitMap.put(waterlemon,"水果");
        fruitMap.put(pear,"水果");
        fruitMap.put(walnut,"干果");
        fruitMap.put(longan,"干果");
    }
}
