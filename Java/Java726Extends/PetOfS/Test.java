package WORK.Java.Java726Extends.PetOfS;

public class Test {

	public static void main (String[] args) {
		Animal a1=new Cat();
		a1.setName("猫猫");
		a1.setAge(2);
		a1.setColor("白色");
		a1.setPrice(500);
		Animal a2=new Dog();
		a2.setName("狗狗");
		a2.setAge(1);
		a2.setColor("黄色");
		a2.setPrice(600);
		Animal a3=new Pig();
		a3.setName("猪猪");
		a3.setAge(2);
		a3.setColor("粉色");
		a3.setPrice(400);
		Animal a4=new Mouse();
		a4.setName("苍苍");
		a4.setAge(1);
		a4.setColor("灰色");
		a4.setPrice(50);
		Animal a5=new Rabbit();
		a5.setName("兔兔");
		a5.setAge(1);
		a5.setColor("白色");
		a5.setPrice(30);
		Pet p=new Pet();
		p.setAnimal(new Animal[] {a1,a2,a3,a4,a5});
		p.get();
		System.out.println("----------------");
		p.select("猪猪");
	}
}
