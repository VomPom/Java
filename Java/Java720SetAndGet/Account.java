package WORK.Java.Java720SetAndGet;

import java.util.Date;

/**
 * Created by Julis on 17/7/20.
 * User:Julis 落叶挽歌
 * Date:17/7/20
 * Time:下午1:19
 */
public class Account {
    private int id;
    private String name;
    private Date date;
    private int money;
    private void saveMoney(int money){
        System.out.println("存了"+money+"元");
    }
    private void getMoney(int money){
        System.out.println("取了"+money+"元");
    }
    private void showName(){
        System.out.println("用户名为:"+this.name);
    }
    private void showID(){
        System.out.println("ID为:"+this.id);
    }
    private void showMoney(){
        System.out.println("还有"+this.money+"元");
    }

}
