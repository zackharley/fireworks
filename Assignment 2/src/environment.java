/**
 * A class used to store information regarding the environment in which a star will be launched.
 * <p>
 * The wind velocity, air density, drag coefficient, and gravity are all recorded.
 * </p>
 * @author zackh_000
 * @version 1.0
 */
public class Environment {
	
	private double windVelocity;	// m/s
	private double airDensity;		// kg/m*m*m
	private double dragCoeff;		// unitless
	private double gravity;			// m/s*s

	/**
	 * The constructor for the Environment class
	 * @param windV The wind velocity for the environment.
	 * @throws IllegalWindVelocityException if windV is greater than 20 or less than -20.
	 */
	public Environment(double windV) throws IllegalWindVelocityException {
		if (windV > 20 || windV < -20){
			throw new IllegalWindVelocityException("The supplied wind velocity was not" +
					" between -20 and 20 m/s, inclusive.");
		}
		setWindVelocity(windV);
		setAirDensity();
		setDragCoeff();
		setGravity();
	} // end full constructor

	private void setWindVelocity(double velocity) {
		windVelocity = velocity;
	} // end windVelocity mutator
	
	private void setAirDensity() {
		airDensity = 1.2;
	} // end  airDensity mutator
	
	private void setDragCoeff() {
		dragCoeff = 0.4;
	} // end dragCoefficient mutator
	
	private void setGravity() {
		gravity = 9.807;
	} // end gravity mutator
	
	/**
	 * The accessor for windVelocity.
	 * @return The wind velocity in the environment.
	 */
	public double getWindVelocity() {
		return windVelocity;
	} // end windVelocity accessor
	
	/**
	 * The accessor for airDensity.
	 * @return The air density in the environment.
	 */
	public double getAirDensity() {
		return airDensity;
	} // end airDensity accessor
	
	/**
	 * The accessor for dragCoeff.
	 * @return The drag coefficient of the environment.
	 */
	public double getDragCoeff() {
		return dragCoeff;
	} // end dragCoeff accessor
	
	/**
	 * The accessor for gravity.
	 * @return The gravity in the environment.
	 */
	public double getGravity() {
		return gravity;
	} // end gravity accessor
	
} // end Environment class
