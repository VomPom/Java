package Java.Management.personalmanager.util;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTable;


import Java.Management.personalmanager.model.Person;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;




public class Dom4j {

	public static void write(JTable table,File file) throws Exception {
		//1.先创建document对象
		 Document doc = DocumentHelper.createDocument();
		 //给doc添加子元素people
		Element bs = doc.addElement("people");
		
		int n = table.getRowCount();
		for(int i=0;i<n;i++) {
			//Person p = people.get(i);
			//给people元素添加子元素person
			Element person = bs.addElement("person");
			person.addElement("id").setText(table.getValueAt(i, 0).toString());
			person.addElement("name").setText(table.getValueAt(i, 1).toString());
			person.addElement("sex").setText(table.getValueAt(i, 2).toString());
			person.addElement("department").setText(table.getValueAt(i, 3).toString());
			person.addElement("salary").setText(table.getValueAt(i, 4).toString());
		}
		
		
		//写入文件
		OutputFormat print = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream(file.getAbsolutePath()),print);
		
		writer.write(doc);//输出
		writer.flush();
		writer.close();
	}
	
	public static ArrayList<Person> read(File file) throws Exception{
		ArrayList<Person> people = new ArrayList<>();
		//1.创建解析器对象
		SAXReader sr = new SAXReader();
		//解析xml文件为Document对象
		Document doc = sr.read(new File(file.getAbsolutePath()));
		
		//获取根元素 people
		Element root = doc.getRootElement();
		//所有的book元素集合
		List<Element> person = root.elements();
		for(int i=0;i<person.size();i++) {
			Person p = new Person();
			
			Element per = person.get(i);//一个book元素
			
			//使用迭代器方法返回book的子元素集合
			Iterator<Element> it = per.elementIterator();
			while(it.hasNext()) {
				 Element e = it.next();
				switch (e.getName()) {
				case "id":
					p.setId(Integer.valueOf(e.getText()));
					break;	
				case "name":
						p.setName(e.getText());
						break;
					case "sex":
						p.setSex(e.getText());
						break;
					case "department":
						p.setDepartment(e.getText());
						break;
					case "salary":
						p.setSalary(Integer.valueOf(e.getText()));
						break;
				default:
					break;
				}
			}
			
			people.add(p);
		}
		
		return people;
	}

	public static class MyFilter implements FileFilter{

		@Override
		public boolean accept(File pathname) {
			return pathname.getName().endsWith(".xml");
		}
		
	}
	
	
}
