import java.util.NoSuchElementException;

public class SList<E> {
	protected Node head; // ���� ����Ʈ�� ù ��� ����Ŵ
	private int size;
	
	public SList() {
		head = null;
		size = 0;
	}

	// Ž��, ����, ���� ������ ���� �޼ҵ� ����
	public int search(E target) { // target�� Ž��
		Node p = head;
		for (int k = 0; k < size; k++) {
			if (target == p.getItem())
				return k;
			p = p.getNext();
		}
		return -1; // Ž���� ������ ��� -1 ����
	}

	public void insertFront(E newItem) { // ���Ḯ��Ʈ �� �տ� �� ��� ����
		head = new Node(newItem, head);
		size++;
	}

	public void insertAfter(E newItem, Node p) { // ��� p �ٷ� ������ �� ��� ����
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
		} else // p.next�� t�� null�̸�, �ƹ��͵� �� �� ����
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
		size = 0; // ����Ʈ �ʱ�ȭ

		// ù��° �� �ֱ�
		int value = arr[0];
		this.insertFront((E) (Object) value);
		if (arr.length == 1)
			return;		

		// ������ �ֱ�
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

		// s1�� ��ġ��
		for (int i = 0; i < slist2.size; i++) {
			this.insertFront((E) (Object) now1.getItem());
			now1 = now1.getNext();
		}
		
		// �迭�� ���Ḯ��Ʈ �ֱ�
		Node now2 = this.head;
		for (int i = 0; i < this.size; i++) {
			arr[i] = (int) now2.getItem();
			now2 = now2.getNext();
		}
		
		// ����
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
