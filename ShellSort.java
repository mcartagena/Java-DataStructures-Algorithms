import java.util.Arrays;

public class ShellSort {

	private static Integer [] listToSort = {3, 5, 6, 8, 10, 1, 2, 4, 7, 9};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printData(listToSort);
		shellSort(listToSort);

	}
	
	private static void printData(Integer [] data) {
		System.out.println("This is the Array: " + Arrays.deepToString(data));
	}
	
	private static void swapData(Integer[] data,int origin,int target) {
		Integer temp = data[origin];
		data[origin] = data[target];
		data[target] = temp;
	}
	
	private static void shellSort(Integer [] data) {
		int increment = data.length/2;
		while(increment>0){
			for(int startIndex = 0;startIndex<increment;startIndex++){
				insertionSort(data,startIndex,increment);				
			}
			increment = increment/2;
		}
	}
	
	private static void insertionSort(Integer [] data, int startIndex, int increment) {
		
		for(int i = startIndex; i < data.length; i = i + increment) {
			for(int j = Math.min(i + increment, data.length - 1 ); j-increment >= 0; j = j - increment) {
				if(data[j]<data[j-increment]) {
					swapData(data,j,j-increment);
				} else {
					break;
				}
			}
			printData(data);
		}
		
	}
	

}

