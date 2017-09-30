package WORK.Java.Java723Object;


/**
 * Created by Julis on 17/7/24.
 * User:Julis 落叶挽歌
 * Date:17/7/24
 * Time:下午1:49
 */
public class ClassRoom {
    public String name;
    private int containNumber;
    private StudentOfRoom[] studentOfRooms;

    public StudentOfRoom[] getStudentOfRooms() {
        return studentOfRooms;
    }

    public void setStudentOfRooms(StudentOfRoom[] studentOfRooms) {
        this.studentOfRooms = studentOfRooms;
    }

    public ClassRoom(String roomName, int containNumber){
        this.name=roomName;
        this.containNumber=containNumber;
    }
    public int getContainNumber(){
        return this.containNumber;
    }

}
