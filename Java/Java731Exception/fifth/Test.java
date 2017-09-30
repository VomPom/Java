package WORK.Java.Java731Exception.fifth;

/**
 * Created by Julis on 17/7/31.
 * User:Julis 落叶挽歌
 * Date:17/7/31
 * Time:下午2:13
 */
public class Test {
    public static void judge(String str){
        int flag=0;
        if(str.equals(""))
            try {
                throw new EmptyStringException("空字符串");
            } catch (EmptyStringException e) {
                e.printStackTrace();
            }

        for(int i=0;i<str.length();i++){
            for(int j=0;j<=9;j++){
                if(str.indexOf(String.valueOf(j))>=0){
                    flag=1;
                    try {
                        throw new IncludeNumberException("包含数字");
                    } catch (IncludeNumberException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            if(flag==1)
                break;
        }


    }
    public static void main(String []args){
            String string="asdg1235sd";
            judge(string);
    }
}
