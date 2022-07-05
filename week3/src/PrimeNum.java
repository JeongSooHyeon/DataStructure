import java.util.Scanner;

public class PrimeNum {
	public static void main(String[] args) {

		System.out.print("1보다 큰 양의 정수를 입력하세요 : ");

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		if (primeN(n))
			System.out.println(n + "은 소수입니다.");
		else
			System.out.println(n + "은 소수가 아닙니다.");
	}

	public static boolean primeN(int n) {
		for (int i = 2; i < n; i++)
			if (n % i == 0) // 1과 나 자신이 아닌 수로 나누어 떨어진다면
				return false;
		return true;
	}
}
