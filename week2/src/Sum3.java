import java.util.Scanner;
public class Sum3 {
	public static void main(String[] args) {
		
		// 배열 100개 할당
		int sz = 100;
		int[] arr = new int[sz];

		for (int i = 0; i < 100; i++)
			arr[i] = i + 1;

		// 숫자 n 입력
		int n = getInt();
		
		LoopOut:
		for (int a = 0; a < sz - 2; a++) 
			for (int b = a + 1; b < sz - 1; b++) 
				for (int c = b + 1; c < sz; c++) 
					if (arr[a] + arr[b] + arr[c] == n) {
						System.out.printf("Three numbers are : %d, %d, %d\n", arr[a], arr[b], arr[c]);
						break LoopOut;
					} // if
		}
	
	public static int getInt() {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		int n = Integer.parseInt(input);		
		scan.close();
		return n;	
	}
}
