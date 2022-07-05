public class Chaining<K, V> {
	private int M = 13; // 테이블 크기
	private int N = 0;
	private Node[] a = new Node[M]; // 해시 테이블

	public static class Node { // Node 클래스
		public Object key;
		public Object data;
		public Node next;

		public Node(Object newkey, Object newdata, Node ref) { // 생성자
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

	private int hash(K key) { // 해시코드
		return (key.hashCode() & 0x7fffffff) % M;
	} // 나눗셈 연산

	public V get(K key) { // 탐색 연산
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) // 연결리스트 탐색
			if (key.equals(x.key))
				return (V) x.data; // 탐색 성공
		return null;
	}

	public void put(K key, V data) { // 삽입 연산
		int i = hash(key);
		for (Node x = a[i]; x != null; x = x.next) // a[i]에 누가 있어
			if (key.equals(x.key)) { // 이미 key 존재
				x.data = data; // 데이터만 갱신
				return;
			}
		// 첫 노드 생성이면
		N++; 
		a[i] = new Node(key, data, a[i]); // 연결 리스트의 첫 노드로 삽입
		//check_and_rehash();
	}

	void print() {
		System.out.println("\n해시 테이블 : ");
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
		
		// 늘리기
		if (lf > 0.75) {
			int oM = M; // original M
			M *= 2; // 2배 확장
			System.out.println("[check_and_rehash] 테이블의 사이즈를 " + oM + "에서 " + M + "로 변경합니다.");
			Node[] tmp = new Node[M];
			for (int i = 0; i < oM; i++)
				if (a[i] != null) {
					int idx = hash((K) a[i].key);
					tmp[idx] = a[i]; 
				}
			a = tmp;
		} 
		// 줄이기
		else if (lf < 0.25) {
			if (M / 2 >= 5) { // 최소크기
				int oM = M;
				M /= 2; // 1/2
				System.out.println("[check_and_rehash] 테이블의 사이즈를 " + oM + "에서 " + M + "로 변경합니다.");
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
			System.out.println("[check_and_rehash] 테이블의 사이즈를 변경하지 않습니다.");
	}	
	public void delete(K key) {
		int i = hash(key);
		Node tmp = null; // a[i]의 앞 노드

		for (Node x = a[i]; x != null; x = x.next) {
			if (key.equals(x.key)) { // 키가 같은 거 찾음
				if (tmp == null) { // 근데 나는 맨 앞이야
					a[i] = x.next; // 맨앞에 내 뒤를 넣어
					N--;
				} 
				else {// 나 맨 앞 아님
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
