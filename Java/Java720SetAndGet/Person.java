package WORK.Java.Java720SetAndGet;

/**
 * Created by Julis on 17/7/20.
 * User:Julis 落叶挽歌
 * Date:17/7/20
 * Time:下午1:08
 */
class Person {
    private String name;
    private String sex;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello");
    }
}
