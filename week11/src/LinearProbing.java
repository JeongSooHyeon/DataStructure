public class LinearProbing<K, V> { 
	private int M = 13; // 테이블 크기
	private K[] a = (K[]) new Object[M]; // 해시테이블
	private V[] d = (V[]) new Object[M]; // Key관련 데이터 저장
	private int hash(K key) { // 해시코드
		return (key.hashCode() & 0x7fffffff) % M; // 나눗셈 함수	
	}
	public void put(K key, V data) { // 삽입 연산
		int initialpos = hash(key); // 초기 위치
		int i = initialpos, j = 1;
		do {
			if(a[i] == null) { // 삽입 위치 발견
				a[i] = key;
				d[i] = data;
				return;
			}
			if(a[i].equals(key)) { // 이미 key 존재
				d[i] = data;
				return;
			}
			i = (initialpos + j++) % M; // i = 다음 위치
		}while(i != initialpos);
	}
	public V get(K key) { // 탐색 연산
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		do {
			if(a[i].equals(key)) return d[i];
			i = (initialpos + j++) % M;
		}while(a[i] != null // a[i] 가 null(=비어있음)이면 stop (못찾음)
				&& i != initialpos); // 처음 위치로 돌아왔다면 stop (못찾음)
		return null;
	}
	
	public void printData(K key) {
		System.out.println(key + "의 data = " + get(key));
	}
	public void printArray() { 
		System.out.println("\n해시 테이블 :");
		for(int i = 0; i < M; i++) 
			System.out.print(i + "\t");
		System.out.println();
		for(int i = 0; i < M; i++)
			System.out.print(a[i] + "\t");
		System.out.println();
	}
	
	
}
