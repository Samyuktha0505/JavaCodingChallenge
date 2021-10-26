package org.CodingChallengeWithMaven;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The CeilingFanOperations class implements the methods for
 * changing speed and changing direction of the ceiling fan.
 * Also sets the max, min speed of fan from properties file.
 *
 * @author  sa384156
 * @version 1.0
 * @since   2021-10-22 
 */
public class CeilingFanOperations {

	private int minFanSpeed;
	private int maxFanSpeed;
	private int currentFanSpeed;
	private boolean reverseFlag=false;
	private static final Logger logger = LogManager.getLogger(CeilingFanOperations.class);

	public int getMinFanSpeed() {
		return minFanSpeed;
	}

	public int getMaxFanSpeed() {
		return maxFanSpeed;
	}

	// Fan min, max speed settings are set during object instantiation
	public CeilingFanOperations() {					
		try (InputStream input = this.getClass().getClassLoader().getResourceAsStream("settings.properties")) {	
			Properties prop = new Properties();
			prop.load(input);
			minFanSpeed=Integer.parseInt(prop.getProperty("fan.minsetting"));
			maxFanSpeed=(Integer.parseInt(prop.getProperty("fan.maxsetting")));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// gets the current direction of fan
	public String getDirection() {		
		return  reverseFlag ? "antiClockwise" : "clockWise";
	}

	// Changes the speed of fan with respect to the pull direction
	public int changeSpeed(int currentFanSpeed) {
		if(reverseFlag==false) {	
			this.currentFanSpeed= ((currentFanSpeed==getMaxFanSpeed())?getMinFanSpeed():++currentFanSpeed);
		}
		else {
			if(currentFanSpeed==minFanSpeed)
				throw new DirectionException("Can't move in anticlockwise direction, when fan is at rest");	
			this.currentFanSpeed = ((currentFanSpeed==getMinFanSpeed())?getMinFanSpeed():--currentFanSpeed);			
		}
		logger.info("Current fan speed: "+this.currentFanSpeed);
		return this.currentFanSpeed;
	}

	// Changes the direction when the speed 
	//is positive in clockwise or in any speed in anti clockwise
	public void changeDirection(int currentFanSpeed ) {
		if (currentFanSpeed == getMinFanSpeed() && getDirection().equals("clockWise")) {			
			throw new DirectionException("Can't change to anticlockwise direction, when fan is at rest");			
		}
		reverseFlag = !reverseFlag;	
		logger.info("Fan is pulled in : " + getDirection() + " direction");
	}

}
