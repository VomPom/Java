package WORK.Java.Java725Construction;

/**
 * Created by Julis on 17/7/25.
 * User:Julis 落叶挽歌
 * Date:17/7/25
 * Time:下午2:29
 */
public class Box {
    private Computer[] computers;
    Box(Computer [] computers){
        this.computers=computers;
    }
    public void printAllComputer(){
        System.out.println("牌子为:");
        for(Computer computer :computers){
            System.out.println(computer.getBrand());
        }
    }
}
