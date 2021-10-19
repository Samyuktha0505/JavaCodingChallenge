package ceilingfandesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CeilingFanMain {
	static int speed=0;
	static boolean reverseflag=false;
	static String direction=null;
	static CeilingFanOperations fanops = new CeilingFanOperations();

	public static void main(String[] args) throws DirectionException {
		try {
			while (true) {
				// assuming the fan is in off current speed of fan is zero
				//setSpeed();
				getDirection();
				getSpeed();
			}
		}
		catch(DirectionException e) {
			e.printStackTrace();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}

	private static void getSpeed() throws DirectionException {
		if(direction.equalsIgnoreCase("cw") && reverseflag==false) {
			speed=fanops.pushForward(speed);			
		}
		else if(direction.equalsIgnoreCase("acw")) {
			reverseflag=true;
			speed=fanops.pushBackward(speed);
			if(speed==0)
			{
				reverseflag=false;
			}
		}
	}

	private static void getDirection() throws DirectionException {
		if(reverseflag==false) {
			if(speed!=0)System.out.println("Pull clockwise (cw) or anti-clockwise (acw): ");
			else System.out.println("Pull clockwise (cw) - Fan is at off setting");
			direction= readNextLine();
		}
		else if(reverseflag==true) {
			System.out.println("Pull only in anti-clockwise (acw) direction ");
			direction= readNextLine();
			if(!direction.equalsIgnoreCase("acw")) {
				System.out.println("Invalid direction");
			}
		}
		if(!(direction.equalsIgnoreCase("cw") || direction.equalsIgnoreCase("acw")) ) {
			throw new DirectionException("Invalid direction - pull in clockwise (cw) or anti-clockwise (acw)");
		}
	}

	static String readNextLine() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = in.readLine();	           
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		return line;
	}

	/*private static void setSpeed() {
		if(speed==null) {
		System.out.println("CurrentSpeed: ");
			speed= readNextLine();
			if(Integer.parseInt(speed)<0 || Integer.parseInt(speed)>3) {
				throw new SpeedException("Invalid speed");
			}

		} 
	}*/



}
