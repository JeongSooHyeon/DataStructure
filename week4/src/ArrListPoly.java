public class ArrListPoly extends ArrList<Integer> {

	public void setPoly(int k, int[] arr) {
		for (int i = 0; i <= k; i++) {
			insertLast(arr[i]);
		}
	}

	public int getHighestDegree() {
		return size - 1;
	}

	public ArrListPoly sumPoly(ArrListPoly p) {
		int min_size = Math.min(size, p.size);
		int max_size = Math.max(size,  p.size);
		int[] arr_sum = new int[max_size];
		
		for(int i = 0; i < min_size; i++) {
			arr_sum[i] = peek(i)+p.peek(i);
		}
		for(int i = min_size; i < max_size; i++) {
			if(size > p.size)
				arr_sum[i] = peek(i);
			else
				arr_sum[i] = p.peek(i);
		}
		
		ArrListPoly p3 = new ArrListPoly();
		p3.setPoly(max_size-1, arr_sum);
		
		return p3;
	}
}
