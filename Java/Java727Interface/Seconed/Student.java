package WORK.Java.Java727Interface.Seconed;

/**
 * Created by Julis on 17/7/27.
 * User:Julis 落叶挽歌
 * Date:17/7/27
 * Time:下午1:35
 */
public class Student {
    private int id;
    private String name;
    private Course[] courses;

    public Student(int id, String name,String[]courseName,double []courseScore) {
        courses=new Course[3];
        for(int i=0;i<courses.length;i++){
            courses[i]=new Course(courseName[i],courseScore[i]);
        }
        this.id = id;
        this.name = name;

    }
    public void showAllScore(){
        double sum=0;
         for(Course course : courses){
             System.out.println("课程名:"+course.getName()+"  分数:"+course.getScore());
             sum+=course.getScore();
         }
        System.out.println("总成绩为:"+sum);
    }
    class Course{
        private String name;
        private double score;

        public Course(String name, double score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

    }
}



