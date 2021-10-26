package org.CodingChallengeWithMaven;

/**
* The DirectionException is a custom exception
* is caught if invalid direction is entered in console
* or if fan direction changes to anti clockwise at rest
* or if speed is changed in anti clock wise direction at rest
* @author  sa384156
* @version 1.0
* @since   2021-10-22
*/
public class DirectionException extends RuntimeException {

	private static final long serialVersionUID = 367937805920014188L;

	public DirectionException(String message) {
        super(message);
    }
}
