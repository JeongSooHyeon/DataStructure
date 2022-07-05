import java.util.NoSuchElementException;
public class ListQueue<E> {
	public Node<E> front, rear;
	private int size;
	public ListQueue() {
		front = rear = null;
		size = 0;
	}
	public int size() {	return size;}
	public boolean isEmpty() {	return size() == 0;}

	public void add(E newItem) {
		Node newNode = new Node(newItem, null);
		if (isEmpty())
			front = newNode;
		else
			rear.setNext(newNode);
		rear = newNode;
		size++;
	}

	public E remove() {
		if (isEmpty())	throw new NoSuchElementException();
		E frontItem = front.getItem();
		front = front.getNext();
		size--;
		if (isEmpty())
			rear = null;
		return frontItem;
	}
	
	public int avg() {
		int sum = 0;
		int temp;
		int avg = 0;
		
		Node now = front;
		
		for(int i = 0; i < size; i++) {
			temp = (int)this.remove();;
			sum += temp;
			this.add((E)(Object)temp);
		}
		avg = sum / size;
		return avg;
	}
	
	public void print() {
		Node now = front;
		for (int i = 0; i < size; i++) {
			System.out.print(now.getItem() + "\t");
			now = now.getNext();
		}
		System.out.println();
	}
	
	public E removeNum(int idx) {
		if(idx == 0) 			
			return remove();
	
		Node now = front;
		Node tmp;
		if (isEmpty())
			throw new NoSuchElementException();
		
		for (int i = 0; i < idx-1; i++) {			
			now = now.getNext();
		}
		tmp = now.getNext();
		now.setNext(tmp.getNext());
		tmp.setNext(null);
		
		E frontItem = (E)tmp.getItem();
		if (isEmpty())
			rear = null;
		size--;
		return frontItem;
	}

	public void reverse() {
		ListStack<Integer> stack = new ListStack<Integer>();
		int oSize = size;
		for (int i = 0; i < oSize; i++) 
			stack.push((int)this.remove());
			
		for (int i = 0; i < oSize; i++) 
			this.add((E)stack.pop());		
	}

	public int exp(String str) {
		int index = 0;
		Node now = front;
		for (int i = 0; i < size(); i++) {
			if (now.getItem() == str) {
				index = i;
				break;
			}
			now = now.getNext();
		}
		return index;
	}
}
