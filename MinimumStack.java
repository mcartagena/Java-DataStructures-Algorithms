import java.util.Stack;
import java.util.EmptyStackException;

/*
 * Find the minimum element in a stack in constant time
 */

public class MinimumStack {
	
	Stack<Integer> minStack = new Stack();
	Stack<Integer> dataStack = new Stack();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumStack minimumStack = new MinimumStack();
        minimumStack.push(2);
        minimumStack.push(4);
        minimumStack.push(10);

        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.push(1);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.push(0);
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());

        minimumStack.pop();
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.pop();
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());
        minimumStack.pop();
        System.out.println("Minimum so far is: " + minimumStack.getMinimum());		

	}

	public void push(Integer input) {		
		Integer min = input;
		if(!minStack.isEmpty()) {
			if(min.compareTo(minStack.peek())>=0) {
				min = minStack.peek();
			}
		}
		minStack.push(min);
		dataStack.push(input);
		
	}
	
	public Integer getMinimum() {
		return minStack.peek();
	}
	
	public Integer pop() throws EmptyStackException {
		minStack.pop();
		return dataStack.pop();
	}
}
