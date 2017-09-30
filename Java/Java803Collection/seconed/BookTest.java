package WORK.Java.Java803Collection.seconed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Julis on 17/8/3.
 * User:Julis 落叶挽歌
 * Date:17/8/3
 * Time:下午4:33
 */
public class BookTest {
    public static void main(String []args){
        List<Book> bookList=new ArrayList<>();
        Book book1=new Book("125234","Java编程思想","程序",59.5);
        Book book2=new Book("123666","天空","文学",19.5);
        Book book3=new Book("223606","三国志","历史",45.0);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        showBooks(bookList);
        addBook(bookList);
        showBooks(bookList);
        delBook(bookList,"123666");
        showBooks(bookList);
    }
    public static void delBook(List<Book> bookList,String num){
        Iterator<Book> iterable=bookList.iterator();
        Book book=null;
        while (iterable.hasNext()){
            book=iterable.next();
            if(book.getNum().equals(num)){
                iterable.remove();
            }
        }
    }
    public static void showBooks(List<Book> bookList){
        Iterator<Book> iterable=bookList.iterator();
        while (iterable.hasNext()){
            System.out.println(iterable.next());
        }
    }
    public static void addBook(List<Book> bookList){
        Scanner scanner=new Scanner(System.in);
        String num;
        String bookName;
        String type;
        double price;
        String string;
        System.out.println("请依此输入编号\\书名\\类型\\价格");
        string=scanner.nextLine();
        String []str=string.split(" ");
        num=str[1];
        bookName=str[2];
        type=str[2];
        price=Double.parseDouble(str[3]);
        Book book=new Book(num,bookName,type,price);
        bookList.add(book);

    }
}





