package org.CodingChallengeWithMaven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The CeilingFanMain class allows the user 
 * to set ceiling fan operations and get results to the console.
 *
 * @author  sa384156
 * @version 1.0
 * @since   2021-10-22 
 */
public class CeilingFanMain {

	static int speed;
	static String direction="";
	// Assuming default direction as clockwise
	static String directionprev="cw";
	static CeilingFanOperations fanops = new CeilingFanOperations();
	private static final Logger logger = LogManager.getLogger(CeilingFanMain.class);	
	public static void main(String args[]) {
		try {
			logger.info("Fan is at rest state");			
			while (true) {			
				getRightDirection();
				getSpeed();
				directionprev=direction;
			}
		}
		catch(DirectionException e) {
			e.printStackTrace();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}

	private static void getRightDirection() throws DirectionException {
		if(speed==0) {
			logger.info("Cord cannot be pulled in antiClockwise while at rest ");
			logger.info("Pull the cord in clockwise(cw) direction: ");
		}
		else {
			logger.info("Pull the cord in clockwise(cw) or (acw) direction: ");					
		}
		direction= readNextLine();
		if(!(direction.equalsIgnoreCase("cw") || direction.equalsIgnoreCase("acw")) ) {
			throw new DirectionException("Invalid Direction");
		}
	}

	private static void getSpeed() throws DirectionException {	
		if(!direction.equalsIgnoreCase(directionprev)) {
			fanops.changeDirection(speed);
		}
		if(direction.equalsIgnoreCase("cw"))			
			speed=fanops.changeSpeed(speed);		
		else if(direction.equalsIgnoreCase("acw")) 					
			speed=fanops.changeSpeed(speed);										
	}

	static String readNextLine() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = in.readLine();	           
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return line;
	}

}
