package WORK.Java.Java811XML.dom4j;

import WORK.Java.Java811XML.model.Member;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Julis on 17/8/11.
 * User:Julis 落叶挽歌
 * Date:17/8/11
 * Time:下午11:19
 */
public class Test {
    public static void main(String []args) throws IOException, DocumentException {
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

    private static ArrayList<Member> read() throws DocumentException {
        ArrayList<Member> members=new ArrayList<>();
        SAXReader sr=new SAXReader();
        Document doc=sr.read(new File("memberOfDom4j.xml"));
        Element root =doc.getRootElement();
        List<Member> member=root.elements();
        for(int i=0;i<member.size();i++){
            Member m=new Member();
           Element men= (Element) member.get(i);
            m.setId(Integer.parseInt(men.attribute("memberid").getText()));
            Iterator<Element> it=men.elementIterator();
            while (it.hasNext()){
                Element e = it.next();
                switch (e.getName()) {
                    case "name":
                        m.setName(e.getText());
                        break;
                    case "address":
                        m.setAddress(e.getText());
                        break;
                    case "Tel":
                        m.setTel(e.getText());
                        break;

                    default:
                        break;
                }
            }
            members.add(m);
        }
        return  members;
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
    public static void write(List<Member> members) throws IOException {

        Document doc= DocumentHelper.createDocument();
        Element element=doc.addElement("Member");

        for(int i=0;i<members.size();i++){
            Member member=members.get(i);
            Element m=element.addElement("members");
            m.addElement("name").setText(member.getName());
            m.addElement("address").setText(member.getAddress());
            m.addElement("Tel").setText(member.getTel());
            m.addAttribute("memberid",member.getId().toString());
        }
        OutputFormat outputFormat=OutputFormat.createPrettyPrint();
        XMLWriter writer=new XMLWriter(new FileOutputStream("memberOfDom4j.xml"),outputFormat);
        writer.write(doc);
        writer.flush();
        writer.close();
    }
}














