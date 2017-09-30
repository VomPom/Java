package WORK.Java.Java811XML.dom;

import WORK.Java.Java811XML.model.Member;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julis on 17/8/11.
 * User:Julis 落叶挽歌
 * Date:17/8/11
 * Time:下午10:31
 */
public class Test {
    public static void main(String[] args) throws TransformerException, ParserConfigurationException, IOException, SAXException {
        ArrayList<Member> members=new ArrayList<>();
        members=initData();
        write(members);
        System.out.println("Dom写入xml成功");

        ArrayList<Member> readMembers=new ArrayList<>();
        readMembers=read();
        System.out.println("Dom读取xml成功");
        for(int i=0;i<readMembers.size();i++){
            Member member=readMembers.get(i);
            System.out.println("ID="+member.getId());
            System.out.println("Name="+member.getName());
            System.out.println("Address="+member.getAddress());
            System.out.println("Tel="+member.getTel()+"\n");
        }



    }
    public static ArrayList<Member>initData(){
        ArrayList<Member> members=new ArrayList<>();
        Member member1=new Member(1,"张三","温州","15881628774");
        Member member2=new Member(2,"李四","广州","15812481628");
        Member member3=new Member(3,"牛二","徐州","15881628123");
        Member member4=new Member(4,"王五","苏州","15848161234");
        Member member5=new Member(5,"老七","杭州","15814281628");
        members.add(member1);
        members.add(member2);
        members.add(member3);
        members.add(member4);
        members.add(member5);
        return members;
    }
    public static ArrayList<Member> read() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Member> members = new ArrayList<>();
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document doc=builder.parse(new File("members.xml"));
        Element root=doc.getDocumentElement();
        NodeList member=root.getChildNodes();
        for(int i=0;i<member.getLength();i++){
            Node m=member.item(i);
            if(Node.ELEMENT_NODE == m.getNodeType()) {
                Member member1 = new Member();
                member1.setId(Integer.parseInt(m.getAttributes().item(0).getNodeValue()));
                NodeList nodes = m.getChildNodes();
                for(int j=0;j<nodes.getLength();j++) {
                    Node n = nodes.item(j);
                    if(Node.ELEMENT_NODE == n.getNodeType()) {
                        switch (n.getNodeName()) {
                            case "name":
                                member1.setName(n.getTextContent());
                                break;
                            case "address":
                                member1.setAddress(n.getTextContent());
                                break;
                            case "tel":
                              member1.setTel(n.getTextContent());
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


    public static void write(List<Member> menbers) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document doc=builder.newDocument();

        Element root=doc.createElement("members");

        for(int i=0;i<menbers.size();i++){
            Member member=menbers.get(i);
            Element element=doc.createElement("members");
            Element name=doc.createElement("name");
            Element addres=doc.createElement("address");
            Element tel=doc.createElement("tel");

            name.setTextContent(member.getName());
            addres.setTextContent(member.getAddress());
            tel.setTextContent(member.getTel());

            element.setAttribute("id",member.getId().toString());

            element.appendChild(name);
            element.appendChild(addres);
            element.appendChild(tel);
            root.appendChild(element);
        }

        Transformer transformer= TransformerFactory.newInstance().newTransformer();
        Source xmlsource=new DOMSource(root);
        Result outputTarget=new StreamResult(new File("members.xml"));
        transformer.transform(xmlsource,outputTarget);

    }







}










