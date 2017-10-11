package Java.Java811XML.aowin.dom;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import Java.Java811XML.aowin.model.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 使用DOM解析器 生成xml文档 和解析xml文档
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) throws Exception {
		/*List<Book> books = new ArrayList<>();
		books.add(new Book(1, "think in java", "java", 108.0));
		books.add(new Book(2, "西游记", "文学", 58.0));
		books.add(new Book(3, "红楼梦", "文学", 118.0));
		books.add(new Book(4, "三国演义", "文学", 98.0));
		write(books);*/
		
		List<Book> books = readTagname();
		System.out.println(books.size());
		
	}
	
	/**
	 * 读取一个xml文件 将其里面的内容解析为java的list对象
	 * @return
	 * @throws Exception 
	 */
	public static List<Book> read() throws Exception{
		ArrayList<Book> list = new ArrayList<>();
		
		//创建Dom解析器
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//解析一个xml的文件 返回一个 Document对象
		Document doc = builder.parse(new File("src/com/aowin/dom/books.xml"));
		
		//解析方式 一  使用根标签解析
		//获取根目录
		Element root = doc.getDocumentElement();
		NodeList book = root.getChildNodes();//返回根标签的子标签列表
		//System.out.println(book.getLength());//获取NodeList的长度
		for(int i=0;i<book.getLength();i++) {
			Node b = book.item(i);
			//获取node的结点类型 对应Node接口中的常量
			//System.out.println(b.getNodeType());
			if(Node.ELEMENT_NODE == b.getNodeType()) {//book标签
				Book b1 = new Book();
				b1.setBookid(Integer.parseInt(b.getAttributes().item(0).getNodeValue()));//属性
				//获取book元素的子节点（bookname ,catalog,price）
				NodeList nodes = b.getChildNodes();
				for(int j=0;j<nodes.getLength();j++) {
					Node n = nodes.item(j);
					if(Node.ELEMENT_NODE == n.getNodeType()) {
						switch (n.getNodeName()) {
							case "bookname":
								b1.setBookname(n.getTextContent());
								break;
							case "catalog":
								b1.setCatalog(n.getTextContent());
								break;
							case "price":
								b1.setPrice(Double.parseDouble(n.getTextContent()));
								break;
								
							default:
								break;
						}
					}
				}
				list.add(b1);
			}
		}
		return list;
	}
	/**
	 * 根据标签名称解析xml
	 * @return
	 * @throws Exception
	 */
	public static List<Book> readTagname() throws Exception{
		ArrayList<Book> list = new ArrayList<>();
		
		//创建Dom解析器
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//解析一个xml的文件 返回一个 Document对象
		Document doc = builder.parse(new File("src/com/aowin/dom/books.xml"));
		//根据标签名称获取元素对象 所有的book标签
		NodeList books = doc.getElementsByTagName("book");
		for(int i=0;i<books.getLength();i++) {
			Node book = books.item(i);
			
			Book b = new Book();
			//设置属性值
			b.setBookid(Integer.parseInt(book.getAttributes().item(0).getNodeValue()));
			
			//bookname catalog price
			NodeList nodes = book.getChildNodes();
			for(int j=0;j<nodes.getLength();j++) {
				Node n = nodes.item(j);
				//如果结点类型为Element类型
				if(Node.ELEMENT_NODE == n.getNodeType()) {
					switch (n.getNodeName()) {
					case "bookname":
						b.setBookname(n.getTextContent());
						break;
					case "catalog":
						b.setCatalog(n.getTextContent());
						break;
					case "price":
						b.setPrice(Double.parseDouble(n.getTextContent()));

					default:
						break;
					}
				}
			}
			list.add(b);
			
		}
		
		return list;
	}
	
	/**
	 * 将list的book对象记转化为xml格式存放在xml文件中
	 * @param books
	 * @throws Exception 
	 */
	public static void write(List<Book> books) throws Exception {
		//1.创建dom解析器
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		//2.创建文档对象模型
		Document doc = builder.newDocument();
		//3.创建Element元素对象
		Element root = doc.createElement("books");//创建根标签
		
		//创建book子标签
		for(int i=0;i<books.size();i++) {
			Book b = books.get(i);
			
			Element book = doc.createElement("book");
			//创建子标签
			Element bookname = doc.createElement("bookname");
			Element catalog = doc.createElement("catalog");
			Element price = doc.createElement("price");
			
			//标签赋值
			bookname.setTextContent(b.getBookname());
			catalog.setTextContent(b.getCatalog());
			price.setTextContent(b.getPrice().toString());
			//给book标签添加属性
			book.setAttribute("bookid", b.getBookid().toString());
			
			//组合标签之间的关系
			book.appendChild(bookname);
			book.appendChild(catalog);
			book.appendChild(price);
			
			root.appendChild(book);
		}
		
		//4.写入文件
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		//将xml文档写入文件中
		Source xmlSource = new DOMSource(root);//创建一个dom的源对象
		Result outputTarget = new StreamResult(new File("src/com/aowin/dom/books.xml"));
		//输出文件
		tf.transform(xmlSource, outputTarget);
	}

}
