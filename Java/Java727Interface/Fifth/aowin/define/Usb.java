package WORK.Java.Java727Interface.Fifth.aowin.define;

public interface Usb {
	
	
	//成员属性 public static final 声明的 修饰符可以省略
	public static final String VERSION = "3.0";
	
	/**
	 * 抽象方法 没有方法体
	 * 抽象方法声明 默认使用public abstract
	 */
	void link();
	
	//静态方法
	public static void chargeEle() {
		System.out.println("usb接口可以用来充电");
	}
	
	//default方法
	public default void linkU() {
		System.out.println("插入u盘");
	}

}
