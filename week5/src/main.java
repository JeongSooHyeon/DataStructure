public class main {
	public static void main(String[] args) {
		CList<Integer> cl1 = new CList<Integer>();
		cl1.insert(4);
		cl1.insert(3);
		cl1.insert(2);
		cl1.insert(1);
		System.out.print("[Task1]\n"); cl1.print();
		System.out.println();
		
		CList<Integer> cl2 = new CList<Integer>();
		cl2.insert(4);
		cl2.insert(3);
		cl2.insert(2);
		cl2.insert(1);
		cl2.print(); System.out.println();
		
		cl1.rotateLeft(1);
		cl2.rotateRight(1);
		System.out.print("\n[Task3]\n");
		cl1.print();		System.out.println();
		cl2.print();
		
		
		/*
		 * DList<Integer> dl1 = new DList<Integer>();
		 * 
		 * dl1.insertBefore(dl1.tail, 1); dl1.insertBefore(dl1.tail, 2);
		 * dl1.insertBefore(dl1.tail, 3); System.out.print("[Task1]\n"); dl1.print();
		 * 
		 * DList<Integer> dl2 = new DList<Integer>(); dl2.insertBefore(dl2.tail, 6);
		 * dl2.insertBefore(dl2.tail, 7); dl2.insertBefore(dl2.tail, 8);
		 * dl2.insertBefore(dl2.tail, 9); System.out.print("\n[Task2]\n"); dl2.print();
		 * 
		 * int add1 = dl1.add(dl2); int add2 = dl2.add(dl1);
		 * 
		 * System.out.print("\n[Task3]\nadd1 : " + add1 + "\nadd2 : " + add2);
		 */
		
		/*
		 * SList<Integer> s1 = new SList<Integer>(); int[] arr = { 7, 11, 4, 1, 8 };
		 * s1.setAndOrderNodes(arr); System.out.print("[Task1]\n"); s1.print();
		 * System.out.println();
		 * 
		 * SList<Integer> s2 = new SList<Integer>(); int[] arr2 = { 5, 2, 8, 7, 13 };
		 * s2.setAndOrderNodes(arr2); System.out.print("\n[Task2]\n"); s2.print();
		 * System.out.println();
		 * 
		 * s1.join(s2); System.out.print("\n[Task3]\n"); s1.print();
		 */

		/*
		 * SList<Integer> s1 = new SList<Integer>(); s1.insertFront(5);
		 * s1.insertFront(4); s1.insertFront(3); s1.insertFront(2); s1.insertFront(1);
		 * System.out.print("[Task1]\n");s1.print();
		 * 
		 * s1.reverse(); System.out.print("\n[Task2]\n");s1.print();
		 */

		/*
		 * CList<String> s = new CList<String>();
		 * 
		 * s.insert("pear"); s.insert("cherry"); s.insert("orange"); s.insert("apple");
		 * s.print(); System.out.print(": s의 길이 = " + s.size() + "\n");
		 * 
		 * s.delete(); s.print(); System.out.print(": s의 길이 = " + s.size());
		 * System.out.println();
		 */

		/*
		 * DList<String> s = new DList<String>(); //
		 * 
		 * s.insertAfter(s.head, "apple"); s.insertBefore(s.tail, "orange");
		 * s.insertBefore(s.tail, "cherry"); s.insertAfter(s.head.getNext(), "pear");
		 * s.print(); System.out.println();
		 * 
		 * s.delete(s.tail.getPrevious()); s.print(); System.out.println();
		 * 
		 * s.insertBefore(s.tail, "grape"); s.print(); System.out.println();
		 * s.delete(s.head.getNext()); s.print(); s.delete(s.head.getNext()); s.print();
		 * s.delete(s.head.getNext()); s.print(); s.delete(s.head.getNext()); s.print();
		 */

		/*
		 * SList<String> s = new SList<String>(); s.insertFront("orange");
		 * s.insertFront("apple"); s.insertAfter("cherry", s.head.getNext());
		 * s.insertFront("pear");
		 * 
		 * s.print(); System.out.println(": s의 길이 = "+s.size()+"\n");
		 * System.out.println("체리가 \t"+s.search("cherry")+"번째에 있다.");
		 * System.out.println("키위가 \t"+s.search("kiwi")+"번째에 있다.\n");
		 * s.deleteAfter(s.head); s.print(); System.out.println(" : s의 길이 = " +
		 * s.size()); System.out.println(); s.deleteFront(); s.print();
		 * System.out.println(" : s의 길이 = " + s.size()); System.out.println();
		 * 
		 * SList<Integer> t = new SList<Integer>(); t.insertFront(500);
		 * t.insertFront(200); t.insertAfter(400, t.head); t.insertFront(100);
		 * t.insertAfter(300, t.head.getNext()); t.print();
		 * System.out.println(": t의 길이 = "+ t.size());
		 */
	}
}
