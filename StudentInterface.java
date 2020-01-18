import java.math.BigDecimal;

/**
 * Define contract for classes students
 * 
 * @author mcartage
 *
 */
public interface StudentInterface {
	BigDecimal MIN_AVERAGE = new BigDecimal(0.0d);
	
	int getNumberOfMarks();
	int getTotalSumOfMarks();
	int getMaximumMark();
	int getMinimumMark();
	default BigDecimal getAverageMarks() {
		return MIN_AVERAGE;
	};

}
