import java.net.URI;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FreeCode {

	public static void main(String[] args) {

		// new features from JDK 11
		keywordVar();
		
		repeatString();
		
		stringIntoLines();
		
		newPatternsFeatures();
		
	}

	public static void keywordVar() {
		
		// Adding keyword var, to infer the data type.
		Function<String, String> append = (var string) -> string + " World";
		String appendedString = append.apply("Hello");
		System.out.println(appendedString);
		String myOwnSample = append.apply("Marcelo, keep going. ");
		System.out.println(myOwnSample);
	}

	/*
	 * I'm looking for a simple common method or operator that allows me 
	 * to repeat some String n times.  I know I could write this using a for loop,
	 * but I wish to avoid for loops whenever necessary and a simple direct method
	 * should exist somewhere:
	 *     String str = "abc";
	 *     String repeated = str.repeated(3);
	 *     repeated.equal("abcabcabc");
	 */
	public static void repeatString() {

		var str = "abc";
		var repeated = str.repeat(3);
		System.out.println(repeated);

		// Output of above program
		// abcabcabc		
				
	}
	
	/*
	 * I really like the Path API, which solves the problem of switching between paths, 
	 * URIs, URLs, and FILEs. In Java 11 we can use Paths::get and Path::of methods 
	 * to make them very uniform.
	 */
	public static void createPath(){
		Path googlePath = Path.of(URI.create("www.google.com"));
		Path studentFilePath = Path.of("/home/Students/student.txt");
		
	}
	
	public static void stringIntoLines(){
		
		var multiline = "My\nname is\nMarcelo Cartagena";
		Stream<String> stream = multiline.lines();
		stream.map(String::toUpperCase)
		      .forEach(System.out::println);
		// Output of above program
		//MY
		//NAME IS
		//AHSEN SAEED		
	}
	
	public static void newPatternsFeatures() {
		
		Predicate<String> chracterPredicate = Pattern.compile("ah").asPredicate();
		Stream.of("coding","ahsan","infinite")
		       .filter(chracterPredicate)
		       .forEach(System.out::println);
		
	}
}
