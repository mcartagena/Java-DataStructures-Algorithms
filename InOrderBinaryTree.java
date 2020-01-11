
public class InOrderBinaryTree{
	
	public final static void main(String... Arg){
				
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
		
		inOrderBinaryTree(a);
		
		// Tree of nine nodes:
        // X -> B -> A -> F -> D -> H -> C -> E -> G ->

	}

	public static void inOrderBinaryTree(Node<Character> root){
		if(root == null){
			return;
		}
				
		inOrderBinaryTree(root.getLeftChild());
		System.out.print(root.getData() + " -> ");  // process the node
		inOrderBinaryTree(root.getRightChild());
		
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