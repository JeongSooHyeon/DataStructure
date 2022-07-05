import java.util.Random;
public class DoubleHashing<K, V> {
	private int N = 0, M = 13; // �׸� ��N, ���̺� ũ��M
	private K[] a = (K[]) new Object[M]; // �ؽ����̺�
	private V[] dt = (V[]) new Object[M]; // Key���� ������ ����

	private int hash(K key) { // �ؽ��ڵ�
		return (key.hashCode() & 0x7fffffff) % M; // ������ �Լ�
	}

	public void put(K key, V data) { // ���� ����
		int initialpos = hash(key);
		int i = initialpos;
		int j = 1;
		int d = (7 - (int) key % 7); // �ι�° �ؽ� �Լ�, d(key)=7-key%7
		do {
			if (a[i] == null) { // ���� ��ġ �߰�
				a[i] = key; // key�� �ؽ����̺� ����
				dt[i] = data;
				N++; // key���� ������ ����
				return;
			}
			if (a[i].equals(key)) { // �̹� key ����
				dt[i] = data; // �����͸� ����
				return;
			}
			i = (initialpos + j * d) % M; // i = ���� ��ġ
			j++;
		} while (N < M);
	}

	public V get(K key) { // Ž�� ����
		int initialpos = hash(key); // �ʱ� ��ġ
		int i = initialpos;
		int j = 1;
		int d = (7 - (int) key % 7);
		while (a[i] != null) {
			if (a[i].equals(key))
				return dt[i]; // Ž�� ����
			i = (initialpos + j * d) % M;// i = ���� ��ġ
			j++;
		}
		return null; // Ž�� ����
	}

	public void print() {
		System.out.println("\n�ؽ� ���̺�");
		for (int i = 0; i < M; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for (int i = 0; i < M; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}
