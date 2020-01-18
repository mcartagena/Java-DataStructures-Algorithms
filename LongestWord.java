import java.util.Arrays;

/*
 * Have the function LongestWord(sen) take the sen parameter being passed and return the largest 
 * word in the string. If there are two or more words that are the same length, return the first 
 * word from the string with that length. Ignore punctuation and assume sen will not be empty.
 * 
 * Use the Parameter Testing feature in the box below to test your code with different arguments.
 * 
 * 1. For input "this is some sort of sentence" the output was incorrect. The correct output is sentence
 * 2. For input "longest word!!" the output was incorrect. The correct output is longest
 * 3. For input "coderbyte" the output was incorrect. The correct output is coderbyte
 * 4. For input "oxford press" the output was incorrect. The correct output is oxford
 * 5. For input "123456789 98765432" the output was incorrect. The correct output is 123456789
 * 6. For input "letter after letter!!" the output was incorrect. The correct output is letter
 * 7. For input "a b c dee" the output was incorrect. The correct output is dee
 * 8. For input "a confusing /:sentence:/[ this is not!!!!!!!~" the output was incorrect. The correct output is confusing
 */

public class LongestWord {

	public static String phraseToProcess = "Hello Wordl";
//	public static String phraseToProcess = "this is some sort of sentence";
//	public static String phraseToProcess = "longest word!!";
//	public static String phraseToProcess = "coderbyte";
//	public static String phraseToProcess = "oxford press";
//	public static String phraseToProcess = "123456789 98765432";
//	public static String phraseToProcess = "letter after letter!!";
//	public static String phraseToProcess = "a b c dee";
//	public static String phraseToProcess = "a confusing /:sentence:/[ this is not!!!!!!!~";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = longestWord(phraseToProcess);
		System.out.println("Longest word is: " + result);
		result = LongestWord(phraseToProcess);
		System.out.println("Longest word is: " + result);
		result = longesWordBestApproach(phraseToProcess);
		System.out.println("Longest word is: " + result);
		

	}

	public static String longestWord(String phrase) {
		String ls;
		int beginIndex = 0;
		int longestSize = 0;
		int wordSize = 0;

		for (int startIndex = 0; startIndex < phrase.length(); startIndex++) {
			if (phrase.charAt(startIndex) != " ".charAt(0)) {
				if ((phrase.charAt(startIndex) >= "a".charAt(0) && phrase.charAt(startIndex) <= "z".charAt(0))
						|| (phrase.charAt(startIndex) >= "A".charAt(0) && phrase.charAt(startIndex) <= "Z".charAt(0))
						|| (phrase.charAt(startIndex) >= "0".charAt(0) && phrase.charAt(startIndex) <= "9".charAt(0))) {
					wordSize++;
				}

			} else {
				if (wordSize > longestSize) {
					longestSize = wordSize;
					beginIndex = startIndex - longestSize;
				}
				wordSize = 0;
			}
		}

		if (wordSize > longestSize) {
			longestSize = wordSize;
			beginIndex = phrase.length() - longestSize;
		}

		System.out.println("longestSize: " + longestSize);
		System.out.println("beginIndex: " + beginIndex);

		ls = phrase.substring(beginIndex, beginIndex + longestSize);
		return ls;
	}

	public static String LongestWord(String sen) {
		// code goes here
		int bi = 0;
		int ls = 0;
		int ws = 0;

		for (int i = 0; i < sen.length(); i++) {
			if (sen.charAt(i) != " ".charAt(0)) {
				if ((sen.charAt(i) >= "a".charAt(0) && sen.charAt(i) <= "z".charAt(0))
						|| (sen.charAt(i) >= "A".charAt(0) && sen.charAt(i) <= "Z".charAt(0))
						|| (sen.charAt(i) >= "0".charAt(0) && sen.charAt(i) <= "9".charAt(0))) {
					ws++;
				}
			} else {
				if (ls < ws) {
					ls = ws;
					bi = i - ls;
				}
				ws = 0;
			}
		}

		if (ls < ws) {
			ls = ws;
			bi = sen.length() - ls;
		}

		sen = sen.substring(bi, bi + ls);
		return sen;
	}
	public static String longesWordBestApproach(String sen) {
		String [] as = sen.split("[^A-Za-z0-9]");
		
		// System.out.println(Arrays.deepToString(as));
		
		int maxIndex = 0;
		for(int i = 1; i < as.length;i++) {
			if(as[i].length()>as[maxIndex].length()) {
				maxIndex = i;
			}
		}
		return as[maxIndex];
	}

}
