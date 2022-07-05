import javax.print.CancelablePrintJob;

public class main {
	public static void main(String[] args) {
		
		Chaining<Integer, Integer> ch = new Chaining<Integer, Integer>();
		
		int[] arr1 = { 1, 2, 4, 4 };
		int sum1 = 8;
		System.out.println("결과 : " +ch.findTwoNum(arr1, sum1));
		
		
		
		/*
		for (int i = 0; i < 20; i++) ch.put(i, i); ch.print();
		  
		System.out.println("----------------------");
		for (int i = 0; i < 20; i++) ch.delete(i); ch.print();
		*/
		
		
		/*
		  ch.put(25, "grape"); ch.put(37, "apple"); ch.put(18, "banana"); ch.put(55,
		  "cherry"); ch.put(22, "mango"); ch.put(35, "lime"); ch.put(50, "orange");
		  ch.put(63, "watermelon");
		  
		  System.out.println("탐색 결과"); System.out.println("50의 data = " + ch.get(50));
		  System.out.println("63의 data = " + ch.get(63));
		  System.out.println("37의 data = " + ch.get(37));
		  System.out.println("22의 data = " + ch.get(22));
		  
		  ch.print();
		  */
		  
		/*
		DoubleHashing<Integer, String> dh = new DoubleHashing<Integer, String>();

		dh.put(25, "grape");		dh.put(37, "apple");
		dh.put(18, "banana");		dh.put(55, "cherry");
		dh.put(22, "mango");		dh.put(35, "lime");
		dh.put(50, "orange");		dh.put(63, "watermelon");
		
		System.out.println("탐색 결과");
		System.out.println("50의 data = " + dh.get(50));
		System.out.println("63의 data = " + dh.get(63));
		
		dh.print();
		*/		
		
		
		
		
		/*
		RandProbing<Integer, String> rp = new RandProbing<Integer, String>();

		rp.put(25, "grape");		rp.put(37, "apple");
		rp.put(18, "banana");		rp.put(55, "cherry");
		rp.put(22, "mango");		rp.put(35, "lime");
		rp.put(50, "orange");		rp.put(63, "watermelon");
		
		System.out.println("탐색 결과");
		System.out.println("50의 data = " + rp.get(50));
		System.out.println("63의 data = " + rp.get(63));
		
		rp.print();
		*/
		
		
		
		
		
		/*
		QuadProbing<Integer, String> qp = new QuadProbing<Integer, String>();

		qp.put(25, "grape");		qp.put(37, "apple");
		qp.put(18, "banana");		qp.put(55, "cherry");
		qp.put(22, "mango");		qp.put(35, "lime");
		qp.put(50, "orange");		qp.put(63, "watermelon");
		
		System.out.println("탐색 결과");
		System.out.println("50의 data = " + qp.get(50));
		System.out.println("63의 data = " + qp.get(63));
		
		qp.print();
		*/
		
		
		/*
		LinearProbing2<Integer, Integer> lp = new LinearProbing2<Integer, Integer>();

		lp.put(25, 25); 		lp.put(37, 37);
		lp.put(18, 18); 		lp.put(55, 55);
		lp.put(22, 22); 		lp.put(35, 35);
		lp.put(50, 50); 		lp.put(63, 63);
		
		lp.print();
		if(lp.get(63)!=null)
			System.out.println(lp.get(63) + " 찾았습니다!");
		System.out.println();
		
		lp.delete(50);		
		lp.print();System.out.println();
		
		if(lp.get(63)!=null)
			System.out.println(lp.get(63) + " 찾았습니다!");
		else
			System.out.println("못 찾음");
		*/
		
		/*
		LinearProbing<Integer, String> lp = new LinearProbing<Integer, String>();
	
		lp.put(25, "grape");	lp.put(37, "apple");
		lp.put(18, "banana");	lp.put(55, "cherry");
		lp.put(22, "mango");	lp.put(35, "lime");
		lp.put(50, "orange");	lp.put(63, "watermelon");
		
		lp.printData(50);
		lp.printData(63);		
		lp.printArray();	
		*/
	}	
}
