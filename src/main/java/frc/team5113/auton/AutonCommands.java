package frc.team5113.auton;

import frc.team5113.managers.SensorManager;
import frc.team5113.subsytems.DriveTrain;
import frc.team5113.subsytems.PID_Controller;
import sensors.Gyro;
import sensors.Lidar;

public class AutonCommands{
	
	DriveTrain dt;
	SensorManager sm;
	PID_Controller pid;
	double goal; 
	double start;
	double turnGoal;
	int turnSelect;
	int driveSelect;
	double turnStart;
	double driveStart;
	double tolerance;
	
	//Sensors
	Gyro gyro;
	Lidar lidar;
	
	public void init(SensorManager sm, PID_Controller pid, DriveTrain dt)
	{
		turnSelect = 0;
		driveSelect = 0;
		tolerance = 5.5;
		
		this.dt = dt;
		this.pid = pid;
		this.sm = sm;
		
		gyro = (Gyro) sm.get("Gyro");
		lidar = (Lidar) sm.get("Lidar");
		
		
	}
	
	public void update()
	{
		pid.pidDrive(.25);
	}	
}
