package WORK.Java.Java719Base;

/**
 * Created by Julis on 17/7/19.
 * User:Julis 落叶挽歌
 * Date:17/7/19
 * Time:下午3:33
 */
public class HelloJava {
    public static void main(String[]agrs){
        String str="Hello Java";
        String[] strArray=str.split(" ");//split以空格为标准生成字符串数组
        StringBuffer strBuffer=new StringBuffer();//StringBuffer对象对字符进行操作

        /*
        第一种输出方式:Java Hello
        * */
        for(int i=strArray.length-1;i>=0;i--){
            strBuffer.append(strArray[i]);
            if(i!=0){//由于split去掉了空格,这里应该加上,但数组最后不需要加空格
                strBuffer.append(" ");
            }
        }
        System.out.println(strBuffer.toString());//调用StringBuffer内置方法输出Java Hello

        /*
        第二种输出方式:avaJ olleH
        * */
        strBuffer.delete(0,strBuffer.length());//清空StringBuffer内容
        for(int i=str.length()-1;i>=0;i--){
            strBuffer.append(str.charAt(i));
        }
        System.out.println(strBuffer.toString());
    }
}


