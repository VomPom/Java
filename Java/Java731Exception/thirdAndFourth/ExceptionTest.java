package WORK.Java.Java731Exception.thirdAndFourth;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Julis on 17/7/31.
 * User:Julis 落叶挽歌
 * Date:17/7/31
 * Time:下午1:59
 */
public class ExceptionTest {
    public static void main(String []args) throws InvalidInputException {
        Scanner sc=new Scanner(System.in);
        try {
            int number=sc.nextInt();
            if(number<=0){
                throw new InvalidInputException("You must be enter a positive number");
            }
        }catch (InputMismatchException e){

        }


    }
}
