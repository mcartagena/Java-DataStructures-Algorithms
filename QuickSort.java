import java.util.Arrays;

public class QuickSort {
	
	private static Integer [] listToSort = new Integer[] {3, 5, 6, 8, 10, 1, 2, 4, 7, 9};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        printData(listToSort);
        quickSort(listToSort, 0, listToSort.length - 1);
        printData(listToSort);		

	}
	
	private static void printData(Integer [] data) {
		System.out.println("This is the Array: " + Arrays.deepToString(data));
	}	
	
	private static void swapData(Integer [] data, int origin, int target) {
		Integer temp = data[origin];
		data[origin] = data[target];
		data[target] = temp;
	}
	
	private static void quickSort(Integer[] data, int low, int high) {
		if(low>=high) {
			return;
		}
		
		int pivote = pivotePartition(data,low,high);
		
		quickSort(data,low,pivote - 1);
		quickSort(data,pivote + 1,high);
		
	}
	
	private static int pivotePartition(Integer [] data, int low, int high) {
		int pivote = data[low];
		int l = low;
		int h = high;
		
		while(l < h) {
			while(data[l] <= pivote && l < h ) {
				l++;
			}
			while(data[h] > pivote) {
				h--;
			}
			if(l<h) {
				swapData(data,l,h);
			}
		}
		swapData(data,low,h);
		
		System.out.println("Pivote es: " + pivote);
		printData(data);
		
		return h;
		
	}

}
