package WORK.Java.Java727Interface.Fifth.aowin.define;

public class Computer {
	//连接usb设备的方法
	public void linkUsb(Usb usb) {
		usb.link();
	}
	//输入设备输入内容
	public void input(Input input,String str) {
		input.input(str);
	}
	

}
