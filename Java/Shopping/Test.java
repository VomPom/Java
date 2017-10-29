package Java.Shopping;

import Java.Shopping.food.*;
import Java.Shopping.person.Customer;
import Java.Shopping.person.Father;
import Java.Shopping.person.Son;
import Java.Shopping.util.Print;

import java.util.Scanner;

/**
 * Created by Julis on 17/7/29.
 * User:Julis 落叶挽歌
 * Date:17/7/29
 * Time:下午3:32
 */
public class Test {
    private static Shop shop;
    private static Stocker stocker;
    private static Food []foods;
    private static Food []eatFoods;
    private static Saler saler;
    private static Customer customer;
    private static Father father;
    private static Son son;

    public static void main(String []args){

        initData();//初始化相关一些数据
        System.out.println("进货员("+shop.getStocker().getName()+")开始进货咯");
        stocker.stock(shop);//进货员开始进货
        System.out.println("进货员("+shop.getStocker().getName()+")进货结束");

        System.out.println("欢迎光临!销售员("+shop.getSaler().getName()+")很高兴为你服务");
        System.out.println("请输入要购买的产品编号");
        saler.sell(shop,customer);//销售员开始服务
        System.out.println("销售员("+saler.getName()+")服务结束");

        System.out.println("爸爸开始吃东西啦!吃点什么呢?");
        father.eatFood();
        System.out.println("儿子开始吃东西啦!吃点什么呢?");
        son.eatFood();


    }
    public static void initData(){
        shop=new Shop();
        customer=new Customer();
        father=new Father("爸爸");
        son=new Son("儿子");
        stocker=new Stocker("阿迪兰.邓布利多");
        saler=new Saler("买买提.席尔瓦");
        shop.setStocker(stocker);
        shop.setSaler(saler);

        Food apple=new Apple("苹果",0);
        Food pear=new Pear("梨子",0);
        Food lichi=new Lichi("荔枝",0);
        Food plum=new Plum("李子",0);
        Food chestnut=new Chestnut("栗子",0);

        Food apple2=new Apple("苹果",0);
        Food pear2=new Pear("梨子",0);
        Food lichi2=new Lichi("荔枝",0);
        Food plum2=new Plum("李子",0);
        Food chestnut2=new Chestnut("栗子",0);

        foods= new Food[]{apple, pear, lichi, plum, chestnut};
        eatFoods=new Food[]{apple2, pear2, lichi2, plum2, chestnut2};

        customer.setFoods(eatFoods);
        shop.setFoods(foods);
        father.setFoods(customer.getFoods());
        son.setFoods(father.getFoods());



    }
}