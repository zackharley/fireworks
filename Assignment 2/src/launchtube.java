/**
 * A class to store information regarding a firework launch tube.
 * <p>
 * The launch angle, x velocity, x actual velocity, y velocity, 
 * and velocity magnitude are recorded.
 * </p>
 * @author zackh_000
 * @version 1.0
 */
public class LaunchTube {

	private double launchAngle;		// degrees
	private double launchVX;		// m/s
	private double launchVXA;		// m/s
	private double launchVY;		// m/s
	private double launchVMag;		// m/s

	/**
	 * A constructor for the LaunchTube class.
	 * @param angle The initial launch angle for the tube.
	 * @param windV The wind velocity in the environment around the tube.
	 * @throws IllegalLaunchAngleException if launch angle is not between -15 and
	 * 15 degrees, inclusive.
	 */
	public LaunchTube(double angle, double windV) throws IllegalLaunchAngleException {
		if (angle < -15 || angle > 15) {
			throw new IllegalLaunchAngleException("The supplied launch angle was not " +
					"between -15 and 15 degrees, inclusive.");
		}
		setLaunchAngle(angle);
		setLaunchVMag();
		setLaunchVX(angle);
		setLaunchVXA(angle, windV);
		setLaunchVY(angle);
	} // end full constructor

	private void setLaunchAngle(double angle) {
		launchAngle = angle;
	} // end launchAngle mutator
	
	private void setLaunchVMag() {
		launchVMag = 22;
	} // end launchVMag mutator
	
	private void setLaunchVX(double angle) {
		launchVX = getLaunchVMag() * Math.sin(angle);
	} // end launchVX mutator
	
	private void setLaunchVXA(double angle, double windV) {
		launchVXA = (getLaunchVMag() * Math.sin(angle)) - windV;
	} // end launchVXA mutator
	
	private void setLaunchVY(double angle) {
		launchVY = getLaunchVMag() * Math.cos(angle);
	} // end launchVY mutator
	
	/**
	 * The accessor for launchAngle.
	 * @return The launch angle for the tube.
	 */
	public double getLaunchAngle() {
		return launchAngle;
	} // end launchAngle accessor
	
	/**
	 * The accessor for launchVX.
	 * @return The initial x launch velocity, not taking wind velocity into account.
	 */
	public double getLaunchVX() {
		return launchVX;
	} // end launchVX accessor
	
	/**
	 * The accessor for launchVXA
	 * @return The initial x actual launch velocity, taking wind velocity into
	 * account.
	 */
	public double getLaunchVXA() {
		return launchVXA;
	} // end launchVXA accessor
	
	/**
	 *  The accessor for launchVY.
	 * @return The initial y launch velocity.
	 */
	public double getLaunchVY() {
		return launchVY;
	} // end launchVY accessor
	
	/**
	 * The accessor for launchVMag.
	 * @return The magnitude of the launch velocity vector.
	 */
	public double getLaunchVMag() {
		return launchVMag;
	} // end launchVMag accessor

} // end LaunchTube class
