import java.util.Arrays;

public class BublleSort {

	private static Integer [] listToSort = {3, 5, 6, 8, 10, 1, 2, 4, 7, 9};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bubbleSort(listToSort);

	}
	
	private static void printData(Integer [] data) {
		System.out.println("This is the Array: " + Arrays.deepToString(data));
	}
	
	private static void swapData(Integer[] data,int origin,int target) {
		Integer temp = data[origin];
		data[origin] = data[target];
		data[target] = temp;
	}
	
	private static void bubbleSort(Integer [] data) {
		
		Boolean swapped = false;
		
		for(int i=0; i < data.length; i++) {
			swapped = false;
			for(int j = (data.length - 1); j > i; j--) {
				if(data[j] < data [j-1]) {
					swapData(data,j,j-1);
					swapped = true;
				}
			}
			printData(data);
			if(!swapped) break;
		}
	}

}
