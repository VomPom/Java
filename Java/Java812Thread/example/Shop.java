package WORK.Java.Java812Thread.example;

import java.util.ArrayList;

public class Shop {
private ArrayList<Object> goods = new ArrayList<>();
	
	public static final int MAX = 100;//最大库存数
	
	public void stock(int num) {
		synchronized (goods) {
			while(goods.size() + num > MAX) {
				System.out.println("[进货]->当前库存"+goods.size()+",当前进货"+num+",请等待");
				try {
					goods.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int i=0;i<num;i++) {
				goods.add(new Object());
			}
			System.out.println("[进货]->成功进货"+num+"，当前库存："+goods.size());
			goods.notifyAll();
		}
	}
	
	public void sell(int num) {
		synchronized (goods) {
			while(num > goods.size()) {
				System.err.println("[售货]->当前库存数"+goods.size()+",售货数："+num+",请等待");
				try {
					goods.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int i=num-1;i>=0;i--) {
				goods.remove(0);
			}
			System.err.println("[售货]-->售货成功"+num+",当前库存数为："+goods.size());
			goods.notifyAll();
		}
	}
	

}
