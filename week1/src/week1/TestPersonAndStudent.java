package week1;

public class TestPersonAndStudent {

	public static void main(String[] args) {

		PersonInfo person = new PersonInfo("���ڸ���", 484);
		StudentInfo student = new StudentInfo("�����Ǹ���", 222, "���ΰ��а�", 3333);
		
		person.printPersonInfo();
		student.printStudentInfo();
	}

}

