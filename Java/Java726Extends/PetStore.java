package WORK.Java.Java726Extends;

/**
 * Created by Julis on 17/7/26.
 * User:Julis 落叶挽歌
 * Date:17/7/26
 * Time:下午1:23
 */
public class PetStore {
    private Pet [] pets;
    public PetStore(Pet[] pets) {
        this.pets = pets;
    }
    public Pet[] getPets() {
        return pets;
    }

    public void setPets(Pet[] pets) {
        this.pets = pets;
    }
    public void showpets(){
        for(int i=0;i<pets.length;i++){
            System.out.println("宠物名字:"+pets[i].name+"  年龄:"+pets[i].age+"  颜色:"+pets[i].color+"  价格:"+pets[i].price);
        }
    }
    public void findPetByName(String name){
        int i;
        for(i=0;i<pets.length;i++){
            if(pets[i].name.equals(name))
            System.out.println("找到了!  宠物名字:"+pets[i].name+"  年龄:"+pets[i].age+"  颜色:"+pets[i].color+"  价格:"+pets[i].price);
        }
        if(i==pets.length){
            System.out.println("没有找到这个宠物");
        }
    }



}
