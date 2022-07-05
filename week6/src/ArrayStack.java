import java.util.EmptyStackException;

public class ArrayStack<E> {
	private E s[]; // ������ ���� �迭
	private int top; // ������ top �׸��� �ſ� ���� �ε���

	public ArrayStack() { // ���� ������
		s = (E[]) new Object[1]; // �ʱ⿡ ũ�Ⱑ 1�� �迭 ����
		top = -1; // ����ִ�
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public E peek() { // ���� top �׸��� ���븸�� ����
		if (isEmpty())
			throw new EmptyStackException();
		return s[top];
	}

	public void push(E newItem) {
		if (size() == s.length)
			resize(2 * s.length);
		s[++top] = newItem;
	}

	public E pop() {
		if (isEmpty())
			throw new EmptyStackException();
		E item = s[top];
		s[top--] = null;
		if (size() > 0 && size() == s.length / 4)
			resize(s.length / 2);
		return item;
	}

	public void resize(int n) {
		Object[] t = new Object[n];
		for (int i = 0; i < size(); i++) {
			t[i] = s[i];
		}
		s = (E[]) t;
	}

	public void print() {
		for (int i = 0; i < top + 1; i++)
			System.out.print(s[i] + "\t");
		System.out.println();
	}

	public boolean checkPalindrome(String s) {
		char[] arr = s.toCharArray();
		int n = arr.length / 2;
		for (int i = 0; i < n; i++) {
			this.push((E) (Object) arr[i]);
		}
		if (arr.length % 2 != 0)
			n = arr.length / 2 + 1;

		for (int i = n; i < arr.length; i++) {
			if ((char) this.peek() == arr[i])
				this.pop();
			else
				return false;
		}
		return true;
	}

	public boolean checkParentheses(String s) {
		char[] arr = s.toCharArray(); // String -> char �迭��

		for (int i = 0; i < arr.length; i++) {
		switch (arr[i]) {
			// ���� ��ȣ push
			case '(':
			case '{':
			case '[':
				this.push((E) (Object) arr[i]);
				break;

			// ������ ��ȣ pop
			case ')':
				if (isEmpty())
					return false;
				if ((char) peek() == '(') {
					this.pop();
				} else
					return false;
				break;
			case '}':
				if (isEmpty())
					return false;
				if ((char) peek() == '{') {
					this.pop();
				} else
					return false;
				break;
			case ']':
				if (isEmpty())
					return false;
				if ((char) peek() == '[') {
					this.pop();
				} else
					return false;
				break;
			default:
				break;
			}
		}
		if (top == -1)
			return true;
		else
			return false;
	}

}
