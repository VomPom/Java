package WORK.Java.Java812Thread.third;

/**
 * Created by Julis on 17/8/12.
 * User:Julis 落叶挽歌
 * Date:17/8/12
 * Time:下午6:13
 */
public class Test {
    public static void main(String []args){
        Animal animal=new Animal();
        for (int i=0;i<5;i++){
            new AnimalThread(animal).start();
        }
    }
}
