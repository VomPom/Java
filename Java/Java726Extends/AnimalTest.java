package WORK.Java.Java726Extends;

/**
 * Created by Julis on 17/7/26.
 * User:Julis 落叶挽歌
 * Date:17/7/26
 * Time:下午1:21
 */
class Cat extends Animal{

    @Override
    public void shout() {
        System.out.println("猫叫");
    }
}
class Dog extends Animal{
    @Override
    public void shout() {
        System.out.println("狗叫");
    }
}
public class AnimalTest {
    public static void main(String []args){
        Animal animal=new Animal();
        animal.shout();
        Dog dog=new Dog();
        dog.shout();
        Cat cat=new Cat();
        cat.shout();
    }
}
