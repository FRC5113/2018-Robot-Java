package frc.team5113.auton;

import frc.team5113.managers.*;
import frc.team5113.subsytems.DriveTrain;

public class AutonDrive{
	
	DriveTrain dt;
	SensorManager sm;
	double goal; 
	double start;
	double turnGoal;
	int turnSelect;
	int driveSelect;
	double turnStart;
	double driveStart;
	
	public void init(DriveTrain dt, SensorManager sm)
	{
		this.dt = dt;
		this.sm = sm;
		turnSelect = 0;
		driveSelect = 0;
	}
	
	public boolean driveXDist(double goal)
	{
		boolean done = false;
		
		switch(driveSelect)
		{
		case 0:
			driveStart = sm.getDistance();
			dt.drive(.5, .5);
			driveSelect++;
			break;
		case 1:
			if(sm.getDistance()-driveStart >= goal)
				driveSelect++;
			break;
		case 2:
			dt.drive(0, 0);
			driveSelect = 0;
			done = true;
			break;
		}
		
		return done;
		
	}
	
	public boolean turnDegreesCounter(double degrees) //if degree is negative, goes counter
	{
		boolean done = false;
		switch(turnSelect)
		{
		case 0:
			turnStart = sm.getGyro();
			if(degrees < 0)
				dt.drive(-.5, .5);
			else
				dt.drive(.5, -.5);
			turnSelect++;
			break;
			
		case 1:
			if(degrees < 0)
			{
				if(sm.getGyro()-turnStart <= degrees)
					turnSelect++;
			}
			else
			{
				if(sm.getGyro()-turnStart >= degrees)
					turnSelect++;
			}
			break;
		case 2:
			dt.drive(0, 0);
			turnSelect = 0;
			done = true;
			break;
		}
		return done;
			
	}
	
	

	
}
