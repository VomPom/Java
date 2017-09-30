package WORK.Java.Java725Construction;

/**
 * Created by Julis on 17/7/25.
 * User:Julis 落叶挽歌
 * Date:17/7/25
 * Time:下午2:29
 */
public class BoxTest {
    public static void main(String []args){
        String [] name={"Lenovo","IBM","Sony","Samsung","Mac"};
        Computer [] computers =new Computer[5];
        for(int i=0;i<computers.length;i++){
            computers[i]=new Computer(name[i]);
        }
        Box box=new Box(computers);
        box.printAllComputer();
    }
}
