package WORK.Java.Java719Base;

/**
 * Created by Julis on 17/7/19.
 * User:Julis 落叶挽歌
 * Date:17/7/19
 * Time:下午4:02
 */
public class Hundred {
    public static void printHundred(){
        for(int i=2;i<=100;){
            if(i%20==2){
                System.out.print(i);
            }else if(i%20==0){
                System.out.println();
            }else{
                System.out.print(","+i);
            }
            i+=2;
        }
    }
    public static void main(String[]agrs){
        printHundred();
    }
}
