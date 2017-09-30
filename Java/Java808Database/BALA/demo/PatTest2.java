package WORK.Java.Java808Database.BALA.demo;

import WORK.Java.Java808Database.BALA.Dao.PatDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class PatTest2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Pat p = new Pat();

		try {
			ArrayList<Pat> pat = PatDao.select(p);
			System.out.println(pat);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		while (true) {
			System.out.println("请选择要执行的操作：1.根据颜色查找   2.根据名称查找   3.购买宠物   4.修改宠物价格");

			int i = s.nextInt();
			if (i == 1) {
				System.out.println("输入颜色：");
				String color = s.next();
				p.setColor(color);
				try {
					ArrayList<Pat> pat = PatDao.select1(p);
					System.out.println(pat);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (i == 2) {
				System.out.println("输入名称：");
				String name = s.next();
				p.setName(name);
				try {
					ArrayList<Pat> pat = PatDao.select2(p);
					System.out.println(p);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (i == 3) {
				System.out.println("输入购买的宠物名称：");
				String name = s.next();
				try {
					int n = PatDao.delete(name);
					if (n == 0) {
						System.out.println("购买失败，找不到该宠物");
					} else {
						System.out.println("购买成功");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
			if (i == 4) {
				System.out.println("输入修改的宠物名称：");
				String name = s.next();
				System.out.println("输入修改价格为：");
				double price = s.nextDouble();
				p.setName(name);
				p.setPrice(price);
				try {
					int n = PatDao.update(p);
					if (n == 0) {
						System.out.println("修改失败，找不到该宠物");
					} else {
						System.out.println("修改成功");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
