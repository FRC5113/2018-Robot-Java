package frc.team5113.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import frc.team5113.managers.*;
import frc.team5113.subsytems.DriveTrain;

public class Robot extends IterativeRobot
{
	DriveTrain dt;
	JoystickManager jm;
	SensorManager smanager;
	AutonManager auton;
	@Override
    public void robotInit()
    {
    	dt = new DriveTrain();
    	dt.init();
    	
    	jm = new JoystickManager();
    	jm.init();
    	
    	smanager = new SensorManager();
    	smanager.init();
    }

    @Override
    public void disabledInit()
    {
    	
    }

    @Override
    public void autonomousInit()
    {
    	auton = new AutonManager();
    	auton.init();
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
    	smanager.update();

    	
    }

    @Override
    public void testPeriodic()
    { 
    	
    }
}