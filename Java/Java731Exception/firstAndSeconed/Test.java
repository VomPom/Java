package WORK.Java.Java731Exception.firstAndSeconed;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Julis on 17/7/31.
 * User:Julis 落叶挽歌
 * Date:17/7/31
 * Time:下午1:37
 */
public class Test {
    public static void main(String []args){
        Scanner scanner=new Scanner(System.in);
        int []numbers=new int[5];
        System.out.println("请依次输入"+numbers.length+"个数字");
        for(int i=0;i<numbers.length;i++) {
            try {
                numbers[i] = scanner.nextInt();
                        if(!Duplicate(numbers,numbers[i],i)){
                            i--;
                        }
            } catch (InputMismatchException e) {
                System.err.println("输入的数字有错误");
                i--;
                scanner.next();
            }
        }
        System.out.println("请输入要查找的数字");
        int findNum=scanner.nextInt();//输入要查找的数字
        findByNum(numbers,findNum);//通过数字找下标
        System.out.println("请输入要查找的下标");
         int findIndex=scanner.nextInt();//输入要查找的下标
        findByIndex(numbers,findIndex);//通过下标找数字
    }
    public static boolean Duplicate(int []number,int num,int limit) {

        for(int j=0;j<limit;j++){
            if(number[j]==num) {
                try {
                    throw new DuplicateValueException("有重复输入");
                } catch (DuplicateValueException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;

    }
    public static void findByNum(int []number,int num)  {
        int i;
        for(i=0;i<number.length;i++){
            if(num==number[i]){
                System.out.println("数字"+num+"的下标为:"+i);
                break;
            }
        }
        if(i==number.length){
            try {
                throw new NumberNotFoundException("数字没有找到");
            } catch (NumberNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public static void findByIndex(int []number,int index){
        int i;
        if(index<0||index>=number.length)
            throw new ArrayIndexOutOfBoundsException("数组越界");
        else{
            for(i=0;i<number.length;i++){
                if(index==number[i]){
                    System.out.println("下标为"+index+"的数字为:"+number[i]);
                    break;
                }
            }
            if(i==number.length){
                try {
                    throw new NumberNotFoundException("数字没有找到");
                } catch (NumberNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



