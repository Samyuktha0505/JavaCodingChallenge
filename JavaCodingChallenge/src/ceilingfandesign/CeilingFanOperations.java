package ceilingfandesign;

public class CeilingFanOperations {
	    private int currentfanspeed;

	    public CeilingFanOperations() {
	    	currentfanspeed = 0;
	    }

	    public int getCurrentFanSpeed() {
			return currentfanspeed;
		}

		public void setCurrentFanSpeed(int currentfanspeed) {
			this.currentfanspeed = currentfanspeed;
		}

		public int pushForward(int speed) {
			currentfanspeed= speed;
			if(currentfanspeed==3) {
				setCurrentFanSpeed(0);
				System.out.println("Current Speed: "+getCurrentFanSpeed());
				return getCurrentFanSpeed();
			}
			else {
				setCurrentFanSpeed(++currentfanspeed);
				System.out.println("Current Speed: "+getCurrentFanSpeed());
				return getCurrentFanSpeed();
			}
		}
	    
	    public int pushBackward(int speed) {
	    	currentfanspeed= speed;
			if(currentfanspeed==0) {
				System.out.println("Can't go in reverse, when Fan is at rest");
				return currentfanspeed;
			}
			else {
				setCurrentFanSpeed(--currentfanspeed);
				System.out.println("Current Speed: "+getCurrentFanSpeed());
				return getCurrentFanSpeed();
			}
	    }
	}
