import java.util.Arrays;

public class MergeSort {
	
	private static Integer [] listToSort = new Integer[] {4, 5, 6, 2, 1, 7, 10, 3, 8, 9};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        printData(listToSort);
        mergeSort(listToSort);		

	}
	
	private static void printData(Integer [] data) {
		System.out.println("This is the Array: " + Arrays.deepToString(data));
	}
	
	private static void mergeSort(Integer[] data) {
		
		if(data.length == 1) 
			return;
		
		int mid = data.length/2 + data.length%2;
		Integer firstList [] = new Integer [mid];
		Integer secondList [] = new Integer [data.length-mid];
			
		split(data,firstList,secondList);
		
		printData(firstList);
		printData(secondList);
		
		mergeSort(firstList);
		mergeSort(secondList);
		
		merge(data,firstList,secondList);
		
		printData(data);
				
	}
	
	
	private static void split(Integer [] data, Integer [] firstList, Integer [] secondList) {
		
		int index = 0;
		int secondHalfStartIndex = firstList.length;
		
		for(int element : data) {
			if(index < secondHalfStartIndex) {
				firstList[index] = element;
			} else {
				secondList[index - secondHalfStartIndex] = element;
			}
			index++;
		}
				
	}
	
	private static void merge(Integer[] data, Integer [] firstList, Integer [] secondList) {
		int startIndex = 0;
		int startIndexFirst = 0;
		int startIndexSecond = 0;
		
		while (startIndexFirst < firstList.length && startIndexSecond < secondList.length) {
			if(firstList[startIndexFirst] < secondList[startIndexSecond]) {
				data[startIndex] = firstList[startIndexFirst];
				startIndexFirst++;
			} else if (startIndexSecond < secondList.length){
				data[startIndex] = secondList[startIndexSecond];
				startIndexSecond++;
			}
			startIndex++;
		}		
		
		while(startIndexFirst < firstList.length) {
			data[startIndex] = firstList[startIndexFirst];
			startIndex++;
			startIndexFirst++;
		}
		while(startIndexSecond < secondList.length) {
			data[startIndex] = secondList[startIndexSecond];
			startIndex++;
			startIndexSecond++;			
		}		
	}

}
