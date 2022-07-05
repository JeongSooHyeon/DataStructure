package week1;

public class StudentInfo extends PersonInfo {
	String deptName;
	int stuID;
	
	public StudentInfo() {
		super();
		this.deptName = "전자공학과";
		this.stuID = 2018;
	}
	
	public StudentInfo(String name, int id, String deptname, int stuid) {
		super(name, id);
		this.deptName = deptname;
		this.stuID = stuid;
	}
	
	public void printStudentInfo() {
		super.printPersonInfo();
		System.out.println("전공 : " + deptName);
		System.out.println("학번 : " + stuID);
		System.out.println();
	}
}

