package org.usfirst.frc.team2186.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team2186.robot.Input.JoystickData;

//This class controls the drive train.
//Not too much else to say

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
	
	public void update(){
		JoystickData data = Input.getInstance().get();
		update(data.x, data.y, data.z);
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
