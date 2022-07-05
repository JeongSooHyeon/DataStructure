import java.util.EmptyStackException;

public class ArrayStack<E> {
	private E s[]; // 스택을 위한 배열
	private int top; // 스택의 top 항목의 매열 원소 인덱스

	public ArrayStack() { // 스택 생성자
		s = (E[]) new Object[1]; // 초기에 크기가 1인 배열 생성
		top = -1; // 비어있다
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public E peek() { // 스택 top 항목의 내용만을 리턴
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
		char[] arr = s.toCharArray(); // String -> char 배열로

		for (int i = 0; i < arr.length; i++) {
		switch (arr[i]) {
			// 왼쪽 괄호 push
			case '(':
			case '{':
			case '[':
				this.push((E) (Object) arr[i]);
				break;

			// 오른쪽 괄호 pop
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
