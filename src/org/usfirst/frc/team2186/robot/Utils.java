package org.usfirst.frc.team2186.robot;

public class Utils {
	
	//Returns the middle of three input numbers.
	public static double clamp(double in, double min, double max){
		return Math.max(min, Math.min(max,  in));
	}
	
	//Deadzone calculation.
	//Used to prevent issues when the joystick is neutral.
	//Also keeps joystick values between -1 and 1, for motor controllers.
	public static double deadzone(double in){
		double res = clamp(in, -1, 1);
		if(Math.abs(res) < 0.1) {
			return 0;
		}
		return res;
	}
}
