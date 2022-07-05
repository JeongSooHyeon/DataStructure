public class AnimalShelter {	
	ListQueue<Animal> queue;
	int size;
	public AnimalShelter() {
		queue = new ListQueue<Animal>();
		size = 0;
	}
	
	public void enter(Animal animal) {
		queue.add(animal);
		size++;
	}

	public void adoptAny() {
		queue.remove();
		size--;
	}

	public void adoptCat() {
		boolean adopt = false;
		Animal temp;
		for(int i = 0; i < size; i++) {
			temp = queue.remove();
			if(temp.getKind() != "cat" || adopt) 
				queue.add(temp);	
			else
				adopt = true;
		}
		size--;
	}
	
	public void adoptDog() {
		boolean adopt = false;
		Animal temp;
		for(int i = 0; i < size; i++) {
			temp = queue.remove();
			if(temp.getKind() != "dog" || adopt) 
				queue.add(temp);	
			else
				adopt = true;
		}
		size--;
	}

	public void print() {
		Node q = queue.front;
		for(int i = 0; i < size; i++) {
			System.out.print(((Animal) q.getItem()).getName() + " (" + ((Animal) q.getItem()).getKind() + ") ");
			q = q.getNext();
			if(i != size-1)
				System.out.print("- ");
		}
		System.out.println();
	}
}
