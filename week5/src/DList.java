import java.util.NoSuchElementException;

public class DList<E> {
	protected DNode head, tail;
	protected int size;
	public DList() {
		head = new DNode(null, null, null);
		tail = new DNode(null, head, null); // tail의 이전 노드를 head로 만든다
		head.setNext(tail);
		size = 0;
	}

	// 삽입, 삭제 연산을 위한 메소드 선언
	public void insertBefore(DNode p, E newItem) { // p가 가리키는 노드 앞에 삽입
		DNode t = p.getPrevious();
		DNode newNode = new DNode(newItem, t, p);
		p.setPrevious(newNode);
		t.setNext(newNode);
		size++;
	}

	public void insertAfter(DNode p, E newItem) {
		DNode t = p.getNext();
		DNode newNode = new DNode(newItem, p, t);
		t.setPrevious(newNode);
		p.setNext(newNode);
		size++;
	}

	public void delete(DNode x) {
		if (x == null)
			throw new NoSuchElementException();
		if (size <= 0)
			throw new NoSuchElementException();
		DNode f = x.getPrevious();
		DNode r = x.getNext();
		f.setNext(r);
		r.setPrevious(f);
		size--;
	}

	public void print() {
		if (size <= 0)
			System.out.print("리스트 비어있음");
		DNode p = head.getNext();
		for (int i = 0; i < size; i++) {
			System.out.print(p.getItem() + "\t");
			p = p.getNext();
		}
		System.out.println();
	}

	public int add(DList dl2) {
		int x = 0; 
		DNode now = head.getNext();
		for(int i = size-1; i >= 0; i--) {
			x += (int)now.getItem() * Math.pow(10, i);
			now = now.getNext();
		}
		now = dl2.head.getNext();
		for(int i = dl2.size-1; i >= 0; i--) {
			x += (int)now.getItem() * Math.pow(10, i);
			now = now.getNext();
		}
		return x;
	}

}
