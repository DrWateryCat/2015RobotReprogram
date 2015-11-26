package org.usfirst.frc.team2186.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Talon;

public class Drive {
	Talon left;
	Talon right;
	Talon left_side;
	Talon right_side;
	double multiplier;
	private Drive() {
		left = new Talon(RobotMap.DriveTrain.LEFT);
		right = new Talon(RobotMap.DriveTrain.RIGHT);
		left_side = new Talon(RobotMap.DriveTrain.LEFT_SIDE);
		right_side = new Talon(RobotMap.DriveTrain.RIGHT_SIDE);
		multiplier = SmartDashboard.getNumber("multiplier", 1);
	}
	
	public void update(double x, double y, double z) {
		multiplier = SmartDashboard.getNumber("multiplier");
		double leftAmt = (-y) + z;
		double rightAmt = y + z;
		
		leftAmt = Utils.deadzone(leftAmt);
		leftAmt *= multiplier;
		rightAmt = Utils.deadzone(rightAmt);
		rightAmt *= multiplier;
		
		left.set(leftAmt);
		right.set(rightAmt);
		
		left_side.set(x);
		right_side.set(x);
	}
	
	public void update(Joystick j){
		update(j.getAxis(AxisType.kX), j.getAxis(AxisType.kY), j.getAxis(AxisType.kZ));
	}
	
	//Singleton
	protected static Drive _instance = null;
	public static Drive getInstance() {
		if(_instance == null) {
			_instance = new Drive();
		}
		return _instance;
	}
}
