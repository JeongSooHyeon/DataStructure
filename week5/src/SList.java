import java.util.NoSuchElementException;

public class SList<E> {
	protected Node head; // 연결 리스트의 첫 노드 가리킴
	private int size;
	
	public SList() {
		head = null;
		size = 0;
	}

	// 탐색, 삽입, 삭제 연산을 위한 메소드 선언
	public int search(E target) { // target을 탐색
		Node p = head;
		for (int k = 0; k < size; k++) {
			if (target == p.getItem())
				return k;
			p = p.getNext();
		}
		return -1; // 탐색을 실패한 경우 -1 리턴
	}

	public void insertFront(E newItem) { // 연결리스트 맨 앞에 새 노드 삽입
		head = new Node(newItem, head);
		size++;
	}

	public void insertAfter(E newItem, Node p) { // 노드 p 바로 다음에 새 노드 삽입
		p.setNext(new Node(newItem, p.getNext()));
		size++;
	}

	public void deleteFront() {
		if (size == 0)
			throw new NoSuchElementException();
		head = head.getNext();
		size--;
	}

	public void deleteAfter(Node p) {
		if (p == null)
			throw new NoSuchElementException();
		Node t = p.getNext();
		if (t != null) {
			p.setNext(t.getNext());
			t.setNext(null);
			size--;
		} else // p.next인 t가 null이면, 아무것도 할 게 없음
			;
	}

	public void print() {
		Node p = head;
		for (int i = 0; i < size(); i++) {
			System.out.print(p.getItem() + "\t");
			p = p.getNext();
		}
	}

	public int size() {
		return size;
	}
	
	public void setAndOrderNodes(int[] arr) {
		if (arr == null)
			return;
		head = null;
		size = 0; // 리스트 초기화

		// 첫번째 값 넣기
		int value = arr[0];
		this.insertFront((E) (Object) value);
		if (arr.length == 1)
			return;		

		// 나머지 넣기
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] <= (int) head.getItem())
				this.insertFront((E) (Object) arr[i]);
			else {
				Node now = head;
				while (now != null) {
					Node next = now.getNext();
					if (next == null) {
						this.insertAfter((E) (Object) arr[i], now);
						break;
					}
					if (arr[i] <= (int) next.getItem()) {
						this.insertAfter((E) (Object) arr[i], now);
						break;
					}

					now = next;

				}
			}
		}
	}

	public void join(SList slist2) {
		int[] arr = new int[this.size + slist2.size];

		Node now1 = slist2.head;

		// s1에 합치기
		for (int i = 0; i < slist2.size; i++) {
			this.insertFront((E) (Object) now1.getItem());
			now1 = now1.getNext();
		}
		
		// 배열에 연결리스트 넣기
		Node now2 = this.head;
		for (int i = 0; i < this.size; i++) {
			arr[i] = (int) now2.getItem();
			now2 = now2.getNext();
		}
		
		// 정렬
		this.setAndOrderNodes(arr);
	}

	public void reverse() {
		int[] arr = new int[this.size];

		Node now = head;
		for (int i = 0; i < this.size; i++) {
			arr[i] = (int) now.getItem();
			now = now.getNext();
		}

		head = null;
		size = 0;
		for (int i = 0; i < arr.length; i++)
			this.insertFront((E) (Object) arr[i]);

	}
}
