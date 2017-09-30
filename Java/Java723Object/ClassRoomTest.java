package WORK.Java.Java723Object;

/**
 * Created by Julis on 17/7/24.
 * User:Julis 落叶挽歌
 * Date:17/7/24
 * Time:下午1:55
 */
public class ClassRoomTest {
    public static void main(String []args){
        StudentOfRoom[] studentOfRooms =new StudentOfRoom[2];
        studentOfRooms[0]=new StudentOfRoom("小红",4613);
        studentOfRooms[1]=new StudentOfRoom("晓东",4632);
        ClassRoom classRoom=new ClassRoom("三年级二班",45);
        classRoom.setStudentOfRooms(studentOfRooms);
        System.out.println("教室容纳人数为:"+classRoom.getContainNumber());
        StudentOfRoom[]gotstudets=classRoom.getStudentOfRooms();
        System.out.println("学生的人数为:"+gotstudets.length);
        for(int i=0;i<gotstudets.length;i++){
            System.out.println("姓名:"+gotstudets[i].getName()+"  ID:"+gotstudets[i].getId());
        }
        System.out.println();
    }
}


