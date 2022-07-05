public class LinearProbing<K, V> { 
	private int M = 13; // ���̺� ũ��
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
				a[i] = key;
				d[i] = data;
				return;
			}
			if(a[i].equals(key)) { // �̹� key ����
				d[i] = data;
				return;
			}
			i = (initialpos + j++) % M; // i = ���� ��ġ
		}while(i != initialpos);
	}
	public V get(K key) { // Ž�� ����
		int initialpos = hash(key);
		int i = initialpos, j = 1;
		do {
			if(a[i].equals(key)) return d[i];
			i = (initialpos + j++) % M;
		}while(a[i] != null // a[i] �� null(=�������)�̸� stop (��ã��)
				&& i != initialpos); // ó�� ��ġ�� ���ƿԴٸ� stop (��ã��)
		return null;
	}
	
	public void printData(K key) {
		System.out.println(key + "�� data = " + get(key));
	}
	public void printArray() { 
		System.out.println("\n�ؽ� ���̺� :");
		for(int i = 0; i < M; i++) 
			System.out.print(i + "\t");
		System.out.println();
		for(int i = 0; i < M; i++)
			System.out.print(a[i] + "\t");
		System.out.println();
	}
	
	
}
