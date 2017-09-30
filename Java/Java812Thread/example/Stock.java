package WORK.Java.Java812Thread.example;

public class Stock extends Thread {
	private Shop s ;
	private int num;
	public Stock(Shop s, int num) {
		super();
		this.s = s;
		this.num = num;
	}
	
	@Override
	public void run() {
		s.stock(num);
	}

}
