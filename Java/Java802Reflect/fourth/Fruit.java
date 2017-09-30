package WORK.Java.Java802Reflect.fourth;

/**
 * Created by Julis on 17/8/2.
 * User:Julis 落叶挽歌
 * Date:17/8/2
 * Time:下午1:44
 */
public class Fruit {
    private int num;
    public Fruit(){}
    private Fruit(int num){
        this.num=num;
    }
    public void set(int num){
        this.num=num;
    }
    public int getNum(){
        return num;
    }
}
