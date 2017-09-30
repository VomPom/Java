package WORK.Java.Java803Collection.first;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Julis on 17/8/3.
 * User:Julis 落叶挽歌
 * Date:17/8/3
 * Time:下午4:15
 */
public class RockTest {
    public static void main(String []args){
        String []rockName={"小石头","大石头","怪石头","好看的石头","彩色石头"};
        Rock []rocks=new Rock[rockName.length];
        Set<Rock> rockSet=new HashSet<>();
        for(int i=0;i<rockName.length;i++){
            rocks[i]=new Rock(rockName[i]);
            rockSet.add(rocks[i]);
        }
        Iterator<Rock> iterable=rockSet.iterator();
        while (iterable.hasNext()){
            System.out.println(iterable.next());

        }
    }
}









