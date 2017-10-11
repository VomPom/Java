package Java.Java811XML.model;

import org.dom4j.Element;

/**
 * Created by Julis on 17/8/11.
 * User:Julis 落叶挽歌
 * Date:17/8/11
 * Time:下午10:26
 */
public class Member {

    private Integer id;
    private String name;
    private String address;
    private String tel;
    public Member() {
    }

    public Member(Integer id, String name, String address, String tel) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
