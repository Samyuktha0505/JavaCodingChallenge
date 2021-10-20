# JavaCodingChallenge
Simple Ceiling Fan Implementation

Objective:

The Aim is to implement simple ceiling fan implementation with two pull cords for speed settings. 
When the user pulls clockwise fan speed increases to one level. When the user pulls anticlockwise fan speed decreases to one level.

Working:
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

Warnings:
When the chord is pulled reverse, it should continue to reverse, a warning is mentioned in the console
Fan cannot move in reverse, when fan is at off setting

Exception:
Invalid direction: when entered wrong direction
