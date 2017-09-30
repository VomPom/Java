package WORK.Java.Shopping;

import WORK.Java.Shopping.food.Food;
import WORK.Java.Shopping.person.Customer;
import WORK.Java.Shopping.util.Print;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Julis on 17/7/29.
 * User:Julis 落叶挽歌
 * Date:17/7/29
 * Time:下午3:28
 */
public class Saler{

    private String name;
    private Food[]foods;
    private int OPTION_BUY;
    private int COUNT_BUY;
    public Food[] getFoods() {
        return foods;
    }
    public void setFoods(Food[] foods) {
        this.foods = foods;
    }
    public Saler(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public void sell(Shop shop, Customer customer){
        int COUNT_OF_FOODS=shop.getFoods().length;//获取食物类的数量
        this.setFoods(shop.getFoods());

        while (OPTION_BUY!=COUNT_OF_FOODS+1){

            Print.showAfterList(this.getFoods(),"商品清单");//打印商品现有的数量清单
            try{
                OPTION_BUY=new Scanner(System.in).nextInt();//输入选项
            }catch (InputMismatchException e) {
                System.err.println("非法输入选项!");
            }

            if(OPTION_BUY<=COUNT_OF_FOODS
                    &&
                    OPTION_BUY>0){//如果不是结束或者非法选项

                System.out.println("请输入("+this.foods[OPTION_BUY-1].getName()+")购买的数量:");

                try{
                    COUNT_BUY=new Scanner(System.in).nextInt();
                }catch (InputMismatchException e) {
                    System.err.println("非法输入选项!");
                }

                int nowCount=this.foods[OPTION_BUY-1].getCount();
                int newCount=nowCount-COUNT_BUY;
                if(newCount<0){
                    System.out.println("食物不足啦!");
                    newCount=0;
                }
                this.foods[OPTION_BUY-1].setCount(newCount);
                shop.getFoods()[OPTION_BUY-1].setCount(newCount);
                int preCountOfCustomer= customer.getFoods()[OPTION_BUY-1].getCount();
                customer.getFoods()[OPTION_BUY-1].setCount(COUNT_BUY+preCountOfCustomer);

            }else if(OPTION_BUY==COUNT_OF_FOODS+1){
                Print.showList(customer.getFoods(),"买到的食物清单");
            }else{
                System.out.println("ERROR!非法输入!");
            }
        }

    }
}





