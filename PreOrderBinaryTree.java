
public class PreOrderBinaryTree{
	
	public final static void main(String... Arg){
		
		//PreOrderBinaryTree btree = new PreOrderBinaryTree();

		/*
        PreOrderBinaryTree.Node<Character> a = btree.new Node<>('A');
        PreOrderBinaryTree.Node<Character> b = btree.new Node<>('B');
        PreOrderBinaryTree.Node<Character> c = btree.new Node<>('C');
        PreOrderBinaryTree.Node<Character> d = btree.new Node<>('D');
        PreOrderBinaryTree.Node<Character> e = btree.new Node<>('E');
        PreOrderBinaryTree.Node<Character> f = btree.new Node<>('F');
        PreOrderBinaryTree.Node<Character> g = btree.new Node<>('G');
        PreOrderBinaryTree.Node<Character> h = btree.new Node<>('H');
        PreOrderBinaryTree.Node<Character> x = btree.new Node<>('X');  */
		
        Node<Character> a = new Node<>('A');
        Node<Character> b = new Node<>('B');
        Node<Character> c = new Node<>('C');
        Node<Character> d = new Node<>('D');
        Node<Character> e = new Node<>('E');
        Node<Character> f = new Node<>('F');
        Node<Character> g = new Node<>('G');
        Node<Character> h = new Node<>('H');
        Node<Character> x = new Node<>('X');		

        a.setLeftChild(b);
        a.setRightChild(c);
        c.setLeftChild(d);
        c.setRightChild(e);
        d.setLeftChild(f);
        d.setRightChild(h);
        e.setRightChild(g);
        b.setLeftChild(x);
		
		System.out.println("Tree of nine nodes: ");
		
		a.setLeftChild(b);
		a.setRightChild(c);
		//a.preOrderBinaryTree(a);
		preOrderBinaryTree(a);
			
	}

	public static void preOrderBinaryTree(Node<Character> root){
		if(root == null){
			return;
		}
		
		System.out.print(root.getData() + " -> ");
		preOrderBinaryTree(root.getLeftChild());
		preOrderBinaryTree(root.getRightChild());
		
	}
		
	private static class Node<T>{
		private T data;
		Node<T> leftChild;
		Node<T> rightChild;
		
		Node(T input){
			this.data = input;
		}
		
		public T getData(){
			return this.data;
		}
		
		public void setLeftChild(Node<T> left){
				this.leftChild = left;
		}
		public Node<T> getLeftChild(){
			return this.leftChild;
		}
		
		public void setRightChild(Node<T> right){
				this.rightChild = right;
		}
		public Node<T> getRightChild(){
			return this.rightChild;
		}	
						
	}
}