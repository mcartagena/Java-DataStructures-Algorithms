/**
 * John works at a clothing store. He has a large pile of socks that he must pair by color for sale. 
 * Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
 * 
 * For example, there are  socks with colors . There is one pair of color  and one of color . There are three odd socks left, 
 * one of each color. The number of pairs is .
 * 
 * Function Description
 * 
 * Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs 
 * of socks that are available.
 * 
 * sockMerchant has the following parameter(s):
 * 
 * n: the number of socks in the pile
 * ar: the colors of each sock
 * 
 * Input Format
 * 
 * The first line contains an integer , the number of socks represented in .
 * 
 * The second line contains  space-separated integers describing the colors  of the socks in the pile.
 * 
 * Constraints
 * 
 * where
 * 
 * Output Format
 * 
 * Return the total number of matching pairs of socks that John can sell.
 * 
 * Sample Input
 * 9
 * 10 20 20 10 10 30 50 10 20
 * 
 * Sample Output 
 * 3
 * 
 * @author mcartage
 *
 */

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.Arrays;
import java.util.Scanner;

public class SockMerchant {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		int[] arInt = new int[n]; 
		
		String input = sc.nextLine();
		
		String[] ar = input.split(" ");
		
		for(int i=0;i<ar.length;i++) {
			arInt[i] = Integer.parseInt(ar[i]);
		}
		
		System.out.println("Data In: n " + n + " array " + Arrays.toString(ar));
		System.out.println("Data In Parsed: n " + n + " array " + Arrays.toString(arInt));
		System.out.println(sockMerchant(n,arInt));

	}
	
	public static int sockMerchant(int n, int[] ar) {
		
		ConcurrentMap<Integer,LongAdder> cm = new ConcurrentHashMap<>();
		
		for(int e:ar) {
			cm.computeIfAbsent(e, num -> new LongAdder()).increment();
		}
		
		int[] count = {0};
		
		cm.forEach((k,v) -> {
			count[0] = count[0] + v.intValue()/2;
		});
		
		return count[0];
	}

}
