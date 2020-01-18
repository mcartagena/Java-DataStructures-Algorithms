import java.util.Arrays;

/*
 * 
 */

public class SelectionSort {
	
	private static Integer listToSort[] = new Integer[] {4, 5, 6, 2, 1, 7, 10, 3, 8, 9};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printData(listToSort);
		selectionSort(listToSort);

	}
	
	private static void printData(Integer [] data) {
		System.out.println("The array is: " + Arrays.deepToString(data));
		
	}
	private static void swapData(Integer [] data, int origin, int target) {
		Integer temp = data[origin];
		data[origin] = data[target];
		data[target] = temp;
		
	}
	private static void selectionSort(Integer [] data) {
		
		for(int i=0;i < data.length;i++) {
			for (int j=i+1; j < data.length; j++) {
				if(data[i]>data[j]) {
					swapData(data,i,j);
				}
			}
			printData(data);
		}		
	}

}
