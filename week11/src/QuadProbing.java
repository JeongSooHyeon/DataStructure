public class QuadProbing<K, V> {
	private int N = 0, M = 13; // �׸� ��N, ���̺� ũ��M
	private K[] a = (K[]) new Object[M]; // �ؽ����̺�
	private V[] d = (V[]) new Object[M]; // Key���� ������ ����

	private int hash(K key) { // �ؽ��ڵ�
		return (key.hashCode() & 0x7fffffff) % M; // ������ �Լ�
	}
	
	public void put(K key, V data) { // ���� ����
		int initialpos = hash(key); // �ʱ� ��ġ
		int i = initialpos, j = 1;
		do {
			if(a[i] == null) { // ���� ��ġ �߰�
				a[i] = key;	   // key�� �ؽ����̺� ����
				d[i] = data; N++; // key���� ������ ����
				return;
			}
			if(a[i].equals(key)) { // �̹� key ����
				d[i] = data;	   // data�����͸� ����
			}
			i = (initialpos + j * j++) % M; // i = ���� ��ġ
		}while(N < M);
	}
	
	public V get(K key) { // Ž�� ����
		int initialpos = hash(key);
		int i = initialpos, j = 0;
		while(a[i] != null) { // a[i]�� empty�� �ƴϸ�
			if(a[i].equals(key))
				return d[i];
			i = (initialpos + j * j++) % M; // i = ���� ��ġ
		}
		return null; // Ž�� ����
	}
	
	public void print() {
		System.out.println("\n�ؽ� ���̺�");
		for(int i = 0; i < M; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for(int i = 0; i < M; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}
