package WORK.Java.Shopping.util;

import WORK.Java.Shopping.food.Food;

/**
 * Created by Julis on 17/7/29.
 * User:Julis 落叶挽歌
 * Date:17/7/29
 * Time:下午4:41
 */
public class Print {
    public static void showFoodsOptions(){

        System.out.println("=======请选择你要进的货物======");
        System.out.println("1`苹果");
        System.out.println("2`梨子");
        System.out.println("3`荔枝");
        System.out.println("4`李子");
        System.out.println("5`栗子");
        System.out.println("6`EXIT");
        System.out.println("============================");
        System.out.println("请输入要进货的选项");
    }
    public static void showList(Food[]foods,String type){
        System.out.println("********"+type+"********");
        System.out.println("名称    数量");
        for(int i=0;i<foods.length;i++){
            if(foods[i].getCount()!=0){
                System.out.println(foods[i].getName()+"    "+foods[i].getCount());
            }
        }
        System.out.println("************************\n");

    }
    public static void showAfterList(Food[]foods,String type){
        System.out.println("======="+type+"====");
        System.out.println("序号     名称    数量");
        int i;
        for(i=0;i<foods.length;i++){
            if(foods[i].getCount()!=0){
                System.out.println((i+1)+"       "+foods[i].getName()+"    "+foods[i].getCount());
            }
        }
        System.out.println((i+1)+"       EXIT");
        System.out.println("=====================\n");
    }

}



















