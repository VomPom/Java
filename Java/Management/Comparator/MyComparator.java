package Java.Management.Comparator;

import Java.Management.bean.Person;

import java.util.Comparator;


/**
 * Created by Julis on 17/8/19.
 * User:Julis 落叶挽歌
 * Date:17/8/19
 * Time:下午1:28
 */
public class MyComparator implements Comparator<Person> {
    private int type;
    private static int flag=-1;
    public MyComparator(int type) {
        this.type = type;
        flag=flag*-1;
    }

    @Override
    public int compare(Person o1, Person o2) {

        switch (type){

            case 0:
                if(flag==-1)
                    return String.valueOf(o1.getId()).compareTo(String.valueOf(o2.getId()));
                else
                    return String.valueOf(o2.getId()).compareTo(String.valueOf(o1.getId()));
            case 1:
                if(flag==-1)
                    return o1.getName().compareTo(o2.getName());
                else
                    return o2.getName().compareTo(o1.getName());
            case 2:
                if(flag==-1)
                    return o1.getSex().compareTo(o2.getSex());
                else
                    return o2.getSex().compareTo(o1.getSex());
            case 3:
                if(flag==-1)
                    return o1.getDepartment().compareTo(o2.getDepartment());
                else
                    return o2.getDepartment().compareTo(o1.getDepartment());
            case 4:
                if(flag==-1)
                    return String.valueOf(o2.getSalary()).compareTo(String.valueOf(o1.getSalary()));
                else
                    return String.valueOf(o1.getSalary()).compareTo(String.valueOf(o2.getSalary()));

        }

        return 0;
    }
}







