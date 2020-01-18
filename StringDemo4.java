import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class StringDemo4 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		try (FileReader myReader = new FileReader("/Users/mcartage/eclipse-workspace/9781789805819_Code/Hands-On-Data-Structures-Algorithms-in-Java-11-Section2/sourcefile.txt");
			 Scanner scan = new Scanner(myReader);){
						
			while(scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
			
			// scan.close(); it's not necessary because the try with resources will be responsible to close
			
		}catch(FileNotFoundException e) {
			System.out.println("Something when wrong.");
			e.printStackTrace();
		} catch (IOException e1) {
			System.out.println("Something happen.");
			e1.printStackTrace();
		}

	}

}
