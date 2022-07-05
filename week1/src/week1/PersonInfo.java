package week1;

public class PersonInfo {
		String name;
		int ID;
		
		// 생성자
		public PersonInfo()	{
			this.name = "왕만두";
			this.ID = 4752;
		}
		public PersonInfo(String name, int ID)	{
			this.name = name;
			this.ID = ID;
		}
		// 멤버 함수
		public void printPersonInfo(){
			System.out.println("이름 : " + name);
			System.out.println("주민번호 : " + ID);
			System.out.println();
		}
}
