package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import ceilingfandesign.CeilingFanOperations;
import ceilingfandesign.DirectionException;

public class CeilingFanOperationsTest {

	private CeilingFanOperations ceilingFanOperations = new CeilingFanOperations();
	private int currentSpeed=0;

	@Test
	public void speedShouldChangeToTwoAfterPullingTwoTimesTest() {

		//when
		int actualSpeed = ceilingFanOperations.pushForward(ceilingFanOperations.pushForward(currentSpeed));

		//then
		assertEquals(actualSpeed, 2);

	}

	@Test
	public void speedShouldChangeToThreeAfterPullingThreeTimesTest() {
		//when

		int tempSpeed = ceilingFanOperations.pushForward( ceilingFanOperations.pushForward(currentSpeed));
		int actualSpeed = ceilingFanOperations.pushForward(tempSpeed);

		//then
		assertEquals(actualSpeed, 3);

	}

	@Test
	public void speedShouldChangeToZeroAfterPullingFourTimesTest() {
		//when
		int tempSpeed = ceilingFanOperations.pushForward( ceilingFanOperations.pushForward(currentSpeed));
		int actualSpeed = ceilingFanOperations.pushForward( ceilingFanOperations.pushForward(tempSpeed));

		//then
		assertEquals(actualSpeed, 0);

	}

	@Test
	public void speedShouldChangeToOneAfterPullingBackTwoTimesTest() {
		//when
		int actualSpeed = ceilingFanOperations.pushBackward( ceilingFanOperations.pushBackward(3));

		//then
		assertEquals(actualSpeed, 1);
	}

	@Test
	public void speedShouldChangeToZeroAfterPullingBackFourTimesTest(){
		//when
		int tempSpeed = ceilingFanOperations.pushBackward( ceilingFanOperations.pushBackward(currentSpeed));
		int actualSpeed = ceilingFanOperations.pushBackward( ceilingFanOperations.pushBackward(tempSpeed));

		//then
		assertEquals(actualSpeed, 0);
	}

	@Test
	public void speedShouldNotChangeFromZeroAfterPullingBackAtZeroTest() {
		//when
		int actualSpeed = ceilingFanOperations.pushBackward(0);
		assertEquals(actualSpeed, 0);
	}

}