import java.util.Queue;
import java.util.ArrayDeque;;

public class BreadthFirstTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

        breadthFirst(a);

	}
	
	public static <T> void printData(Node<T> dataNode) {
		System.out.print(dataNode.getData() + " -> ");
	}
	
	public static <T> void breadthFirst(Node<T> root) {
		if(root == null) {
			return;
		}
		Queue<Node> qe = new ArrayDeque();
		
		qe.offer(root);
		
		while(!qe.isEmpty()) {
			Node<T> data = qe.poll();
			printData(data);
			if(data.getLeftChild() != null) {
				qe.offer(data.getLeftChild());	
			}
			if(data.getRightChild() != null) {
				qe.offer(data.getRightChild());
			}
		}
	}
	
	public static class Node<T>{
		private T data;
		private Node<T> leftChild;
		private Node<T> rightChild;
		
		public Node(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}

		public Node<T> getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(Node<T> leftChild) {
			this.leftChild = leftChild;
		}

		public Node<T> getRightChild() {
			return rightChild;
		}

		public void setRightChild(Node<T> rightChild) {
			this.rightChild = rightChild;
		}
		
	}

}
