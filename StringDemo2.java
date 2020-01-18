public class StringDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String userName = "neo.anderson@matrix.org";
		
		// 1
		System.out.println(userName);
		
		// 2
		System.out.println(userName.toUpperCase());
		
		// 3
		System.out.println("User Name is " + userName.length() + " characters long.");
		
		// 4
		System.out.println("First three characters are: " + userName.substring(0,3));
		
		// 5
		System.out.println("Index 3 is: " + userName.charAt(3));

		// 6
		System.out.println("Index 3 is: " + userName.charAt(0));

	}

}
