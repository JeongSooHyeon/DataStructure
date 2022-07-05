public class Chaining<K, V> {
	private int M = 13; // ���̺� ũ��
	private int N = 0;
	private Node[] a = new Node[M]; // �ؽ� ���̺�

	public static class Node { // Node Ŭ����
		public Object key;
		public Object data;
		public Node next;

		public Node(Object newkey, Object newdata, Node ref) { // ������
			key = newkey;
			data = newdata;
			next = ref;
		}

		public Object getKey() {
			return key;
		}

		public Object getDate() {
			return data;
		}
	}

	private int hash(K key) { // �ؽ��ڵ�
		return (key.hashCode() & 0x7fffffff) % M;
	} // ������ ����

	public V get(K key) { // Ž�� ����
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) // ���Ḯ��Ʈ Ž��
			if (key.equals(x.key))
				return (V) x.data; // Ž�� ����
		return null;
	}

	public void put(K key, V data) { // ���� ����
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) // a[i]�� ���� �־�
			if (key.equals(x.key)) { // �̹� key ����
				x.data = data; // �����͸� ����
				return;
			}
		// ù ��� �����̸�
		N++; 
		a[i] = new Node(key, data, a[i]); // ���� ����Ʈ�� ù ���� ����
		//check_and_rehash();
	}

	void print() {
		System.out.println("\n�ؽ� ���̺� : ");
		for (int i = 0; i < M; i++) {
			System.out.print(i);
			if (a[i] != null) {
				for (Node j = a[i]; j != null; j = j.next) {
					System.out.print("-->[" + j.key + ", " + j.data + "]");
				}
			}
			System.out.println();
		}
	}
	
	private void check_and_rehash() {
		double lf = (double) N / M; // load factor
		
		// �ø���
		if (lf > 0.75) {
			int oM = M; // original M
			M *= 2; // 2�� Ȯ��
			System.out.println("[check_and_rehash] ���̺��� ����� " + oM + "���� " + M + "�� �����մϴ�.");
			Node[] tmp = new Node[M];
			for (int i = 0; i < oM; i++)
				if (a[i] != null) {
					int idx = hash((K) a[i].key);
					tmp[idx] = a[i]; 
				}
			a = tmp;
		} 
		// ���̱�
		else if (lf < 0.25) {
			if (M / 2 >= 5) { // �ּ�ũ��
				int oM = M;
				M /= 2; // 1/2
				System.out.println("[check_and_rehash] ���̺��� ����� " + oM + "���� " + M + "�� �����մϴ�.");
				Node[] tmp = new Node[M];
				for (int i = 0; i < oM; i++)
					if (a[i] != null) {
						int idx = hash((K) a[i].key);
						tmp[idx] = a[i]; 
					}
				a = tmp;
			}
		} 
		else
			System.out.println("[check_and_rehash] ���̺��� ����� �������� �ʽ��ϴ�.");
	}	
	public void delete(K key) {
		int i = hash(key);
		Node tmp = null; // a[i]�� �� ���

		for (Node x = a[i]; x != null; x = x.next) {
			if (key.equals(x.key)) { // Ű�� ���� �� ã��
				if (tmp == null) { // �ٵ� ���� �� ���̾�
					a[i] = x.next; // �Ǿտ� �� �ڸ� �־�
					N--;
				} 
				else {// �� �� �� �ƴ�
					tmp.next = x.next;
					N--;
				}
			}
			tmp = x;
		}
		check_and_rehash();
	}
	
	Boolean find(K x) {
		int i = hash(x);
		for (Node n = a[i]; n != null; n = n.next) 
			if (x.equals(n.key)) 
				return true;			
		return false;
	}
	Boolean findTwoNum(int[] arr, int sum) {
		Chaining<Integer, Integer> tab = new Chaining<Integer, Integer>();
		for (int x : arr) {
			int diff = sum - x;
			if (tab.find(diff) == true)
				return true;
			else
				tab.put(x, x);
		}
		return false;
	}
}
