package WORK.Java.Java723Object;

/**
 * Created by Julis on 17/7/24.
 * User:Julis 落叶挽歌
 * Date:17/7/24
 * Time:下午2:19
 */
public class User {
    private String userName;
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    User(){
        System.out.println("用户没有设置用户名和口令");
    }
    User(String name){
        System.out.println("用户设置用户名但没有设置口令");
        this.userName=name;
        System.out.println("用户名为:"+this.userName);
    }
    User(String name,String password){
        System.out.println("用户设置了用户名和口令");
        this.userName=name;
        this.password=password;
        System.out.println("用户名为:"+this.userName);
        System.out.println("口令为:"+this.password);
    }

    public void showUserName(){
        System.out.println("用户名为:"+this.userName);
    }
    public void changeUserName(String userName){
        System.out.println("原来的用户名为:"+this.userName);
        this.userName=userName;
        System.out.println("现在的用户名为:"+this.userName);
    }

}





