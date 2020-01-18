import java.lang.reflect.Array;

public class CircularQueue<T> {
	
	private static int MAX_SIZE = 40;
	private final static int INDEX_EMPTY = -1;
	
	private T[] elements;
	
	// head and tail index initialized to special character empty
	private int headIndex = INDEX_EMPTY;
	private int tailIndex = INDEX_EMPTY;

	public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException {
		// TODO Auto-generated method stub
		MAX_SIZE = 4;
        
        CircularQueue<Integer> queue = new CircularQueue<>(Integer.class);

        System.out.println("Queue full?: " + queue.isFull());
        System.out.println("Queue empty?: " + queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Queue full?: " + queue.isFull());
        System.out.println("Queue empty?: " + queue.isEmpty());

        queue.enqueue(4);
        System.out.println("Queue full?: " + queue.isFull());
        System.out.println("Queue empty?: " + queue.isEmpty());

        System.out.println("Queue peek: " + queue.peek());

        int data = queue.dequeue();
        System.out.println("Dequeued element: " + data);

        System.out.println("Peek : " + queue.peek());

        data = queue.dequeue();
        System.out.println("Dequeued element: " + data);
        System.out.println("Peek : " + queue.peek());

        try {
            queue.enqueue(4);
            queue.enqueue(5);
            queue.enqueue(6);
        } catch (QueueOverflowException soe) {
            System.out.println("Queue is full! No room available.");
        }

        try {
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
            queue.dequeue();
        } catch (QueueUnderflowException sue) {
            System.out.println("Queue is empty! No elements available.");
        }

	}
	
	CircularQueue(Class<T> clazz){
		elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
	}
	
	public void enqueue(T data) throws QueueOverflowException {
		if(isFull()) {
			throw new QueueOverflowException();
		}
		tailIndex = (tailIndex + 1) % elements.length;
		elements[tailIndex]=data;
		
		// this is the first element enqueued, set head index to the tail index
		if(headIndex == INDEX_EMPTY) {
			headIndex = tailIndex;
		}
		
	}
	
	public T dequeue() throws QueueUnderflowException{
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		T data = elements[headIndex];
		
		// This is the last element in the queue
		if(headIndex==tailIndex) {
			headIndex = INDEX_EMPTY;
			tailIndex = INDEX_EMPTY;
		} else {
			headIndex = (headIndex + 1) % elements.length;
		}
		
		return data;
	}
	
	public T peek() throws QueueUnderflowException{
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		return elements[headIndex];
	}
	
	public Boolean isEmpty() {
		return headIndex==INDEX_EMPTY;
	}
	
	public Boolean isFull() {
		int nextIndex = (tailIndex + 1) % elements.length; 
		
		return nextIndex==headIndex;
	}
	
	public Boolean offer(T data) {
		
		if(isFull()) return false;
		try {
			this.enqueue(data);
		}catch(QueueOverflowException qe) {
			// Ignoring due this will not happen never
		}
		
		return true;	
	}
	
	public static class QueueOverflowException extends Exception{
		
	}
	public static class QueueUnderflowException extends Exception{
		
	}

}
