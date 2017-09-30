package WORK.Java.Java812Thread.example;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Shop s = new Shop();
		
		for(int i=0;i<10;i++) {
			Random r = new Random();
			int num = r.nextInt(100);
			new Sell(s, num).start();
			new Stock(s, num).start();					
	}
}
}
