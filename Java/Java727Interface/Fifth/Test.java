package WORK.Java.Java727Interface.Fifth;

/**
 * Created by Julis on 17/7/27.
 * User:Julis 落叶挽歌
 * Date:17/7/27
 * Time:下午2:08
 */
public class Test {
    public static void main(String[]args){
        Computer computer=new Computer();
        DVD dvd=new DVD() {
            @Override
            public void playDVD() {

            }
        };
        USB usb=new USB() {
            @Override
            public void useUSB() {

            }
        };
        System.out.println(computer.getClass());
        System.out.println(dvd.getClass());
        System.out.println(usb.getClass());
        dvd=DVD.class.cast(computer);
        usb=USB.class.cast(computer);
        System.out.println(dvd.getClass());
        System.out.println(usb.getClass());
    }
}





