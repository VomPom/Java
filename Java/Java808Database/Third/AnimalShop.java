package WORK.Java.Java808Database.Third;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Julis on 17/8/9.
 * User:Julis 落叶挽歌
 * Date:17/8/9
 * Time:下午3:19
 */
public class AnimalShop {

    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);

        while(true){
            System.out.println("请输入命令:\n1`查看宠物信息\n2`搜索宠物\n3`购买宠物\n4`修改价格\n5`EXIT");
            int option=scanner.nextInt();
            if(option==1)
                showAll();
            else if(option==2)
                findByColorOrName();
            else if(option==3)
                buyPet();
            else if(option==4)
             changePrice();
            else if(option==5)
                break;
            else
                System.out.println("输入错误");
        }


    }
    public static void runMysql(String sql){
        Connection connection=getConnectino();
        Statement statement= null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.print("ID:"+resultSet.getString("id")+" ");
                System.out.print("姓名:"+resultSet.getString("name")+" ");
                System.out.print("密码:"+resultSet.getString("color")+" ");
                System.out.print("年龄:"+resultSet.getString("age")+" ");
                System.out.print("价格:"+resultSet.getString("price")+" ");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void buyPet(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要购买的ID");
        int id=scanner.nextInt();
        String sql="DELETE FROM animal WHERE id="+id;
        Connection connection=getConnectino();
        Statement statement= null;
        try {
            statement = connection.createStatement();
            int cout=statement.executeUpdate(sql);
            if(cout!=0)
                System.out.println("成功购买一只宠物");
            else
                System.err.println("没找到折尺宠物");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void changePrice(){
        System.out.println("请输入要修改的ID");
        Scanner scanner=new Scanner(System.in);
        int id=scanner.nextInt();
        System.out.println("请输入要改的价格");
        double newPrice=scanner.nextDouble();
        String sql="UPDATE animal set price="+newPrice+"where id="+id;
        Connection connection=getConnectino();
        Statement statement= null;
        try {
            statement = connection.createStatement();
            int cout=statement.executeUpdate(sql);
            if(cout!=0)
                System.out.println("成功修改");
            else
                System.err.println("修改失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void findByColorOrName(){
        System.out.println("请出入宠物名字或者颜色");
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String sql="SELECT *FROM animal WHERE name='"+str+"' or color='"+str+"'";
        runMysql(sql);
    }

    public static void showAll(){
        String sql="SELECT *FROM animal";
        runMysql(sql);
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
}








