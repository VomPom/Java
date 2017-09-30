package WORK.Java.Java803Collection.seconed.LiBook;

public class Book {

	private int id;
	private String name;
	private String kind;
	private double price;
	
	@Override
	public String toString() {
		return "Book [编号=" + id + ", 书名=" + name + ", 类别=" + kind + ", 价格=" + price + "]";
	}

	public Book() {
		super();
	}

	public Book(int id, String name, String kind, double price) {
		super();
		this.id = id;
		this.name = name;
		this.kind = kind;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
