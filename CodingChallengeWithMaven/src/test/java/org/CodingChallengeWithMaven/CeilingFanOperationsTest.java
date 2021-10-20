package org.CodingChallengeWithMaven;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CeilingFanOperationsTest {

	// assuming fan is at rest initially
	private int currentFanSpeed;
	private CeilingFanOperations ceilingFanOperations;

	@Before
	public void setUp() {
		ceilingFanOperations = new CeilingFanOperations();
		currentFanSpeed=0;
	}

	@Test
	public void changeSpeedTestShouldToTwoAfterPullingTwoTimes() {

		//when
		int actualSpeed = ceilingFanOperations.changeSpeed(ceilingFanOperations.changeSpeed(currentFanSpeed));

		//then
		assertEquals(actualSpeed, 2);

	}

	@Test
	public void changeSpeedTestShouldChangeTotalSpeedToThreeAfterPullingThreeTimes() {
		//when
		int actualSpeed = ceilingFanOperations.changeSpeed(ceilingFanOperations.changeSpeed(ceilingFanOperations.changeSpeed(currentFanSpeed)));
		//then
		assertEquals(actualSpeed, 3);

	}

	@Test
	public void changeSpeedTestShouldChangeSpeedToZeroOnFourthPull() {
		//when

		int temp= ceilingFanOperations.changeSpeed(ceilingFanOperations.changeSpeed(currentFanSpeed));
		int actualSpeed = ceilingFanOperations.changeSpeed(ceilingFanOperations.changeSpeed(temp));
		//then
		assertEquals(actualSpeed, 0);

	}

	public void changeDirectionShouldGiveClockWiseDirectionAsDefault() {
		//when
		ceilingFanOperations.changeSpeed(currentFanSpeed);
		String actualDirection = ceilingFanOperations.getDirection();
		//then
		assertEquals(actualDirection, "clockWise");
	}

	public void changeDirectionShouldGiveDirectionAsAntiClockWise() {
		//when
		ceilingFanOperations.changeSpeed(currentFanSpeed);
		ceilingFanOperations.changeDirection();
		String actualDirection = ceilingFanOperations.getDirection();

		//then
		assertEquals(actualDirection, "antiClockwise");
	}

	@Test(expected = DirectionException.class)
	public void changeDirectionShouldThrowExceptionWhenFanIsAtRest() {
		//when
		ceilingFanOperations.changeDirection();
	}

}