import java.util.Queue;
import java.util.*;

public class BinaryTree<Key extends Comparable<Key>> {
	private Node root;

	public BinaryTree() {
		root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node newRoot) {
		root = newRoot;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void preorder(Node n) { // 전위순회
		if (n != null) {
			System.out.print(n.getKey() + " ");
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}

	public void inorder(Node n) { // 중위순회
		if (n != null) {
			inorder(n.getLeft());
			System.out.print(n.getKey() + " ");
			inorder(n.getRight());
		}
	}

	public void postorder(Node n) { // 후위순회
		if (n != null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			System.out.print(n.getKey() + " ");
		}
	}

	public void levelorder(Node root) { // 레벨순회
		Queue<Node> q = new LinkedList<Node>();
		Node t;
		q.add(root);
		while (!q.isEmpty()) {
			t = q.remove();
			System.out.print(t.getKey() + " ");
			if (t.getLeft() != null)
				q.add(t.getLeft());
			if (t.getRight() != null)
				q.add(t.getRight());
		}
	}

	public int size(Node n) { // 노드 수
		if (n == null)
			return 0;
		else
			return (1 + size(n.getLeft()) + size(n.getRight()));
	}

	public int height(Node n) { // 트리 높이
		if (n == null)
			return 0;
		else
			return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
	}

	public int[] btree2intarr() {
		int[] barr = new int[size(root) + 1];
		Queue<Node> q = new LinkedList<Node>();

		Node t;
		int cnt = 0; // 배열에 들어간 원소 갯수
		int i = 1; // 배열 인덱스

		q.add(root);
		t = q.remove();
		barr[i] = (int) t.getKey();
		cnt++;

		Node ln, rn;
		for (int j = i, k = i; cnt < barr.length - 1; i++) {
			if (i > 1)
				t = q.remove();

			if (t.getLeft() != null) {
				q.add(t.getLeft());
				ln = t.getLeft();
				j = i * 2; // 2, 4, 6, 8
				barr[j] = (int) ln.getKey();
				cnt++;
			}
			if (t.getRight() != null) {
				q.add(t.getRight());
				rn = t.getRight();
				k = i * 2 + 1; // 3, 5, 7, 9
				barr[k] = (int) rn.getKey();
				cnt++;
			}
		}
		return barr;
	}

	/*
	 * public int[] btree2intarr() { int[] barr = new int[size(root) + 1];
	 * btree2intarr(barr, root, 0, 0); return barr; }
	 * 
	 * public int[] btree2intarr(int[] barr, Node now, int i, int k) { barr[(int)
	 * Math.pow(2, i) + k] = (int) now.getKey();
	 * 
	 * if (now.getLeft() != null) { btree2intarr(barr, now.getLeft(), i + 1, k * 2);
	 * } if (now.getRight() != null) { btree2intarr(barr, now.getRight(), i + 1, k *
	 * 2 + 1); } return barr; }
	 */

	public void intarr2btree(int[] arr) {
		Queue<Node> q = new LinkedList<Node>();
		Queue<Node> bq = new LinkedList<Node>(); // 완료된 이진트리 노드 queue
		Node left = null, right = null;
		Node t;

		this.setRoot(new Node(arr[1], null, null)); // 모든 노드 삭제 및 root노드 생성
		q.add(root);

		for (int i = 1; i < arr.length; i++) {
			t = q.remove(); // 하나 꺼내

			if (2 * i < arr.length) { // 왼쪽 자식 node
				left = new Node(arr[2 * i], null, null);
				q.add(left);
			}
			if (2 * i + 1 < arr.length) { // 오른쪽 자식
				right = new Node(arr[2 * i + 1], null, null);
				q.add(right);
			}

			if (left == null && right == null)
				break;

			t.setLeft(left);
			t.setRight(right); // 자식 지정
			bq.add(t); // 자식 설정 완료 노드 넣어주기
			left = null;
			right = null; // 자식들 초기화
		}
	}

	/*
	 * public void intarr2btree(int[] arr) { // BinaryTree<Integer> tN = new
	 * BinaryTree<Integer>(); root = new Node(arr[1], null, null);
	 * intarr2btree(root, arr, 1, arr.length); }
	 * 
	 * public void intarr2btree(Node parent, int[] arr, int i, int size) { if (2 * i
	 * < size) { Node<Integer> l_n = new Node<>(arr[2 * i], null, null);
	 * parent.setLeft(l_n); intarr2btree(l_n, arr, 2 * i, size); } if (2 * i + 1 <
	 * size) { Node<Integer> r_n = new Node<>(arr[2 * i + 1], null, null);
	 * parent.setRight(r_n); intarr2btree(r_n, arr, 2 * i + 1, size); } }
	 */

	public void printArr() {
		int[] arr = btree2intarr();
		for (int i = 1; i < size(root) + 1; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static boolean isEqual(Node n, Node m) {
		if (n == null || m == null)
			return n == m;

		if (n.getKey().compareTo(m.getKey()) != 0)
			return false;

		return (isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight()));
	}

	public Queue<Node> makeBTQ(Queue<Node> q, Node n) { // q로 만들기
		if (n != null) {
			q.add(n);
			makeBTQ(q, n.getLeft());
			makeBTQ(q, n.getRight());
		}
		return q;
	}

	public LinkedList<Node> subTreeCompare(BinaryTree t) {
		int tsize = t.size(t.root);
		LinkedList<Node> list = new LinkedList<Node>();
		Queue<Node> q = new LinkedList<Node>();
		q = makeBTQ(q, root);
		Queue<Node> tq = new LinkedList<Node>();
		tq = t.makeBTQ(tq, t.root);

		Node a;
		Node b = tq.remove();
		tq.add(b);
		for (int i = 0; !q.isEmpty(); i++) {
			a = q.remove();
			for (int j = 0; j < tsize; j++) {
				if (isEqual(a, b)) {
					list.add(a);
				}
				b = tq.remove();
				tq.add(b);

			}
		}
		return list;
	}

	/*
	 * public LinkedList<Node> subTreeCompare(BinaryTree t) { LinkedList<Node> list
	 * = new LinkedList<Node>(); int[] carr; carr = t.btree2intarr(); // 비교할 트리 배열로
	 * subTreeCompare(root, carr, 1, list);
	 * 
	 * return list; }
	 * 
	 * public void subTreeCompare(Node n, int[] carr, int i, LinkedList<Node> list)
	 * { if ((int) n.getKey() == carr[i]) { list.add(n); } if (i < carr.length - 1)
	 * subTreeCompare(n, carr, i + 1, list); else if (i == carr.length - 1) { if
	 * (n.getLeft() != null) subTreeCompare(n.getLeft(), carr, 1, list); if
	 * (n.getRight() != null) subTreeCompare(n.getRight(), carr, 1, list); } }
	 */
}
