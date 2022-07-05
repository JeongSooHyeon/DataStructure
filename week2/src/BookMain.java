import java.util.Arrays;
public class BookMain {
	public static void main(String[] args) {
		
		Book[] b = { new Book("�Ѹ����б�", 1, 2010, 3, 15), new Book("IT ���", 2, 2018, 8, 11),
				new Book("�ڹ� ���α׷���", 3, 2011, 1, 1), new Book("C ���α׷���", 4, 1999, 12, 18),
				new Book("�ΰ�����", 5, 2019, 2, 22), new Book("����н�", 6, 2015, 9, 30),
				new Book("�ΰ��� �̷�", 7, 2017, 5, 21) };

		Arrays.sort(b);
		print(b, "Title");
		Arrays.sort(b, Book.WithName);
		print(b, "Title");
		Arrays.sort(b, Book.WithSerial);
		print(b, "Serial");
		Arrays.sort(b, Book.WithDate);
		print(b, "Date");
	}

	public static void print(Book[] b, String key) {
		int i = 0;
		System.out.println();
		System.out.println("  " + key + "(��)�� ����");
		System.out.println("-----------------");
		for (Book temp : b) {
			System.out.printf(temp.getTitle() + " " + temp.getSerial() 
			+ " " + temp.getDate() + "\n");
		}
	}
}
