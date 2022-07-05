package week1;
import java.util.Scanner;
public class FactorialLoop {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();		
		int result=1;
		for(int i = 1; i<=num; i++) {
			result *= i;
		}
		System.out.println(num + "! : " + result);
	}
	
}
