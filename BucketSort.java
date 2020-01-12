import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class BucketSort{
	
	private static int[] listToSort = new int[] {22,45,12,8,10,6,72,81,33,18,50,14};

	public static void main(String[] args){	
		System.out.println("Welcome to BucketSort");
		System.out.println("List To Sort: ");		
		printData(listToSort);

		bucketSort(listToSort);
		System.out.println("Sort List: ");		
		printData(listToSort);	
		
	}
	
	public static void bucketSort(int[] data){
		int n = data.length; // elements number
		int max = findMax(data); // maximum element of the data		
		int numBuckets = bucketSize(n);
		int div = divider(max,numBuckets - 1);  // add 1 for an IndexOutOfBoundsException 
		
		List<List<Integer>> buckets = new ArrayList<>(numBuckets);
		
		for(int i=0; i < numBuckets; i++){
			buckets.add(new ArrayList<>());
		}
		
		// insert in the bucket
		for(int i=0;i<data.length;i++){
			int j = Math.round(data[i]/div);
			buckets.get(j).add(data[i]);
		}
				
		int index = 0;
		// buckets data
		for(List<Integer> e: buckets) {
			insertionSort(e);
			for(Integer ei:e){
				data[index++] = ei;
			}
		}		
	}
	
	public static int findMax(int[] data){
		int m = Integer.MIN_VALUE;
		for(int e:data){
			if(m < e)
				m = e;
		}
		return m;
	}
	
	public static void printData(int[] data){
		System.out.println("Elements: " + Arrays.toString(data));
	}
	
	public static int divider(int max,int lenghtBucket){
		int divider = (int) Math.round((max + 1)/lenghtBucket);
		return divider;
	}
	
	public static int bucketSize(int sizeListToSort){
			return ((int) Math.sqrt(sizeListToSort) + 1);
	}
	
	public static void swapData(List<Integer> data, int origin, int target) {
		Integer temp = data.get(origin);
		data.set(origin,data.get(target));
		data.set(target,temp);
	}
	
	public static void insertionSort(List<Integer> data){
		for(int i=0;i < data.size() - 1; i++){
			for(int j = i + 1; j > 0; j--) {
				if(data.get(j) < data.get(j-1)){
					swapData(data,j-1,j);
				} else {
					break;
				}
			}
		}
	}

}