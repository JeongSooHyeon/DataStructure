package week1;

public class TestPersonAndStudent {

	public static void main(String[] args) {

		PersonInfo person = new PersonInfo("감자만두", 484);
		StudentInfo student = new StudentInfo("얇은피만두", 222, "만두공학과", 3333);
		
		person.printPersonInfo();
		student.printStudentInfo();
	}

}

