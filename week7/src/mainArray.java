
public class mainArray {
	public static void main(String[] args) {
		AnimalShelter as = new AnimalShelter();
		
		Animal Brad = new Dog("Brad");		as.enter(Brad);
		Animal Tom = new Dog("Tom");		as.enter(Tom);
		Animal Cindy = new Cat("Cindy");	as.enter(Cindy);
		Animal Jake = new Dog("Jake");		as.enter(Jake);
		Animal Jenny = new Cat("Jenny");	as.enter(Jenny);
		Animal Alex = new Dog("Alex");		as.enter(Alex);
		Animal Lucy = new Cat("Lucy");		as.enter(Lucy);
		Animal Maggie = new Cat("Maggie");	as.enter(Maggie);
		
		as.print();
		
		as.adoptAny();		as.print();
		as.adoptCat();		as.print();
		as.adoptDog();   	as.print();
		as.adoptAny();		as.print();
		as.adoptDog();   	as.print();
		
		
		
		
		
		
		
		
		//ArrayQueue<String> queue = new ArrayQueue<String>();
	
		
		
		
		/*queue.add(1);		queue.add(2);		queue.add(3);		queue.add(4);		queue.add(5);
		//queue.add("A");	queue.add("B");	queue.add("C");	queue.add("D");	queue.add("E");		
		queue.print();
		queue.reverse();
		queue.print();*/		
		
//		queue.add(1);		queue.add(5);
//		queue.add(3);		queue.add(2);		queue.add(4);
//		queue.print();
//		System.out.println("ЦђБе : " + queue.avg());
//		queue.print();
	
		
//		queue.add("apple");		queue.add("orange");
//		queue.add("cherry");	queue.add("pear");		queue.print();
//		queue.remove(); 		queue.print();
//		queue.add("grape"); 	queue.print();
//		queue.remove(); 		queue.print();
//		queue.add("lemon"); 	queue.print();
//		queue.add("mango"); 	queue.print();
//		queue.add("lime"); 		queue.print();
//		queue.add("kiwi"); 		queue.print();
//		queue.remove(); 		queue.print();	

	}

}
