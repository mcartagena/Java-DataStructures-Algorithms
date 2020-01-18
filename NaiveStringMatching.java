import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 
 * The Brute-Force algorithm is really suboptimal.  The inefficiency stems from ignoring information
 * that has already been gained about the substring for one value of shift. Now, when considering all the possible values of shift
 * so it really is inefficient.  Now, it's super simple search liquid, I just demonstrated the text is small nothing too complicated
 * O(nm-m2) => O(m2)
 * 
 * 
 */
public class NaiveStringMatching {

	public static void main(String[] args) {
		// Save current date-time in UTC

		Instant start = Instant.now();
		
		String fullText = "";

		try (FileReader myReader = new FileReader(
				"/Users/mcartage/eclipse-workspace/9781789805819_Code/Hands-On-Data-Structures-Algorithms-in-Java-11-Section2/sourcefile.txt");
				Scanner scan = new Scanner(myReader);) {

			while (scan.hasNextLine()) {
				fullText = fullText + scan.nextLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Something when wrong.");
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Something happen.");
			e1.printStackTrace();
		}
		
		String thePattern = "ipsum";

		NaiveStringMatching nbf = new NaiveStringMatching();
		nbf.matching(fullText, thePattern);
		
		// Save current date-time in UTC
		Instant end = Instant.now();
		System.out.println();
		System.out.println("Start time: " + start);
		System.out.println("End time: " + end);
		System.out.println("Time elapsed: " + Duration.between(start, end).toMillis() + " milliseconds.");

	}
	
	public void matching(String s, String c) {
		
		int n = s.length();
		int m = c.length();
		
		List<Integer> offset = new ArrayList<Integer>();
		
		Boolean result = false;
		
		for(int shift = 0; shift <= n-m; shift++)
			if(c.charAt(0) == s.charAt(shift)){
				// System.out.println("Es igual en " + shift);
				result = true;
				for(int innerShift= 0; innerShift < m; innerShift++) {
					if(c.charAt(innerShift)!= s.charAt(innerShift + shift)) {
						//System.out.println("Es diferente en " + innerShift);
						result = false;
						break;
					}
				}
				if(result) {
					offset.add(shift);
				}
			}
		
		if(offset.size()>0) 
			System.out.println("Substring " + c + "\nfound in " + s + "\nwith shift of " + offset.toString());	

	}	

}
