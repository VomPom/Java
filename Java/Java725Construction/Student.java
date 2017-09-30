package WORK.Java.Java725Construction;

/**
 * Created by Julis on 17/7/25.
 * User:Julis 落叶挽歌
 * Date:17/7/25
 * Time:下午1:17
 */
public class Student {
    public String name;
    public void setName(String name) {
        this.name = name;
    }
    Student(String name){
        this.name=name;
    }
    Student(){
        System.out.println("初始化没有设置名字");
    }

}
