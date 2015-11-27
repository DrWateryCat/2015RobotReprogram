package org.usfirst.frc.team2186.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;

public class Input {
	public static class JoystickData {
		double x;
		double y;
		double z;
		int lifter;
	}
	
	private Joystick j;
	private Input() {
		j = new Joystick(0);
	}
	
	public JoystickData get() {
		JoystickData ret = new JoystickData();
		ret.x = j.getAxis(AxisType.kX);
		ret.y = j.getAxis(AxisType.kY);
		ret.z = j.getAxis(AxisType.kZ);
		if(j.getRawButton(1) && !j.getRawButton(3)){
			ret.lifter = -1;
		} else if(!j.getRawButton(1) && j.getRawButton(3)){
			ret.lifter = 1;
		} else {
			ret.lifter = 0;
		}
		return ret;
	}
	
	private static Input instance = null;
	public static Input getInstance() {
		if(instance == null)
			instance = new Input();
		return instance;
	}
}
