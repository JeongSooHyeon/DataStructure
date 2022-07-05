import java.util.NoSuchElementException;
public class CList<E> {
	private Node last;
	private int size;
	public CList() {
		last = null;
		size = 0;
	}
	// 삽입, 삭제 연산을 위한 메소드 선언

	public void insert(E newItem) {
		Node newNode = new Node(newItem, null);
		if (last == null) {
			newNode.setNext(newNode);
			last = newNode;
		} else {
			newNode.setNext(last.getNext());
			last.setNext(newNode);
		}
		size++;
	}
	
	public Node delete() {
		if (isEmpty())
			throw new NoSuchElementException();
		Node x = last.getNext();
		if (x == last)
			last = null;
		else {
			last.setNext(x.getNext());
			x.setNext(null);
		}
		size--;
		return x;
	}
	
	public boolean isEmpty() {
		if (size <= 0)
			return true;
		return false;
	}

	public void print() {
		Node p = last;
		for (int i = 0; i < size; i++) {
			System.out.print(p.getNext().getItem() + "\t");
			p = p.getNext();
		}
	}

	public int size() {
		return size;
	}

	public void rotateLeft(int n) {
		for (int i = 0; i < n; i++)
			last = last.getNext();
	}

	// 1:3, 2:2, 3:1, 4:0
	public void rotateRight(int n) {
		for (int i = 0; i < this.size - (n%this.size); i++)
			last = last.getNext();
	}
}
