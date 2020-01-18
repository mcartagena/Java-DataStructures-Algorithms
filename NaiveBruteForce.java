import java.time.Duration;
import java.time.Instant;

/*
 * Implement the Naive Brute-Force algorithm.  With the follow pseudo code:
 * 
 * Matching (S,C)
 * 
 * n = S.length
 * m = C.length
 * 
 * for shift = 0 to n-m
 * 		if c[1..m] == S[shift + 1..shift +  m ]
 * 		print "substring C found in S with shift of " shift
 * 
 */

public class NaiveBruteForce {

	public static void main(String[] args) {

		// Save current date-time in UTC

		Instant start = Instant.now();
		
		NaiveBruteForce nbf = new NaiveBruteForce();
		nbf.matching("matryoshka", "hka");
		
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
		
		int offset = 0;
		
		Boolean result = false;
		
		for(int shift = 0; shift <= n-m; shift++)
			if(c.charAt(0) == s.charAt(shift)){
				// System.out.println("Es igual en " + shift);
				result = true;
				for(int innerShift= 0; innerShift < m; innerShift++) {
					if(c.charAt(innerShift)!= s.charAt(innerShift + shift)) {
						// System.out.println("Es diferente en " + innerShift);
						result = false;
						break;
					}
				}
				if(result) {
					offset = shift;
					break;
				}
			}
		
		if(result) System.out.println("Substring " + c + " found in " + s + " with shift of " + offset);		

	}

}
