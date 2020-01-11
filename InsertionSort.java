
public class InsertionSort{
	private static int[] dataToSort = new int[]{3, 5, 6, 8, 10, 1, 2, 4, 7, 9};
	
	public static void main(String[] args){
		System.out.println("Welcome to Insertion Sort");
		
		printData(dataToSort);
		
		insertionSort(dataToSort);
		
		printData(dataToSort);
	}
	
	public static void printData(int[] data){
		
		System.out.print("Elements: ");

		for(int e: data){
			System.out.print(e + " ");
		}

		System.out.println();
	}
	
	public static void swapData(int[] data, int origin, int target){
		int temp = data[origin];
		data[origin] = data[target];
		data[target] = temp;
	}
	
	public static void insertionSort(int[] data){
		
		for(int i=0;i < data.length - 1; i++){
			for(int j=i+1;j>0;j--){
				if(data[j] < data[j-1]){
					swapData(data,j-1,j);
				} else {
					break;
				}
			}
			printData(data);
		}
		
	}
	
	
}