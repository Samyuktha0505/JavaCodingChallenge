package ceilingfandesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CeilingFanMain {
	
	// assuming initially the fan is in off setting
	static int speed=0;
	static boolean reverseflag=false;
	static String direction=null;
	static CeilingFanOperations fanops = new CeilingFanOperations();

	public static void main(String[] args) throws DirectionException {
		try {
			while (true) {	
				// get the user direction in which the chord will be pulled
				getDirection();
				// get the speed accordingly
				getSpeed();
			}
		}
		// custom exception
		catch(DirectionException e) {
			e.printStackTrace();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private static void getDirection() throws DirectionException {
		if(reverseflag==false) {
			if(speed!=0)
			{
				System.out.println(" Pull clockwise (cw) or anti-clockwise (acw): ");
			}
			else {
				System.out.println(" Pull clockwise (cw) ");
			}
			direction= readNextLine();
		}
		else if(reverseflag==true) {
			System.out.println(" Pull only in anti-clockwise (acw) direction: ");
			direction= readNextLine();
			if(!direction.equalsIgnoreCase("acw")) {
				System.out.println("Invalid direction");
			}
		}
		if(!(direction.equalsIgnoreCase("cw") || direction.equalsIgnoreCase("acw")) ) {
			throw new DirectionException("Invalid direction - pull in clockwise (cw) or anti-clockwise (acw)");
		}
	}

	private static void getSpeed() throws DirectionException {
		if(direction.equalsIgnoreCase("cw") && reverseflag==false) {
			speed=fanops.pushForward(speed);
			System.out.print("Current Speed: "+speed);
		}
		else if(direction.equalsIgnoreCase("acw")) {
			reverseflag=true;
			speed=fanops.pushBackward(speed);
			System.out.print("Current Speed: "+speed);
			if(speed==0)
			{	System.out.print(" Can't go in reverse, when Fan is at rest");
			reverseflag=false;
			}
		}
	}

	// reading user input from console
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



}
