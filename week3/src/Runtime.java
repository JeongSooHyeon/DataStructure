
public class Runtime {
	public static void main(String[] args) {
		int[] arr = new int[500]; // create an array
		for (int i = 0; i < arr.length; i++)
			arr[i] = 0; // initialize

		long beforeTime = System.currentTimeMillis(); // start the timer
		fFourth(arr); // wait until it returns
		long afterTime = System.currentTimeMillis(); // finish the timer

		long diffTimeMillisecond = afterTime - beforeTime; // get the diff
		System.out.println("O(N^4) Time diff (ms): " + diffTimeMillisecond);
	}
	public static int fConstant(int[] arr) {
		// O(1)
		return arr.length;
	}
	
	public static int fLinear(int[] arr) {
		// O(N)
		int sum = 0;
		for(int i = 0; i < arr.length; i++) 
			sum += arr[i];
		return sum;		
	}

	public static int fQuadratic(int[] arr) {
		// O(N^2)
		int sum = 0;
		for(int i = 0; i < arr.length; i++) 
			for(int j = 0; j < arr.length; j++)
				sum += arr[i]+arr[j];
		return sum;		
	}
	
	public static int fCubin(int[] arr) {
		// O(N^3)
		int sum = 0;
		for(int i = 0; i < arr.length; i++) 
			for(int j = 0; j < arr.length; j++)
				for(int k = 0; k < arr.length; k++)
				sum += arr[i]+arr[j]+arr[k];
		return sum;	
	}
	
	public static int fFourth(int[] arr) {
		// O(N^4)
		int sum = 0;
		for(int i = 0; i < arr.length; i++) 
			for(int j = 0; j < arr.length; j++)
				for(int k = 0; k < arr.length; k++)
					for(int l = 0; l < arr.length; l++)
						sum += arr[i]+arr[j]+arr[k]+arr[l];
		return sum;	
	}
}










