package functional.programming.interfaces;

import java.util.Comparator;
import java.util.function.Consumer;

public class Lambda1 {
 
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Employee mike = new Employee("Mike",2000);
		Employee louise = new Employee("Louise",2500);
		
		Comparator<Employee> byName = new Comparator<Employee>(){
			public int compare(Employee a, Employee b) {
				return a.getName().compareTo(b.getName());
			}
		};
		
		// Our first lambda expresion
		Comparator<Employee> byNameLambda1 = (Employee a,Employee b) -> { return a.getName().compareTo(b.getName()); };
		
		// Removing parameter types
		Comparator<Employee> byNameLambda2 = (a, b) -> { return a.getName().compareTo(b.getName()); };
		
		// Removing braces and 'return'
		Comparator<Employee> byNameLambda3 = (a, b) -> a.getName().compareTo(b.getName());

		// you can't remove braces and leave 'return'
		// Comparator<Employee> byNameLambda4 = (a, b) -> return a.getName().compareTo(b.getName());
		
		// Expression with no parameters
		Runnable r = () -> {System.out.println("A compact Runnable!"); };
		Thread t1 = new Thread(r);
		
		// No need to even mention Runnable
		Thread t2 = new Thread(() -> {System.out.println("An implicit Runnable!"); });
		
		// No need for braces here
		Thread t3 = new Thread(() -> {System.out.println("A implicit Runnable!"); });
		
		// Expression with one parameter
		Consumer<String> lengthPrinter = s -> System.out.println(s.length());
		
		/*
		 * Summary:
		 * 
		 * Lambda Expression Syntax
		 * 
		 * parameters -> body
		 * 
		 * parameters							  body
		 * (int a, int b) 						{ block }
		 * (a,b)								expr
		 * (a)
		 * ()
		 * a
		 * 
		 * 
		 */
		
	}

}
