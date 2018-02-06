package frc.team5113.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import frc.team5113.managers.*;
import frc.team5113.subsytems.DriveTrain;
import frc.team5113.subsytems.PID_Controller;
import sensors.Gyro;
import sensors.Lidar;
import sensors.Proximity;
import sensors.StringPot;

public class Robot extends IterativeRobot
{
	DriveTrain dt;
	JoystickManager jm;
	SensorManager smanager;
	AutonManager auton;
	PID_Controller pid;
	//delete
	long time;
	
	@Override
    public void robotInit()
    {	
    	dt = new DriveTrain();
    	dt.init();
    	
    	jm = new JoystickManager();
    	jm.init();
    	
    	smanager = new SensorManager();
    	smanager.init();
    	//smanager.add(new Gyro("Gyro"));
    	smanager.add(new Proximity("Proximity", 3));
    	smanager.add(new Lidar("Lidar"));
    	smanager.add(new StringPot("StringPot", 1));
    	
    	pid = new PID_Controller(.05,0,0.05, smanager);
    	
    	
    	
    	auton = new AutonManager();
    	auton.init(smanager, dt, pid);
    	
    	//delete
    	time = System.currentTimeMillis();
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
    	auton.update();
    }

    @Override
    public void teleopPeriodic()
    {
    	jm.handleJoystickControls(dt);
    	smanager.update();

    	time = System.currentTimeMillis();
    }

    @Override
    public void testPeriodic()
    { 
    	
    }
}