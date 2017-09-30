package WORK.Java.Management.data;
import WORK.Java.Management.bean.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Julis on 17/8/11.
 * User:Julis 落叶挽歌
 * Date:17/8/11
 * Time:下午10:31
 */
public class DataAndXML {
    public static ArrayList<Person>initData(){//从数据库获取数据
        ArrayList<Person> persons=new ArrayList<>();
        try {
            persons=PersonDao.getAllData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }
    public static ArrayList<Person> XMLToData(String filePath) throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Person> members = new ArrayList<>();
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document doc=builder.parse(new File(filePath));
        Element root=doc.getDocumentElement();
        NodeList member=root.getChildNodes();
        for(int i=0;i<member.getLength();i++){
            Node m=member.item(i);
            if(Node.ELEMENT_NODE == m.getNodeType()) {
                Person member1 = new Person();
               // member1.setId(Integer.parseInt(m.getAttributes().item(0).getNodeValue()));
                NodeList nodes = m.getChildNodes();
                for(int j=0;j<nodes.getLength();j++) {
                    Node n = nodes.item(j);
                    if(Node.ELEMENT_NODE == n.getNodeType()) {
                        switch (n.getNodeName()) {
                            case "ID":
                                member1.setId(Integer.parseInt(n.getTextContent()));
                            case "Name":
                                member1.setName(n.getTextContent());
                                break;
                            case "Sex":
                                member1.setSex(n.getTextContent());
                                break;
                            case "Department":
                              member1.setDepartment(n.getTextContent());
                                break;
                            case "Salary":
                                member1.setSalary(Float.parseFloat(n.getTextContent()));
                                break;
                            default:
                                break;
                        }
                    }
                }
                members.add(member1);
            }
        }


        return members;
    }


    public static void write(ArrayList<Person> persons) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document doc=builder.newDocument();

        Element root=doc.createElement("person");

        for(int i=0;i<persons.size();i++){
            Person person=persons.get(i);
            Element element=doc.createElement("persons");
            Element ID=doc.createElement("ID");
            Element name=doc.createElement("Name");
            Element sex=doc.createElement("Sex");
            Element department=doc.createElement("Department");
            Element salary=doc.createElement("Salary");

            ID.setTextContent(String.valueOf(person.getId()));
            name.setTextContent(person.getName());
            sex.setTextContent(person.getSex());
            department.setTextContent(person.getDepartment());
            salary.setTextContent(String.valueOf(person.getSalary()));


            element.appendChild(ID);
            element.appendChild(name);
            element.appendChild(sex);
            element.appendChild(department);
            element.appendChild(salary);
            root.appendChild(element);
        }

        Transformer transformer= TransformerFactory.newInstance().newTransformer();
        Source xmlsource=new DOMSource(root);
          /*
        * 获取文件路径
        * */
        String fileDirectoriesPath=null;
        JFileChooser chooser = new JFileChooser();//文件路径选择器
        chooser.setApproveButtonText("保存");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  //设置只选择目录

        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileDirectoriesPath=chooser.getSelectedFile().getPath();//获取文件夹路径
            //System.out.println(" fileDirectoriesPath=" +fileDirectoriesPath);
            Result outputTarget=new StreamResult(new File(fileDirectoriesPath+"/person.xml"));
            transformer.transform(xmlsource,outputTarget);
            JOptionPane.showMessageDialog(null,"导出"+persons.size()+"条数据成功","提示消息",JOptionPane.OK_OPTION);
        }


    }







}










