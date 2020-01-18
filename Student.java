import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Student implements StudentInterface{
	
	private String name; 
	private List<Integer> marks;
	
	Student(List<Integer> marks, String name){
		this.marks = marks;
		this.name = name;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getMarks() {
		return marks;
	}

	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}

	// Methods interface implementations
	@Override
	public int getNumberOfMarks() {
		return this.marks.size();
	}
	
	@Override
	public int getTotalSumOfMarks() {
		int sum = 0;
		for(Integer e:this.marks){
			sum =+ e;
		}
		return sum;
	}
	
	@Override
	public int getMaximumMark() {
		Integer[] max = { Integer.MIN_VALUE };
		marks.forEach(e ->{
		    if(e > max [0]) max[0] = e;	
		});
		return max[0]; 
	}
	
	@Override
	public int getMinimumMark() {
		Integer [] min = { Integer.MAX_VALUE };
		marks.forEach(e -> {
			if(e<min[0]) min[0] = e; 
		});
		return min[0];
	}
	
	@Override
	public BigDecimal getAverageMarks(){
		int sum = this.getTotalSumOfMarks();
		// double average = (double) sum/this.marks.size();
		return new BigDecimal(sum).divide(new BigDecimal(this.getNumberOfMarks()),3,RoundingMode.UP);
	}

	public static void main(String... args) {
		System.out.println("Welcome to Student Class");
		
		Integer[] temp = new Integer[]{55,23,58,77,81,99,100}; 
		List<Integer> marks = Arrays.asList(temp);
		Student st = new Student(marks, "Marcelo Cartagena");
		
		// st.setName("Marcelo Cartagena");		
		// st.setMarks(marks);
		
		System.out.println("Student Information: ");
		System.out.println("Total of marks: " + st.getNumberOfMarks());
		System.out.println("Students max mark: " + st.getMaximumMark());
		System.out.println("Students min mark: " + st.getMinimumMark());
		System.out.println("Students avg mark: " + st.getAverageMarks());
		System.out.println("Students marks: " + Arrays.toString(st.getMarks().toArray()));
		
	}
}