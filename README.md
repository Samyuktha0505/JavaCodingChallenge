# JavaCodingChallenge


Simple Ceiling Fan Implementation


Project Description:
In any language, implement a simple ceiling fan with these characteristics:

·         The unit has 2 pull cords:

o   One increases the speed each time it is pulled.  There are 3 speed settings, and an “off” (speed 0) setting. 

§  If the cord is pulled on speed 3, the fan returns to the “off” setting.

o   One reverses the direction of the fan at the current speed setting.

§  Once the direction has been reversed, it remains reversed as we cycle through the speed settings, until reversed again.

·         You can assume the unit is always powered (no wall switch)


Objective:
The Aim is to implement simple ceiling fan with two pull cords for speed settings and to obey all the rules mentioned in the description.


Working:
I have tried to provide two approaches here, one with java console (user can interact with console and provide inputs to check) and 
other with maven auto build (build junit cases and run them with maven).


Extensibility:
Fan speed settings are mentioned in a properties file, the code can handle different min, max settings of the fan and execute test cases accordingly.


Testing in Console: 
-> Initially fan speed is at off setting
-> Enter the direction in which fan is rotated(cw/acw)
-> Clock wise cord can only be pulled from zero
-> Fan speed increases by one level, when clockwise chord is pulled
   0 -> 1 -> 2 -> 3 -> 0 -> 1 -> 2 -> 3
-> Fan speed decreases by one level, when anticlockwise chord is pulled 
   3 -> 2 -> 1 -> 0
-> Once the direction is reversed, it remains reversed as we cycle through the speed settings, until reversed again
-> current speed setting(Direction pulled) : 0(cw)->1(cw)->2(acw)->1(cw)->2(cw)->3(acw)->2(cw)->3(cw)->0(cw)
   Anticlock wise chord cannot be pulled when the fan is in off state
-> If any other direction is entered, program ends with a custom exception


Junit test cases:
-> when the cord is pulled twice in clockwise direction - should give current speed as minimum fan setting+2
-> when the cord is pulled max times and one more than max in clockwise direction - should give current speed as max and min respectively
-> when direction is changed at non zero speed to anticlockwise direction - Direction changes to anticlockwise
-> Default direction test - clockwise
-> when the cord is pulled anticlockwise direction when fan is off - exception expected
-> when the cord is pulled max times in anti clockwise direction starting with max speed - should give current speed as minimum
-> when cord is pulled in clockwise direction and anti clockwise direction - got expected speed
-> when direction is changed to anti clockwise when fan is off - exception expected
-> All the test cases are passed


Custom Exception:
DirectionException:
Exception Messages: 
"Can't change to anticlockwise direction, when fan is at rest"
"Can't move in anticlockwise direction, when fan is at rest"
"Invalid Direction"


Logging:
Apache log4j 2.13.0 is used for logging purpose, log level is set to info, loggers are appended to console


Software used:
Eclipse IDE 2021
Java 1.7
Junit 4.11
Maven dependencies
Apache log4j 2.13.0


