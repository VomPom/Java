package WORK.Java.Java803Collection.fourth;

/**
 * Created by Julis on 17/8/3.
 * User:Julis 落叶挽歌
 * Date:17/8/3
 * Time:下午5:21
 */
public class Fruit {
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
       if(obj instanceof Fruit){
           Fruit fruit=(Fruit)obj;
           if(this.name.equals(fruit.name)){
               return true;
           }
       }
    return false;
}

    @Override
    public int hashCode() {

//        if(name!=null){
//            return name.hashCode();
//        }
//        else
//            return 0;
       return name.hashCode();
    }
}



