import java.util.LinkedList;

public class main {
	public static void main(String[] args) {
		BinaryTree<Integer> tA = new BinaryTree<Integer>();		
		BinaryTree<Integer> tB = new BinaryTree<Integer>();		
		Node<Integer> roota = new Node<Integer>(100, 
					new Node<Integer>(200, 
					new Node<Integer>(400, new Node<Integer>(800, null, null), null),
					new Node<Integer>(500, null, null)), 
					new Node<Integer>(300,
					new Node<Integer>(600, null, null), new Node<Integer>(700, null, null))
					);
		
		Node<Integer> rootb = new Node<Integer>(1, 
				new Node<Integer>(2, 
				new Node<Integer>(300, new Node<Integer>(600, null, null), new Node<Integer>(700, null, null)),
				new Node<Integer>(7, null, null)), 
				new Node<Integer>(3,
				new Node<Integer>(9, null, null), new Node<Integer>(70, null, null))
				);
		
		tA.setRoot(roota);
		tB.setRoot(rootb);
		
		LinkedList<Node> list = new LinkedList<Node>();
		list = tA.subTreeCompare(tB);
		for(int i = 0; !list.isEmpty(); i++) {
			System.out.println("Found a matching subtree " + (i+1) + ":");
			tA.levelorder(list.pop());
			System.out.println();
		}
		
		
		
		
		
		/*
		int barr[] = t1.btree2intarr();
		
		BinaryTree<Integer> tnew = new BinaryTree<Integer>();				
		tnew.intarr2btree(barr);
		System.out.print("레벨순회: ");tnew.levelorder(root);
		System.out.println();
		*/	
		
		
		/*
		System.out.println("btree -> arr :");
		int barr[] = t1.btree2intarr();
		for(int i = 1; i < barr.length; i++ ){			
			System.out.print(barr[i] + " ");			
		}
		*/
		
		
		/*
		BinaryTree<Integer> t2 = new BinaryTree<Integer>();
		Node<Integer> root2 = new Node<Integer>(100, 
				new Node<Integer>(200, 
				new Node<Integer>(400, new Node<Integer>(800, null, null), null),
				new Node<Integer>(500, null, null)), 
				new Node<Integer>(300,
				new Node<Integer>(600, null, null), new Node<Integer>(700, null, null))
				);
		t2.setRoot(root2);
		
		System.out.print("트리 노드 수: ");	System.out.print(t1.size(root));
		System.out.println();
		System.out.print("트리 높이: "); System.out.print(t1.height(root));
		System.out.println();
		System.out.print("전위순회: ");	t1.preorder(root);
		System.out.println();
		System.out.print("중위순회: ");t1.inorder(root);
		System.out.println();
		System.out.print("후위순회: ");t1.postorder(root);
		System.out.println();
		System.out.print("레벨순회: ");t1.levelorder(root);
		System.out.println();
		System.out.print("동일성 검사: "); System.out.print(t1.isEqual(root, root2));*/

	}

}
