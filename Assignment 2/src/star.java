/**
 * A class to store information regarding a firework star.
 * <p>
 * The initial mass, the burn rate, the density, the current
 * mass, the radius, the initial x and y velocities, the actual
 * x velocity, the velocity magnitude, and the drag force are recorded.
 * </p>
 * @author zackh_000
 * @version 1.0
 */
public class Star implements ODESystem {

	private double initialMass;		// kg
	private double burnRate; 		// kg/second
	private double starDensity;		// kg/m*m*m
	private double currentMass;		// kg
	private double volume;			// m*m*m
	private double radius;			// m
	private double velocityX;		// m
	private double velocityXA;		// m/s
	private double velocityY;		// m/s
	private double velocityMag;		// m/s
	private double area;			// m*m
	private double dragForce;		// N

	/**
	 * A constructor for the Star class.
	 * @param initialVX The initial x velocity, not accounting for wind.
	 * @param initialVXA The initial actual x velocity, accounting for wind.
	 * @param initialVY The initial y velocity.
	 * @param airDensity The air density in the environment surrounding the Star.
	 * @param dragCoeff The drag coefficient for the star in its environment.
	 */
	public Star(double initialVX, double initialVXA, double initialVY, double airDensity, double dragCoeff) {
		setInitialMass();
		setBurnRate();
		setStarDensity();
		setCurrentMass();
		setVolume();
		setRadius();
		setVelocityX(initialVX);
		setVelocityXA(initialVXA);
		setVelocityY(initialVY);
		setVelocityMag();
		setArea();
		setDragForce(airDensity, dragCoeff);
	} // end constructor

	private void setInitialMass() {
		initialMass = 0.008;
	} // end private initialMass mutator

	private void setBurnRate() {
		burnRate = 0.0030;
	} // end private burnRate mutator

	private void setStarDensity() {
		starDensity = 1900;
	} // end private starDensity mutator

	// default mutator used to initially set the current mass
	private void setCurrentMass() {
		currentMass = initialMass;
	} // end private currentMass mutator

	/**
	 * A mutator used to set the current mass at a given time.
	 * @param time The time, in seconds, since the Star launched.
	 */
	public void setCurrentMass(double time) {
		currentMass = initialMass - time * burnRate;
	} // end currentMass mutator
	
	/**
	 * A mutator used to determine the volume of the star.
	 */
	public void setVolume() {
		volume = currentMass / starDensity;
	} // end private volume mutator

	/**
	 * A mutator used to set the radius. The radius value will only change
	 * if the volume has been modified before setRadius is called .
	 */
	public void setRadius() {
		radius = Math.pow(3 * volume / (4 * Math.PI), 1.0 / 3.0);
	} // end radius Mutator

	/**
	 * A mutator to set the current x velocity, not taking into account any
	 * wind.
	 * @param velocity The new velocity you want velocityX to be changed to.
	 */
	public void setVelocityX(double velocity) {
		velocityX = velocity;
	} // end velocityX mutator

	/**
	 * A mutator to set the current actual x velocity, taking into account 
	 * any wind.
	 * @param velocity The new velocity you want velocityXA to be changed to.
	 */
	public void setVelocityXA(double velocity) {
		velocityXA = velocity;
	} // end velocityXA mutator

	/**
	 * A mutator to set the current y velocity.
	 * @param velocity The new velocity you want velocityY to be changed to.
	 */
	public void setVelocityY(double velocity) {
		velocityY = velocity;
	} // end velocityY mutator

	/**
	 * A mutator used to calculate the magnitude of the current actual x
	 * velocity and the y velocity of the Star. The velocity magnitude will
	 * only change if at least one of velocityXA or velocityY is changed
	 * before setVelocityMag is called
	 */
	public void setVelocityMag() {
		velocityMag = Math.sqrt(velocityXA * velocityXA + velocityY * velocityY);
	} // end velocityMag Mutator
	
	/**
	 * A mutator used to change the area of the star. The area value will only
	 * change if the radius was altered before setArea was called
	 */
	public void setArea() {
		area = Math.PI * radius * radius;
	} // end private area mutator

	public void setDragForce(double airDensity, double dragCoeff) {
		dragForce = airDensity * velocityMag * velocityMag * area * dragCoeff / 2;
	} // end dragForce mutator

	public double getInitialMass() {
		return initialMass;
	} // end initialMass Accessor

	public double getBurnRate() {
		return burnRate;
	} // end burnRate accessor

	public double getCurrentMass() {
		return currentMass;
	} // end currentMass Accessor

	public double getRadius() {
		return radius;
	} //  end radius Accessor

	public double getVelocityX() {
		return velocityX;
	} // end velocityX accessor

	public double getVelocityXA() {
		return velocityXA;
	} // end velocityXA accessor

	public double getVelocityY() {
		return velocityY;
	} // end velocityY accessor

	public double getVelocityMag() {
		return velocityMag;
	} // end velocityMag Accessor

	public double getDragForce() {
		return dragForce;
	} // end dragForce Accessor

	@Override
	public int getSystemSize() {
		return 2;
	} //end getSystemSize accessor

	@Override
	public double[] getCurrentValues() {
		// TODO Auto-generated method stub
		return null;
	} //end getCurrentValues accessor

	@Override
	public double[][] getFunction(double time, double[] values) {
		// TODO Auto-generated method stub
		return null;
	} // end getFunction accessor

} // end Star class
