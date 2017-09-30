package WORK.Java.Java803Collection.fifth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Julis on 17/8/3.
 * User:Julis 落叶挽歌
 * Date:17/8/3
 * Time:下午7:03
 */
public class Test {
    public static void main(String []args){
        List<String> list=new ArrayList<>();
        list.add("Justin");
        list.add("Taylor");
        list.add("selena");
        list.add("carly");
        list.add("Adam");
        list.add("michael");
        System.out.println("调用比较器之前的数据排序");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+"   ");
        }

        Collections.sort(list,new MyComparator("name","降序"));
        System.out.println("\n调用降序比较器之后的数据排序");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+"   ");
        }

        Collections.sort(list,new MyComparator("name","升序"));
        System.out.println("\n调用升序比较器之后的数据排序");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+"   ");
        }
    }
}




