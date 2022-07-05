import java.util.Random;
public class RandProbing<K, V> {
	private int N = 0, M = 13; // �׸� ��N, ���̺� ũ��M
	private K[] a = (K[]) new Object[M]; // �ؽ����̺�
	private V[] d = (V[]) new Object[M]; // Key���� ������ ����

	private int hash(K key) { // �ؽ��ڵ�
		return (key.hashCode() & 0x7fffffff) % M; // ������ �Լ�
	}
	
	public void put(K key, V data) { // ���� ����
		int initialpos = hash(key);
		int i = initialpos;
		Random rand = new Random();
		rand.setSeed(10);
		do {
			if(a[i] == null) { // ���� ��ġ �߰�
				a[i] = key;    // key�� �ؽ����̺� ����
				d[i] = data; N++; // key���� ������ ����
				return;
			}
			if(a[i].equals(key)) { // �̹� key ����
				d[i] = data; // �����͸� ����
				return;
			}
			i = (initialpos + rand.nextInt(1000)) % M; // i = ���� ��ġ
		}while(N < M);
	} 
	
	public V get(K key) { // Ž�� ����
		Random rand = new Random();
		rand.setSeed(10); // ���Զ��� ���� seed�� ���
		int initialpos = hash(key); //                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		int i = initialpos;
		while(a[i] != null) {
			if(a[i].equals(key))
				return d[i]; // Ž�� ����
			i = (initialpos + rand.nextInt(1000)) % M; // i = ���� ��ġ
		}
		return null; // Ž�� ����
	}
	public void print() {
		System.out.println("�ؽ� ���̺�");
		for(int i = 0; i < M; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for(int i = 0; i < M; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}
