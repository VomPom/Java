package WORK.Java.Java803Collection.third;

import java.util.*;

/**
 * Created by Julis on 17/8/3.
 * User:Julis 落叶挽歌
 * Date:17/8/3
 * Time:下午5:06
 */
public class MapTest {
    public static void main(String []args){
        Map<Integer,String> wordCup=new HashMap<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入年份:");
        int num=scanner.nextInt();

        initData(wordCup);
        if(wordCup.containsKey(num)){
            System.out.println(num+"年世界杯冠军是:"+wordCup.get(num));
        }else{
            System.out.println("该年没有举办世界杯");
        }


    }
    public static void initData( Map<Integer,String> wordCup){
        wordCup.put(2014,"德国");
        wordCup.put(2010,"西班牙");
        wordCup.put(2006,"意大利");
        wordCup.put(2002,"巴西");
        wordCup.put(1998,"法国");
        wordCup.put(1994,"巴西");
    }
}
