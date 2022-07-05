public class IterCnt {
	public static void main(String[] args) {
		
		long iter_cnt = 0;
		System.out.println(Integer.MAX_VALUE+1);
		for (int i = Integer.MAX_VALUE; i <= Integer.MAX_VALUE; i++)
			iter_cnt = iter_cnt + 1;
		System.out.println(iter_cnt);
	}
}
