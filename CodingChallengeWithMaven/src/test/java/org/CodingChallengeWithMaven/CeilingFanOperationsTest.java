package org.CodingChallengeWithMaven;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
* The CeilingFanOperationsTest class is a collection
* of all junit test cases for Ceiling fan operations
* Tests are expected to work for all generic min, max fan speed settings.
*
* @author  sa384156
* @version 1.0
* @since   2021-10-21 
*/
public class CeilingFanOperationsTest {

	private static int currentFanSpeed;
	private static CeilingFanOperations ceilingFanOperations;
	private static final Logger logger = LogManager.getLogger(CeilingFanOperationsTest.class);

	/**
	 * setUp method is executed  once 
	 * before every test is executed
	 */
	@Before
	public void setUp() {	
		ceilingFanOperations=new CeilingFanOperations();
		currentFanSpeed=ceilingFanOperations.getMinFanSpeed();		
	}

	/**
	 * Test case for one pull and next pull 
	 * in clockwise direction from rest 
	 * speed should change to rest+1 and then to rest+2
	 */
	@Test
	public void changeTwoSpeedTestCW() {		
		logger.info("changeTwoSpeedTestCW Test");
		//when speed is changed in cw		
		currentFanSpeed = ceilingFanOperations.changeSpeed(currentFanSpeed);
		currentFanSpeed = ceilingFanOperations.changeSpeed(currentFanSpeed);
		//then
		assertEquals(currentFanSpeed, ceilingFanOperations.getMinFanSpeed()+2);
	}

	/**
	 * Test case to get maximum fan setting 
	 * and maximum to minium setting
	 * in clockwise direction from rest
	 * speed should change to fan max speed
	 */
	@Test
	public void changeMaxSpeedTestCW() {
		logger.info("changeMaxSpeedTestCW Test");		
		//when
		int count=ceilingFanOperations.getMaxFanSpeed();
		while(count>ceilingFanOperations.getMinFanSpeed()) {
			currentFanSpeed= ceilingFanOperations.changeSpeed(currentFanSpeed);
			count--;
		}
		//then
		assertEquals(currentFanSpeed, ceilingFanOperations.getMaxFanSpeed());
		assertEquals(ceilingFanOperations.changeSpeed(currentFanSpeed), ceilingFanOperations.getMinFanSpeed());
	}

	/**
	 * Test case to check the
	 * default direction
	 * It should be clock wise
	 */
	@Test
	public void changeDirShouldGiveCWDirAsDefault() {
		logger.info("changeDirShouldGiveCWDirAsDefault Test");	
		//when
		ceilingFanOperations.changeSpeed(currentFanSpeed);	
		//then
		assertEquals(ceilingFanOperations.getDirection(), "clockWise");
	}


	/**
	 * Test case to change direction to
	 * anti clockwise direction from clockwise
	 * with positive speed
	 */
	@Test
	public void changeDirShouldGiveDirAsACW() {
		logger.info("changeDirShouldGiveDirAsACW Test");	
		currentFanSpeed= ceilingFanOperations.changeSpeed(currentFanSpeed);		
		ceilingFanOperations.changeDirection(currentFanSpeed);		
		assertEquals(ceilingFanOperations.getDirection(), "antiClockwise");		
	}

	/**
	 * Test case to get minimum fan speed
	 * in anti clockwise direction from max speed
	 * speed should change to fan min speed
	 */
	@Test
	public void changeMaxSpeedTestACW() {
		logger.info("changeMaxSpeedTestACW Test");		
		//when
		int count=ceilingFanOperations.getMaxFanSpeed();
		currentFanSpeed=ceilingFanOperations.getMaxFanSpeed();
		ceilingFanOperations.changeDirection(currentFanSpeed);
		while(count>ceilingFanOperations.getMinFanSpeed()) {
			currentFanSpeed= ceilingFanOperations.changeSpeed(currentFanSpeed);
			count--;
		}
		//then
		assertEquals(currentFanSpeed, ceilingFanOperations.getMinFanSpeed());
	}

	/**
	 * Test case to change speed and change direction
	 * with positive speed
	 */
	@Test
	public void ChangeToCwAndAcwAndThenCwWithSpeed() {		
		logger.info("ChangeToCwAndAcwAndThenCwWithSpeed Test");
		//when
		currentFanSpeed = ceilingFanOperations.changeSpeed(currentFanSpeed);
		ceilingFanOperations.changeDirection(currentFanSpeed);
		currentFanSpeed = ceilingFanOperations.changeSpeed(currentFanSpeed);
		ceilingFanOperations.changeDirection(currentFanSpeed);
		currentFanSpeed = ceilingFanOperations.changeSpeed(currentFanSpeed);
		//then
		assertEquals(currentFanSpeed,ceilingFanOperations.getMinFanSpeed()+1);
		assertEquals(ceilingFanOperations.changeSpeed(currentFanSpeed), ceilingFanOperations.getMinFanSpeed()+2);		
	}
	/**
	 * Test case to check the expected exception
	 * If direction is changed to anti clockwise during rest
	 * exception is expected
	 */
	@Test(expected = DirectionException.class)
	public void changeDirectionShouldThrowExceptionWhenFanIsAtRest() {
		logger.info("changeDirectionShouldThrowExceptionWhenFanIsAtRest Test");
		//when
		ceilingFanOperations.changeDirection(currentFanSpeed);
	}
	
	@Test(expected = DirectionException.class)
	public void changeSpeedShouldThrowExceptionWhenFanIsAtRestMovedInAcw() {
		logger.info("changeDirectionShouldThrowExceptionWhenFanIsAtRest Test");
		//when
		ceilingFanOperations.changeSpeed(currentFanSpeed);
		ceilingFanOperations.changeDirection(currentFanSpeed);
		ceilingFanOperations.changeSpeed(currentFanSpeed);
		ceilingFanOperations.changeSpeed(currentFanSpeed);
	}

}