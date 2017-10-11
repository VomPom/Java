package Java.Shopping;
import Java.Shopping.food.Food;
import Java.Shopping.util.Print;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Julis on 17/7/29.
 * User:Julis 落叶挽歌
 * Date:17/7/29
 * Time:下午3:21
 */
public class Stocker extends Shop{

    private String name;
    private Food[] foods;
    private static int OPTION_STOCK;
    private static int COUNT_STOCK;
    public Stocker(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Food[] getFoods() {
        return foods;
    }
    public void setFoods(Food[] foods) {
        this.foods = foods;
    }

    public void stock(Shop shop){
        this.setFoods(shop.getFoods());
        int COUNT_OF_FOODS=shop.getFoods().length;//获取食物类的数量
        //SYs
        while (OPTION_STOCK!=COUNT_OF_FOODS+1){//判断输入的值 是否为最后一个选项:EXIT

            Print.showFoodsOptions();//打印货物清单
            try{
                OPTION_STOCK=new Scanner(System.in).nextInt();//输入要进货的选项
            }catch (InputMismatchException e) {
                System.err.println("非法输入选项!");
            }

            if(OPTION_STOCK<=COUNT_OF_FOODS
                    &&
                    OPTION_STOCK>0){//如果不是结束或者非法选项

                System.out.println("请输入("+shop.getFoods()[OPTION_STOCK-1].getName()+")进货的数量:");
                try{
                    COUNT_STOCK=new Scanner(System.in).nextInt();//输入进货的数量
                }catch (InputMismatchException e){
                   System.err.println("数量输入非法!");
                }

                 int nowCount=shop.getFoods()[OPTION_STOCK-1].getCount();//现在某种类的数量
                shop.getFoods()[OPTION_STOCK-1].setCount(nowCount+COUNT_STOCK);//对商店的数量进行处理

                this.foods[OPTION_STOCK-1].setCount(COUNT_STOCK);

            }else if(OPTION_STOCK==COUNT_OF_FOODS+1){

                Print.showList(this.foods,"进货清单");//打印进货清单
            }
        }
    }

}
