package org.usfirst.frc.team2186.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick;

public class Lifter {
	Talon lifter;
	
	private Lifter() {
		lifter = new Talon(RobotMap.LIFTER);
	}
	
	public void update(Joystick j) {
		if(j.getRawButton(1) && !j.getRawButton(3)){
			update(-1);
		} else if(!j.getRawButton(1) && j.getRawButton(3)){
			update(1);
		} else {
			update(0);
		}
	}
	
	public void update(double x) {
		lifter.set(x);
	}
	
	protected static Lifter _instance = null;
	public static Lifter getInstance() {
		if(_instance == null){
			_instance = new Lifter();
		}
		return _instance;
	}
}
