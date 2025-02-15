// TODO Fix comments
/**
 * This interface specifies the minimum set of methods that an object that
 * implements the ODESystem interface must have. An ODESystem object is used
 * by other objects to solve ordinary differential equations (ODEs).
 * @author zackh_000
 * @version 1.0
 */
public interface ODESystem {
	
	/**
	 * This is an accessor that will return the current size of the ODE System.
	 * @return The size of the ODE System.
	 */
	int getSystemSize();
	
	/**
	 * This is an accessor that will return the current values of the ODE System.
	 * @return The current values of the ODE System.
	 */
	double[][] getCurrentValues();
	
} // end ODESystem interface
