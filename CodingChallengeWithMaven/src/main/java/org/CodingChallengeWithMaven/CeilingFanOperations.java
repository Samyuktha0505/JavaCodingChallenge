package org.CodingChallengeWithMaven;

public class CeilingFanOperations {

	private int currentFanSpeed;
	private boolean reverseFlag;

	public String getDirection() {		
		return  reverseFlag ? "antiClockwise" : "clockWise";
	}

	public int changeSpeed(int currentFanSpeed) {

		return (currentFanSpeed==3)?0:++currentFanSpeed;
	}

	public int changeDirection(int currentFanSpeed) {
		if (currentFanSpeed == 0) {
			throw new DirectionException("Can't change direction, when Fan is at rest");
		}
		reverseFlag = !reverseFlag;
		// will prefer to use loggers later
		System.out.println("Fan is rotating in : " + getDirection() + " direction");
		return --currentFanSpeed;
	}

}
