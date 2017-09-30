package WORK.Java.Java727Interface.Sixth;

public class Test {
	public static void main(String[] args) {
		
		Concert c1 = new Concert();
		
		Performance[] pers = new Performance[2];
		pers[0] = new Singer();
		pers[1] = new Dancer();
		
		c1.guestPerfor(pers);
		
		
	}
}
