package ceilingfandesign;

public class CeilingFanOperations {
	private int currentfanspeed;

	public CeilingFanOperations() {
		currentfanspeed = 0;
	}

	public int pushForward(int speed) {
		currentfanspeed= speed;
		if(currentfanspeed==3) {
			currentfanspeed=0;
			return currentfanspeed;
		}
		else {
			++currentfanspeed;
			return currentfanspeed;
		}
	}

	public int pushBackward(int speed) {
		currentfanspeed= speed;
		if(currentfanspeed==0) {
			return currentfanspeed;
		}
		else {
			--currentfanspeed;
			return currentfanspeed;
		}
	}
}
