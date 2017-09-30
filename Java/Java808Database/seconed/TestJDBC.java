package WORK.Java.Java808Database.seconed;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Julis on 17/8/8.
 * User:Julis 落叶挽歌
 * Date:17/8/8
 * Time:下午4:02
 */
public class TestJDBC {
    public static void main(String []agrs){

        queryData();

    }

    public static Connection getConnectino(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//注册驱动程序
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hello","root","root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void queryData() {
        Scanner scanner=new Scanner(System.in);
        int rowCount=0;
        System.out.println("请输入用户名");
        String user=scanner.nextLine();
        System.out.println("请输入密码:");
        String pwd=scanner.nextLine();
        String sql="SELECT *FROM user WHERE username='"+user+"' and password='"+pwd+"'";
        Connection connection=getConnectino();
        Statement statement= null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                rowCount++;
                System.out.print("姓名:"+resultSet.getString("username")+" ");
                System.out.print("密码:"+resultSet.getString("password")+" ");
                System.out.print("性别:"+resultSet.getString("sex")+" ");
                System.out.print("生日:"+resultSet.getString("birth")+" ");
                System.out.print("地址:"+resultSet.getString("address")+" ");
                System.out.print("联系方式:"+resultSet.getString("tel")+" ");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(rowCount==0){

            System.out.println("我们没有找到这个数据,所以 您是否注册:y/n");
            try {
                String option=scanner.nextLine();
                if(option.equals("y")){
                    register();
                }else if (option.equals("n")){
                    System.out.println("谢谢!");
                    return;
                }
            }catch (InputMismatchException e){
                System.err.println("输入错误");
            }

        }

    }

    private static void register() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名");
        String user=scanner.nextLine();
        System.out.println("请输入密码:");
        String pwd=scanner.nextLine();
        System.out.println("请输入性别:");
        String sex=scanner.nextLine();
        System.out.println("请输入生日:");
        String bir=scanner.nextLine();
        System.out.println("请输入地址:");
        String add=scanner.nextLine();
        System.out.println("请输入手机:");
        String tel=scanner.nextLine();

        Connection connection=getConnectino();
        String sql="INSERT INTO user(id,username,password,sex,birth,address,tel)"
                +"VALUES(null,\""
                +user+"\",\""
                +pwd+"\",\""
                +sex+"\",\""
                +bir+"\",\""
                +add+"\",\""
                +tel+"\")";

        try {
            Statement statement=connection.createStatement();
            int count= statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}




