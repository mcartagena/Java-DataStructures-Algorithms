
public class InsertionBinaryTree{

	public static void main(String [] args){
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);
        Node<Integer> nine = new Node<>(9);

        Node<Integer> head = insertNode(null, five);

        insertNode(head, one);
        insertNode(head, seven);
        insertNode(head, three);
        insertNode(head, eight);
        insertNode(head, two);
        insertNode(head, nine);
        insertNode(head, six);
        insertNode(head, four);

        inOrder(head);

        print(lookup(head, 7));
        print(lookup(head, 12));
		
		print(minValue(head));
		
		print(minValue(null));
		
		System.out.println("Depth Tree: " + maxDepth(head));
		
		mirror(head);
		
		inOrder(head);
		
	}
	
	public static void mirror(Node<Integer> node){
			if(node==null)
				return;
			
			mirror(node.getLeftChild());
			mirror(node.getRightChild());
			
			Node<Integer> temp = node.getLeftChild();
			node.setLeftChild(node.getRightChild());
			node.setRightChild(temp);
			
	}
	
	public static int maxDepth(Node<Integer> node){
		if(node == null)
			return 0;
		
		if(node.getLeftChild() == null && node.getRightChild() == null){
			return 0;			
		}
		
		int maxDepthLeft = 1 + maxDepth(node.getLeftChild());
		int maxDepthRight = 1 + maxDepth(node.getRightChild());
		
		return Math.max(maxDepthLeft,maxDepthRight);
		
	}
	
	public static Node<Integer> minValue(Node<Integer> data){
		if(data == null)
			return null;
		
		if(data.getLeftChild() == null)
			return data;
		
		return minValue(data.getLeftChild());
	}
	
	public static void print(Node<Integer> data){
		if(data == null) {
			System.out.println("Data Not Found...");
			return;
		} 
		
		System.out.println(data.getData() + " found!");
		
	}
	
	public static void inOrder(Node<Integer> root){
		if(root==null){
			return;
		}
		
		inOrder(root.getLeftChild());
		System.out.print(root.getData() + " -> ");
		inOrder(root.getRightChild());
	}
	
	public static Node<Integer> insertNode(Node<Integer> head,Node<Integer> data){
		if(head==null){
			return data;
		}
		
		if(data.getData()<=head.getData()){
			head.setLeftChild(insertNode(head.getLeftChild(),data));
		} else {
			head.setRightChild(insertNode(head.getRightChild(),data));
		}
		
		return head;
	}
	
	public static Node<Integer> lookup(Node<Integer> head,int data){
			if(head == null){
				return null;
			}
			
			if(head.getData()==data){
				return head;
			}
			
			if(data<= head.getData()){
				return lookup(head.getLeftChild(),data);
			} else{
				return lookup(head.getRightChild(),data);
			}
	}
	
	private static class Node<T>{
		T data;
		Node<T> leftChild;
		Node<T> rightChild;
		
		Node(T input){
			data = input;
		}
		
		public T getData(){
			return data;
		}
		
		public void setLeftChild(Node<T> left){
			leftChild = left;
		}
		public Node<T> getLeftChild(){
			return leftChild;
		}
		
		public void setRightChild(Node<T> right){
			rightChild = right;
		}
		public Node<T> getRightChild(){
			return rightChild;
		}			
	}

}