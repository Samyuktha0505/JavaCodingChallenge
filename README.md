# JavaCodingChallenge
Simple Ceiling Fan Implementation

Objective:

The Aim is to implement simple ceiling fan implementation with two pull cords for speed settings. 
When the user pulls clockwise fan speed increases to one level. When the user pulls anticlockwise fan speed decreases to one level.

Working:

I have tried to provide two approaches here, one with java console (user can interact with console and provide inputs to check) and other with maven auto build (build junit cases and run then with maven)

-> Enter the direction in which fan is rotated
-> Initially fan speed is at off setting
-> Clock wise cord can only be pulled
-> Fan speed increases by one level, when clockwise chord is pulled
   0 -> 1 -> 2 -> 3 -> 0
-> Fan speed decreases by one level, when anticlockwise chord is pulled 
   3 -> 2 -> 1 -> 0
-> Once the direction is reversed it continues to be in reverse through out speed setting till zero
   Anticlock wise chord cannot be pulled when the fan is in off state
-> If any other direction is entered, program ends with a custom exception

Junit test cases:
-> when the chord is pulled twice in clockwise direction
-> when the chord is pulled thrice in clockwise direction
-> when the chord is pulled four times in clockwise direction
-> when the chord is pulled two in anticlockwise direction
-> when the chord is pulled four times in anticlockwise direction
-> when the chord is pulled anticlockwise direction when fan is off
-> All the test cases are passed

Maven Junit test cases:
-> when chord is pulled two times in clockwise direction
-> when the chord is pulled three times in clockwise direction
-> when the chord is pulled four times in clockwise direction
-> when direction is changed at non zero speed to anticlockwise direction
-> when direction is changed at zero speed to anticlockwise direction
-> Default direction test
-> All the test cases are passed

Warnings to console:
When the chord is pulled reverse, it should continue to reverse, a warning is mentioned in the console
Fan cannot move in reverse, when fan is at off setting

Exception:
Invalid direction: when entered wrong direction
