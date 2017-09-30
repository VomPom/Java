package WORK.Java.Java821Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Julis on 17/8/21.
 * User:Julis 落叶挽歌
 * Date:17/8/21
 * Time:上午10:24
 */
public class TestForRegex {
    public static void main(String []args){
        String content = "21351_15@qq.com";
        String emailParten="^[a-zA-Z_0-9-]{1,}@(([a-zA-z0-9]*){1,}\\.)(com){1}";
        Pattern p=Pattern.compile(emailParten);
        Matcher eamilMMatcher=p.matcher(content);
        System.out.println("Emali:"+eamilMMatcher.find());


        String password = "123523dfdhsA";
        String passwordParten="(\\w{6,18})([A-Z]+)";
        Pattern pattern2=Pattern.compile(passwordParten);
        Matcher matcher2=pattern2.matcher(password);
        System.out.println("Password:"+matcher2.find());

        String phoneNumber="15968735367";
        String phoneParten="^[1](\\d{10})";

        Pattern pattern3=Pattern.compile(phoneParten);
        Matcher matcher3=pattern3.matcher(phoneNumber);
        System.out.println("Phone:"+matcher3.find());


    }
}
