import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class MatchParentesis {
	
	Map<Character,Character> paresMatching = new HashMap();
	Set<Character> openingMatching = new HashSet();
	
	{
		
		paresMatching.put(')','(');
		paresMatching.put(']','[');
		paresMatching.put('}','{');		
		openingMatching.add('(');
		openingMatching.add('[');
		openingMatching.add('{');
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MatchParentesis mp = new MatchParentesis();
		
        System.out.println(String.format(
                "Has matching parens %s? : %s", "(abcd)", mp.hasMatchingParens("(abcd)")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{{}}", mp.hasMatchingParens("{{{{}}")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{{}}})", mp.hasMatchingParens("{{{{}}})")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{}}}()", mp.hasMatchingParens("{{{}}}()")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{}}]()", mp.hasMatchingParens("{{{}}]()")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{}}([]){}{}{}{}{[[[[]]]]}", mp.hasMatchingParens("{{}}([]){}{}{}{}{[[[[]]]]}")));		
		
	}
	
	public boolean hasMatchingParens(String input) {
		
		try {
			Stack<Character> expressions = new Stack();
			
			for(int i = 0; i<input.length();i++) {
				char ch = input.charAt(i);
				if(openingMatching.contains(ch)) {
					expressions.push(ch);
				}
				if(paresMatching.containsKey(ch)){
					Character lastParen = expressions.pop();
					if(lastParen != paresMatching.get(ch)) {
						return false;
					}
				}
			}
			
			return expressions.isEmpty();
			
		} catch (EmptyStackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
