package Java.Java811XML.aowin.model;

public class Book {
	private Integer bookid;//作为xml的属性
	private String bookname;
	private String catalog;
	private Double price;
	
	public Book() {
		super();
	}
	public Book(Integer bookid, String bookname, String catalog, Double price) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.catalog = catalog;
		this.price = price;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}
