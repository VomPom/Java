package WORK.Java.Java725Construction;

/**
 * Created by Julis on 17/7/25.
 * User:Julis 落叶挽歌
 * Date:17/7/25
 * Time:下午1:46
 */
public class UtlitsString {
    public static String trans(String string){
        if(string==""||string.equals(null)){
            return "字符串为空";
        }else{
            return string.toUpperCase();
        }
    }

}
