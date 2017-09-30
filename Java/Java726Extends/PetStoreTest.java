package WORK.Java.Java726Extends;

/**
 * Created by Julis on 17/7/26.
 * User:Julis 落叶挽歌
 * Date:17/7/26
 * Time:下午1:26
 */
public class PetStoreTest {
    public static void main(String []args){
        String[] petsName={"阿黄","小黑","咪咪","唧唧","喳喳"};
        int[] petsAge={2,3,5,3,1};
        String[] petsColor={"红","白","绿","紫","黑"};
        double[] petsPrice={1234.5,2341,2150,5600,1470};
        Pet[]pets=new Pet[5];
        for(int i=0;i<pets.length;i++){
            pets[i]=new Pet(petsName[i],petsAge[i],petsColor[i],petsPrice[i]);
        }
        PetStore petStore=new PetStore(pets);
        petStore.showpets();
        petStore.findPetByName("阿狗");
        petStore.findPetByName("咪咪");
    }
}


