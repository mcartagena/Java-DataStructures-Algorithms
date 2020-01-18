import java.time.LocalDateTime;
import java.time.Period;
import java.time.Duration;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;


public class CalculateAge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter T = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter date of birth[\"dd/MM/yyyy HH:mm\"]");
		
		String dateIn = sc.nextLine();
		
		LocalDateTime b = LocalDateTime.parse(dateIn,T);
		LocalDateTime now = LocalDateTime.now();

		
		Duration db = Duration.between(b, now);
		long sec = db.getSeconds();
		
		System.out.println("Days Duration " + sec / 86400);
		
		long h = (sec / 3600) - (sec / 86400) * 24;
		long min = (sec % 3600) / 60 ;
		
		Period p = Period.between(b.toLocalDate(), now.toLocalDate());
				
		System.out.println("Age is: " + p.getYears() + " years, " 
		                              + p.getMonths() + " months, " 
				                      + p.getDays() + " days, " 
				                      + h + " hours, "
				                      + min + " minutes old"
		                              );
		
	}
	
}

// Enter date of birth["dd/MM/yyyy HH:mm"]
// 22/09/1970 07:20
// Age is: 49 years, 3 months, 20 days, 23 hours, 47 minutes old