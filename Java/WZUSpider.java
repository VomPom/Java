package Java;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Julis on 17/8/29.
 * User:Julis 落叶挽歌
 * Date:17/8/29
 * Time:上午9:06
 */
public class WZUSpider {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();    //获取开始时间
        for(int i=307497;i<318584;i++){
            System.out.println(String.format("%2f",(i-307497.0)/11087.0)+"%");
            getContent(i);
        }
        long endTime = System.currentTimeMillis();    //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }
    public static void printInfo(StringBuilder htmlContent){
        Matcher mSchool = Pattern.compile("<td width=\"80\">学校名称：</td>                            <td width=\"190\"><span class=\"textspan\">([\\S\\s]*?)</span></td>").matcher(htmlContent);
        Matcher mName = Pattern.compile("<td width=\"80\">考生姓名：</td>                               <td colspan=\"3\"><span class=\"textspan2\">([\\S\\s]*?)</span></td>").matcher(htmlContent);
        Matcher mTest = Pattern.compile("<td width=\"80\">应试科目：</td>                            <td><span class=\"textspan\">([\\S\\s]*?)</span></td>").matcher(htmlContent);
        Matcher mID = Pattern.compile("<td width=\"70\">准考证号：</td>                            <td><span class=\"textspan\">([\\S\\s]*?)</span></td>").matcher(htmlContent);

        while(mSchool.find()){
            System.out.println("学校:"+mSchool.group(1));

        }
        while(mName.find()){
            System.out.println("姓名:"+mName.group(1));

        }
        while(mTest.find()){
            System.out.println("科目:"+mTest.group(1));

        }
        while(mID.find()){
          System.out.println("ID:"+mID.group(1));

        }
    }
    public static void getContent(int i){
        // 定义即将访问的链接

        String url = "http://jwc.wmu.edu.cn/admticketadmmore.aspx?ID="+i;
        // 定义一个字符串用来存储网页内容
        StringBuilder result = new StringBuilder();
        // 定义一个缓冲字符输入流
        BufferedReader in = null;
        try {
            // 将string转成url对象
            URL realUrl = new URL(url);
            // 初始化一个链接到那个url的连接
            URLConnection connection = realUrl.openConnection();
            // 开始实际的连接
            connection.connect();
            // 初始化 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            // 用来临时存储抓取到的每一行的数据
            String line;
            while ((line = in.readLine()) != null) {
                //遍历抓取到的每一行并将其存储到result里面
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        printInfo(result);
    }
}
