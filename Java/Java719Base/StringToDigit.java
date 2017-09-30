package WORK.Java.Java719Base;

/**
 * Created by Julis on 17/7/19.
 * User:Julis 落叶挽歌
 * Date:17/7/19
 * Time:下午4:07
 */
public class StringToDigit {
    private static int isTrue(String string){
        boolean isDigit=true;
        char []chars=string.toCharArray();
        for(int i=0;i<chars.length;i++){
            int num = (int)chars[i];
            if(num<48||num>57){//通过ASCII码判断是否为数字,数字对ASCII码为48~57
                isDigit=false;
                break;
            }
        }
        if(isDigit==true){
            return Integer.parseInt(string);
        }else
            return -1;
    }
    public static void main(String []args){
        String string="1234567890";//注意函数返回值对范围
        System.out.println("结果为:"+isTrue(string));
    }
}
