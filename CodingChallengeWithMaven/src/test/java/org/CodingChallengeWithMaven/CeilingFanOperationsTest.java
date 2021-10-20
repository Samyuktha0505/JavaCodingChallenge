package org.CodingChallengeWithMaven;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CeilingFanOperationsTest {

	// assuming fan is at rest initially
	private int currentFanSpeed=0;
	private CeilingFanOperations ceilingFanOperations;

	@Before
	public void setUp() {
		ceilingFanOperations = new CeilingFanOperations();
	}

	@Test
	public void changeSpeedTestShouldToTwoAfterPullingTwoTimesCW() {

		//when
		int actualSpeed = ceilingFanOperations.changeSpeed(ceilingFanOperations.changeSpeed(currentFanSpeed));

		//then
		assertEquals(actualSpeed, 2);

	}

	@Test
	public void changeSpeedTestShouldChangeTotalSpeedToThreeAfterPullingThreeTimesCW() {
		//when
		int actualSpeed = ceilingFanOperations.changeSpeed(ceilingFanOperations.changeSpeed(ceilingFanOperations.changeSpeed(currentFanSpeed)));
		//then
		assertEquals(actualSpeed, 3);

	}

	@Test
	public void changeSpeedTestShouldChangeSpeedToZeroOnFourthPullCW() {
		//when

		int temp= ceilingFanOperations.changeSpeed(ceilingFanOperations.changeSpeed(currentFanSpeed));
		int actualSpeed = ceilingFanOperations.changeSpeed(ceilingFanOperations.changeSpeed(temp));
		//then
		assertEquals(actualSpeed, 0);

	}

	@Test
	public void changeDirectionShouldGiveCWDirectionAsDefault() {
		//when
		ceilingFanOperations.changeSpeed(currentFanSpeed);
		String actualDirection = ceilingFanOperations.getDirection();
		//then
		assertEquals(actualDirection, "clockWise");
	}

	@Test
	public void changeDirectionShouldGiveDirectionAsACW() {
		//when
		int actualSpeed = ceilingFanOperations.changeDirection(3);
		String actualDirection = ceilingFanOperations.getDirection();

		//then
		assertEquals(actualDirection, "antiClockwise");
		assertEquals(actualSpeed, 2);
	}

	@Test(expected = DirectionException.class)
	public void changeDirectionShouldThrowExceptionWhenFanIsAtRest() {
		//when
		ceilingFanOperations.changeDirection(currentFanSpeed);
	}

}