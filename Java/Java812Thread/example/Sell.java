package WORK.Java.Java812Thread.example;

public class Sell extends Thread {
	private Shop s ;
	private int num;
	

	public Sell(Shop s,int num) {
		super();
		this.s = s;
		this.num = num;
	}

	@Override
	public void run() {
		s.sell(num);
	}
	

}
