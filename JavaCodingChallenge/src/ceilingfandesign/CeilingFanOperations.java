package ceilingfandesign;

public class CeilingFanOperations {
	private int currentfanspeed;

	public CeilingFanOperations() {
		currentfanspeed = 0;
	}

	// returns speed when chord is pulled in clockwise direction
	public int pushForward(int speed) {
		currentfanspeed= speed;			
		return (currentfanspeed==3)?0:++currentfanspeed;		
	}
	
	// returns speed when chord is pulled in anticlockwise direction
	public int pushBackward(int speed) {
		currentfanspeed= speed;
		return (currentfanspeed==0)?0:--currentfanspeed;
	}
}
