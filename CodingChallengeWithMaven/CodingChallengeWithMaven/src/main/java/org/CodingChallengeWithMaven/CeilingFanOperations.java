package org.CodingChallengeWithMaven;

public class CeilingFanOperations {

    private int currentFanSpeed;
    private boolean reverseFlag;

    public String getDirection() {
        String direction = getDirectionFormat();
        return direction;
    }

    private String getDirectionFormat() {
        return reverseFlag ? "antiClockwise" : "clockWise";
    }

    public int changeSpeed(int currentFanSpeed) {

        if (currentFanSpeed == 3) {
        	currentFanSpeed = 0;
            return currentFanSpeed;
        }

        return ++currentFanSpeed;
    }

    public int changeDirection(int currentFanSpeed) {
        if (currentFanSpeed == 0) {
            throw new DirectionException("Can't change direction, when Fan is at rest");
        }
        reverseFlag = !reverseFlag;
        
        System.out.println("Fan is rotating in : " + getDirectionFormat() + " direction");
        return --currentFanSpeed;
    }

    private boolean isFanAtRest() {
        return currentFanSpeed == 0;
    }

}
