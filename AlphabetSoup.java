import java.util.Arrays;

/*
 * Have the function AlphabetSoup(str) take the str string parameter
 * being passed and return the string with the letters in alphabetical
 * order (ie hello becomes ehllo).  Assume numbers and punctuation symbols
 * will not be included in the string.
 */
public class AlphabetSoup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		alphabetSoup("coderbyte");

	}
	
	public static void alphabetSoup(String str) {
		char[] data = str.toCharArray(); 
		char[] data2 = str.toCharArray();
		
		quickSort(data,0,data.length - 1);
		
		printData(data);
		
		Arrays.sort(data2);
		
		printData(data2);
	}
	
	public static void printData(char[] data){
		System.out.println("Este es el string: " + new String(data));
	}
	
	public static void quickSort(char[] data, int low, int high) {
		if(low >= high) {
			return;
		}
		
		int pivote = partitionPivote(data, low, high);
		
		quickSort(data, low, pivote -1);
		quickSort(data, pivote + 1, high);
		
	}
	
	public static void swapData(char[] data,int origin,int target) {
		char temp = data[origin];
		data[origin] = data[target];
		data[target] = temp;
	}
	
	public static int partitionPivote(char[] data, int low, int high) {
		
		char pivote = data[low];
		int l = low;
		int h = high;
		
		while(l< h){
			while(data[l]<=pivote && l < h) {
				l++;
			}
			while(data[h]>pivote) {
				h--;
			}
			if(l<h) {
				swapData(data,l,h);
			}
		}
		swapData(data,low,h);
		
		return h;
	}

}
