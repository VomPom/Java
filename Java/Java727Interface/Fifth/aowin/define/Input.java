package WORK.Java.Java727Interface.Fifth.aowin.define;
/**
 * 输入接口
 * @author Administrator
 *
 */
public interface Input {
	/**
	 * 输入一个内容
	 * @param str
	 */
	public void input(String str);
	
	//default方法
	public default void linkU() {
		System.out.println("连接usb接口的输入设备");
	}
}
