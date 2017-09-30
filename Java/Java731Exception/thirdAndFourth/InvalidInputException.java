package WORK.Java.Java731Exception.thirdAndFourth;

/**
 * Created by Julis on 17/7/31.
 * User:Julis 落叶挽歌
 * Date:17/7/31
 * Time:下午1:48
 */
public class InvalidInputException extends Exception{
    public InvalidInputException(){
        super("Your input was invalid");
    }
    public InvalidInputException(String msg){
        super(msg);
    }
}
