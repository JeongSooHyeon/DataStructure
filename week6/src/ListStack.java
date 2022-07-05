import java.util.EmptyStackException;

public class ListStack<E> {
	private Node<E> top;
	private int size;

	public ListStack() {
		top = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E peek() {
		if (isEmpty())
			throw new EmptyStackException();
		return (E) top.getItem();
	}

	public void push(E newItem) {
		Node newNode = new Node(newItem, top);
		top = newNode;
		size++;
	}

	public E pop() {
		if (isEmpty())
			throw new EmptyStackException();
		E topItem = top.getItem();
		top = top.getNext();
		size--;
		return topItem;
	}

	public void print() {
		Node nd = top;
		for (int i = 0; i < size; i++) {
			System.out.print(nd.getItem() + "\t");
			nd = nd.getNext();
		}
		System.out.println();
	}

	public double calc(String[] s) {
		ListStack<Double> stack = new ListStack<Double>();
		double n1, n2;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == "+" || s[i] == "-" || s[i] == "*" || s[i] == "/") {
				n1 = stack.pop();
				n2 = stack.pop();

				switch (s[i]) {
				case "+":
					stack.push(n2 + n1);
					break;
				case "/":
					stack.push(n2 / n1);
					break;
				case "*":
					stack.push(n2 * n1);
					break;
				case "-":
					stack.push(n2 - n1);
					break;
				}
			}
			// 숫자면
			else
				stack.push(Double.parseDouble(s[i]));
		}
		return stack.peek();
	}

	public String getPostEq(String s) {
		String str = "";
		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			// 연산자, 왼쪽 괄호
			if (arr[i] == '*' || arr[i] == '/' || arr[i] == '+' || arr[i] == '-' ||
					arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
				if ((arr[i] == '+' || arr[i] == '-') && !this.isEmpty()) {
					while((char)this.peek() == '*' ||(char)this.peek() == '/') // 우선 순위가 높아
						this.pop();
				}
				this.push((E) (Object) arr[i]);
				continue;
			}
			// 오른쪽 괄호
			else if (arr[i] == ')' || arr[i] == '}' || arr[i] == ']') {
				char ch = ' ';
				switch (arr[i]) {
				case ')':
					ch = '(';
					break;
				case '}':
					ch = '{';
					break;
				case ']':
					ch = '{';
					break;
				}
				// 왼쪽 괄호 나올 때 까지 pop 출력
				while ((char) this.peek() != ch) 
					str += (char) this.pop();
					
				this.pop(); // 왼쪽 괄호 나오면 pop
				continue;
			}
			// 피연산자 출력
			else
				str += arr[i];
		}

		while (!isEmpty()) 
			str += (char) this.pop();		

		return str;
	}
}
