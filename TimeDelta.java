import java.time.*;

public class TimeDelta {

	public static void main(String[] args) {
		// Save current date-time in UTC

		Instant start = Instant.now();
		
		String strS = "matryoshka";
		String strC = "try";
		
		boolean isFound = strS.indexOf(strC) != -1? true: false;
		
		if(isFound) {
			System.out.println("Substring found!");
		} else {
			System.out.println("Substring not found.");
		}
		
		System.out.println("Source string length: " + strS.length());
		System.out.println("Pattern string length: " + strC.length());
		
        // Save current date-time in UTC
        Instant end = Instant.now();
        System.out.println();
        System.out.println("Start time: " + start);
        System.out.println("End time: " + end);
        System.out.println("Time elapsed: " + Duration.between(start, end).toMillis() + " milliseconds.");		
				
	}

}
