import java.util.Scanner;

public class PrimeNum {
	public static void main(String[] args) {

		System.out.print("1���� ū ���� ������ �Է��ϼ��� : ");

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		if (primeN(n))
			System.out.println(n + "�� �Ҽ��Դϴ�.");
		else
			System.out.println(n + "�� �Ҽ��� �ƴմϴ�.");
	}

	public static boolean primeN(int n) {
		for (int i = 2; i < n; i++)
			if (n % i == 0) // 1�� �� �ڽ��� �ƴ� ���� ������ �������ٸ�
				return false;
		return true;
	}
}
