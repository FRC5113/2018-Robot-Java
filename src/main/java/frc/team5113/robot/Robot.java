package frc.team5113.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import frc.team5113.managers.JoystickManager;
import frc.team5113.subsytems.DriveTrain;

public class Robot extends IterativeRobot
{
	DriveTrain dt;
	JoystickManager jm;
	
    @Override
    public void robotInit()
    {
    	dt = new DriveTrain();
    	dt.init();
    	
    	jm = new JoystickManager();
    	jm.init();
    }

    @Override
    public void disabledInit()
    {
    	
    }

    @Override
    public void autonomousInit()
    {
    	
    }

    @Override
    public void teleopInit()
    {
    	
    }

    @Override
    public void testInit()
    {
    	
    }

    @Override
    public void disabledPeriodic()
    {
    	
    }
    
    @Override
    public void autonomousPeriodic()
    {
    	
    }

    @Override
    public void teleopPeriodic()
    {
    	jm.handleJoystickControls(dt);
    }

    @Override
    public void testPeriodic()
    { 
    	
    }
}