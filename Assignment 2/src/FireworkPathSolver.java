/**
 * This is a test class to solve the path of the firework star using the non-Newtonian
 * Method.
 * <p>
 * An environment, a launch tube, a firework star, a Runge Kutta ODE solver, and a
 * particle manager are all defined. 
 * </p>
 * @author zackh_000
 * @version 1.0
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FireworkPathSolver {

	private static Environment env;
	private static LaunchTube tube;
	private static Star st;
	private static RungeKuttaSolver solver;
	private static ParticleManager manager;

	/**
	 * A method used to round a number to s specific number of digits after the 
	 * decimal place. 
	 * @param num The number to round.
	 * @param digits The number of digits to round to after the decimal place.
	 * @return The rounded number.
	 */
	public static double round(double num, int digits) {
		double factor = Math.pow(10.0, digits);
		return Math.round(num * factor) / factor;
	} // end round method

	/**
	 * A method used to write data to a tab delimited text file.
	 * @param dataType The preferred filename.
	 * @param points The data to be written.
	 */
	public static void writeData(String dataType, double[][] points) {
		String outputFile = dataType + ".txt";
		Path file = Paths.get(outputFile);
		try (BufferedWriter writer = Files.newBufferedWriter(file)) {
			writer.write("seconds\tx (metres)\ty (metres)\r\n");
			for (double[] row : points)
				writer.write(round(row[0], 3) + "\t" + round(row[1], 3) +
						"\t" + round(row[2], 3) + "\r\n"); 
		} catch (IOException err) {
			System.err.println(err.getMessage());
		}
	} // end writeData

	/**
	 * The main method is used to run the simulation for a firework star. The user is
	 * prompted for an initial wind velocity, a firing angle, and a time interval to
	 * use for the simulation.
	 * @param args The standard main input.
	 */
	public static void main(String[] args) {
		String prompt = "Enter the cross-wind velocity in km/hour, between -20 and 20: ";
		double wind = IOHelper.getDouble(-20, prompt, 20);
		prompt = "Enter the firing angle in degrees between -15 and 15: ";
		double angle = IOHelper.getDouble(-15, prompt, 15);
		prompt = "Enter a time interval, in seconds, that is greater than 0 and less than or equal to 0.05: ";
		double interval = IOHelper.getDouble(0, prompt, 0.05);
		wind = wind * 1000. / 3600.;		// convert to m/sec
		angle = angle * Math.PI / 180.;		// convert to radians
		try {
			env = new Environment(wind);
		} catch (IllegalWindVelocityException e) {
			System.err.println(e.getMessage());
		}
		try {
			tube = new LaunchTube(angle, wind);
		} catch (IllegalLaunchAngleException e) {
			System.err.println(e.getMessage());
		}
		st = new Star(tube.getLaunchVX(), tube.getLaunchVXA(), tube.getLaunchVY(), env.getAirDensity(), env.getDragCoeff());
		solver = new RungeKuttaSolver(st, env);
		try {
			manager = new ParticleManager(interval, st, solver);
		} catch (IllegalTimeIntervalException e) {
			System.err.println(e.getMessage());
		}
		writeData("NonNewtonian", manager.getPath(tube.getLaunchVX(), tube.getLaunchVY(), env.getWindVelocity()));
		System.out.println("Done");
	} // end main method

} // end FireworkPathSolver class
