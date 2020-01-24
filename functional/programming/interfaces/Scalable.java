
/**
 * Static methods
 * - Interfaces have always had public static final fields
 * - In Java 9, they can also have public static methods 
 */
package functional.programming.interfaces;

/**
 * @author mcartage
 *
 */
public interface Scalable {
	
	// implicity public abstract
	void setScale(double scale);
	
	// implicity public static final
	double DEFAULT_SCALE = 1.0;
	
	// implicity public
	static boolean isScalable(Object obj) {
		return obj instanceof Scalable;
	}

	/*
	 * Default methods
	 * 
	 * -  A concrete instance method, which can be overriden 
	 * -  Basically, a regular instance method
	 * -  Interfaces used to provide signatures
	 * -  They also now provide behaviour
	 * 
	 * Interfaces Versus Abstract Classes
	 * 
	 * -  Interfaces are still stateless (no instances fields)
	 * -  Interfaces provide behaviour, not state
	 * -  Abstract classes provide behaviour and state
	 * 
	 */
	
	// implicit public
	default void resetScale() {
		setScale(DEFAULT_SCALE);
	}
}
