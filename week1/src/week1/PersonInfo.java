package week1;

public class PersonInfo {
		String name;
		int ID;
		
		// ������
		public PersonInfo()	{
			this.name = "�ո���";
			this.ID = 4752;
		}
		public PersonInfo(String name, int ID)	{
			this.name = name;
			this.ID = ID;
		}
		// ��� �Լ�
		public void printPersonInfo(){
			System.out.println("�̸� : " + name);
			System.out.println("�ֹι�ȣ : " + ID);
			System.out.println();
		}
}
