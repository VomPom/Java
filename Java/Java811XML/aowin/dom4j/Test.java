
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import Java.Java811XML.aowin.model.Book;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;



public class Test {
	public static void main(String[] args) throws Exception {
		List<Book> books = new ArrayList<>();
		/*books.add(new Book(1, "think in java", "java", 108.0));
		books.add(new Book(2, "西游记", "文学", 58.0));
		books.add(new Book(3, "红楼梦", "文学", 118.0));
		books.add(new Book(4, "三国演义", "文学", 98.0));
		write(books);*/
		
		
		books = read();
		System.out.println(books.size());
	}
	/**
	 * 使用dom4j将java对象集合写入xml文件
	 * @param books
	 * @throws Exception 
	 */
	public static void write(List<Book> books) throws Exception {
		//1.先创建document对象
		 Document doc = DocumentHelper.createDocument();
		 //给doc添加子元素books
		Element bs = doc.addElement("books");
		
		for(int i=0;i<books.size();i++) {
			Book b = books.get(i);
			//给books元素添加子元素book
			Element book = bs.addElement("book");
			book.addElement("bookname").setText(b.getBookname());
			book.addElement("catalog").setText(b.getCatalog());
			book.addElement("price").setText(b.getPrice().toString());
			//添加属性
			book.addAttribute("bookid", b.getBookid().toString());
		}
		
		
		//写入文件
		OutputFormat print = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/com/aowin/dom4j/books.xml"),print);
		
		writer.write(doc);//输出
		writer.flush();
		writer.close();
	}
	
	public static List<Book> read() throws Exception{
		ArrayList<Book> books = new ArrayList<>();
		//1.创建解析器对象
		SAXReader sr = new SAXReader();
		//解析xml文件为Document对象
		Document doc = sr.read(new File("src/com/aowin/dom4j/books.xml"));
		
		//获取根元素 books
		Element root = doc.getRootElement();
		//所有的book元素集合
		List<Element> book = root.elements();
		for(int i=0;i<book.size();i++) {
			Book b = new Book();
			
			Element bk = book.get(i);//一个book元素
			
			b.setBookid(Integer.parseInt(bk.attribute("bookid").getText()));
			
			//使用迭代器方法返回book的子元素集合
			Iterator<Element> it = bk.elementIterator();
			while(it.hasNext()) {
				 Element e = it.next();
				switch (e.getName()) {
					case "bookname":
						b.setBookname(e.getText());
						break;
					case "catalog":
						b.setCatalog(e.getText());
						break;
					case "price":
						b.setPrice(Double.parseDouble(e.getText()));
						break;

				default:
					break;
				}
			}
			
			books.add(b);
		}
		
		return books;
	}

}
