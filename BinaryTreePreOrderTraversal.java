public class BinaryTreePreOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Character> a = new Node("A");
		printData(a);

	}
	
	public static <T> void printData(Node<T> dataNode) {
		System.out.println(dataNode.getData() + " -> ");
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
