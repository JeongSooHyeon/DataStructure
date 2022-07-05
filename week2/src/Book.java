import java.util.Comparator;

public class Book implements Comparable<Book> {
	public static final Comparator<Book> WithName = new WithName();
	public static final Comparator<Book> WithSerial = new WithSerial();
	public static final Comparator<Book> WithDate = new WithDate();

	private String title;
	private int serial;
	private int yyyy, mm, dd;

	public Book(String title, int serial, int yyyy, int mm, int dd) {
		this.title = title;
		this.serial = serial;
		this.yyyy = yyyy;
		this.mm = mm;
		this.dd = dd;
	}
	
	public String getTitle() {return title;}
	public int getSerial() {return serial;}
	public String getDate() {return yyyy + " " + mm + " " + dd;}

	public static class WithName implements Comparator<Book> {
		public int compare(Book b1, Book b2) {
			return b1.title.compareTo(b2.title);
		}
	}

	public static class WithSerial implements Comparator<Book> {
		public int compare(Book b1, Book b2) {
			return b1.serial - b2.serial;
		}
	}

	public static class WithDate implements Comparator<Book> {
		public int compare(Book b1, Book b2) {
			if (b1.yyyy != b2.yyyy) 
				return b1.yyyy - b2.yyyy;
			else if (b1.mm != b2.mm)
				return b1.mm - b2.mm;
			else
				return b1.dd - b2.dd;
		}
	}
	public int compareTo(Book b1) {
		return this.title.compareTo(b1.title);
	}

}
