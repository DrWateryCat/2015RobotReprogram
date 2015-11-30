
package org.usfirst.frc.team2186.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	//Define singletons
	Drive drive;
	Lifter lifter;
	Autonomous auto;
	
	//Init singletons
    public void robotInit() {
    	drive = Drive.getInstance();
    	lifter = Lifter.getInstance();
    	auto = Autonomous.getInstance();
    }
    
    //This is called once when the robot enters Autonomous Mode
    public void autonomousInit() {
    	auto.init();
    	
    }
    
    //This is called periodically while the robot is in Autnomous Mode
    public void autonomousPeriodic() {
    	auto.update();
    }
    
    /*
     * This function is called before operator control
     */
    public void teleopInit() {
    	auto.stop();
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drive.update();
        lifter.update();
    }
    
}
