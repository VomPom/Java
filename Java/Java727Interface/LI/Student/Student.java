package WORK.Java.Java727Interface.LI.Student;

public class Student {

	private int stuid;
	private String name;
    private Course[] course;
	
	class Course{
		private String name;
		private double score;
		public Course(String name,double score) {
			this.name=name;
			this.score=score;
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
	public void print() {
		System.out.println(name+"所学课程:");
        for(Course s:course) {
		System.out.println(s.getName()+" "+s.getScore());
        }
		
	}
	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course[] getCourse() {
		return course;
	}

	public void setCourse(Course[] course) {
		this.course = course;
	}

}
