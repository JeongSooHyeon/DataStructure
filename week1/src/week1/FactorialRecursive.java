package week1;
import java.util.Scanner;
public class FactorialRecursive {
	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();		
		
		System.out.println(num + "! : " + factorial(num));
	}
	
	public static int factorial(int num)
	{
		if(num == 1)
			return 1;
		return num * factorial(num-1);
	}
	
}
