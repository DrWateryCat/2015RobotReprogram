package org.usfirst.frc.team2186.robot;

import edu.wpi.first.wpilibj.Timer;

public class Autonomous {
	Drive drive;
	Timer autoTimer;
	private Autonomous(){
	}
	//Call this in IterativeRobot.autonomousInit
	public void init() {
		drive = Drive.getInstance();
		autoTimer = new Timer();
		autoTimer.start();
	}
	boolean passed;
	public void update() {
		passed = autoTimer.hasPeriodPassed(7.0);
		if(!passed) {
			drive.update(0, 0.5, 0);
		} else {
			drive.update(0, 0, 0);
		}
	}
	
	private static Autonomous _instance = null;
	public static Autonomous getInstance() {
		if(_instance == null){
			_instance = new Autonomous();
		}
		return _instance;
	}
}
