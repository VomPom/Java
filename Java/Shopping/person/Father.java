package WORK.Java.Shopping.person;

import WORK.Java.Shopping.food.*;
import WORK.Java.Shopping.person.Customer;
import WORK.Java.Shopping.util.Print;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Julis on 17/7/29.
 * User:Julis 落叶挽歌
 * Date:17/7/29
 * Time:下午3:26
 */
public class Father extends Customer {

    private int OPTION_EAT=0;
    private int COUNT_EAT=0;
    private String name;
    public Father(String name) {
        this.name = name;
    }
    public void eatFood(){
        Food apple=new Apple("苹果",0);
        Food pear=new Pear("梨子",0);
        Food lichi=new Lichi("荔枝",0);
        Food plum=new Plum("李子",0);
        Food chestnut=new Chestnut("栗子",0);
        Food[]eatFoods= new Food[]{apple, pear, lichi, plum, chestnut};

        int COUNT_OF_FOODS=this.getFoods().length;//获取食物类的数量
        while (OPTION_EAT!=COUNT_OF_FOODS+1){
            Print.showAfterList(this.getFoods(),"食物清单");//打印商品现有的数量清单
            try {
                OPTION_EAT=new Scanner(System.in).nextInt();
            }catch (InputMismatchException e) {
                System.err.println("非法输入选项!");
            }

            if(OPTION_EAT<=COUNT_OF_FOODS
                    &&
                    OPTION_EAT>0){

                System.out.println("请输入("+this.getFoods()[OPTION_EAT-1].getName()+")吃的的数量:");
                try{
                    COUNT_EAT=new Scanner(System.in).nextInt();
                }catch (InputMismatchException e) {
                    System.err.println("非法输入选项!");
                }
                int nowCount=this.getFoods()[OPTION_EAT-1].getCount();
                int newCount=nowCount-COUNT_EAT;
                if(newCount<0){
                    System.out.println("食物不足啦!");
                    newCount=0;
                }
                this.getFoods()[OPTION_EAT-1].setCount(newCount);
                eatFoods[OPTION_EAT-1].setCount(newCount);
            }else if(OPTION_EAT==COUNT_OF_FOODS+1){
                Print.showList(eatFoods,"吃掉的食物");
            }else{
                System.out.println("ERROR!非法输入!");
            }
       }
    }
}
