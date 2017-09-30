package WORK.Java.Java803Collection.seconed;

/**
 * Created by Julis on 17/8/3.
 * User:Julis 落叶挽歌
 * Date:17/8/3
 * Time:下午4:29
 */
public class Book {
    private String num;
    private String bookName;
    private String type;
    private double price;

    public Book(String num, String bookName, String type, double price) {
        this.num = num;
        this.bookName = bookName;
        this.type = type;
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "编号:"+this.num+"  书名:"+this.bookName+"   类别:"+this.type+"    价格:"+this.price;
    }
}
