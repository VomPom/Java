package WORK.Java.Java720SetAndGet;

/**
 * Created by Julis on 17/7/20.
 * User:Julis 落叶挽歌
 * Date:17/7/20
 * Time:下午6:55
 */
public class TestSwap {
    private static void exange(int a,int b){//交换两个纯粹的变量
        int t;
        t=a;
        a=b;
        b=t;
    }
    private static void exangeObject(Purse object_A, Purse object_B){//交换两个对象
        Purse purse_temp;
        purse_temp=object_A;
        object_A=object_B;
        object_B=purse_temp;
    }
    private static void exangeObjectValue(Purse object_A,Purse object_B){//交换两个对象的值
        int t;
        t=object_A.getMoney();
        object_A.setMoney(object_B.getMoney());
        object_B.setMoney(t);
    }
    public static void main(String[]args){
        int a=235,b=1234;
        /*
        * 方法一:交换两个数值*/
        System.out.println("最开始的值为:a="+a+" b="+b);
        exange(a,b);
        System.out.println("交换后值为:a="+a+" b="+b);
        Purse purse_01=new Purse(100);
        Purse purse_02=new Purse(200);

         /*
        * 方法一:交换两个对象*/
        System.out.println("最开始两个钱包的money分别为:"+"A="+purse_01.getMoney()+" B:"+purse_02.getMoney());
        exangeObject(purse_01,purse_02);
        System.out.println("交换之后两个钱包的money分别为:"+"A="+purse_01.getMoney()+" B:"+purse_02.getMoney());
         /*
        * 方法一:交换两个对象的值*/
        System.out.println("最开始两个钱包的money分别为:"+"A="+purse_01.getMoney()+" B:"+purse_02.getMoney());
        exangeObjectValue(purse_01,purse_02);
        System.out.println("交换之后两个钱包的money分别为:"+"A="+purse_01.getMoney()+" B:"+purse_02.getMoney());
    }
}

class Purse{
    private int money;
    Purse(int money){
        this.money=money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

}







