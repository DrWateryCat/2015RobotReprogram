package org.usfirst.frc.team2186.robot;

import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team2186.robot.Input.JoystickData;

public class Lifter {
	private Talon lifter;
	
	private Lifter() {
		lifter = new Talon(RobotMap.LIFTER);
	}
	
	public void update() {
		JoystickData data = Input.getInstance().get();
		update(data.lifter);
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
