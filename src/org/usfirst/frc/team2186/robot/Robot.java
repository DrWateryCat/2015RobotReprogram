
package org.usfirst.frc.team2186.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

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
	
	Drive drive = Drive.getInstance();
	Joystick j0 = new Joystick(0);
	Lifter lifter = Lifter.getInstance();
	Autonomous auto;
    public void robotInit() {

    }
    
    public void autonomousInit() {
    	auto = Autonomous.getInstance();
    	auto.init();
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	auto.update();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drive.update(j0);
        lifter.update(j0);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
