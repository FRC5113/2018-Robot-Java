package frc.team5113.auton;

import frc.team5113.managers.*;
import frc.team5113.subsytems.DriveTrain;

public class AutonCommands{
	
	DriveTrain dt;
	SensorManager sm;
	double goal; 
	double start;
	double turnGoal;
	int turnSelect;
	int driveSelect;
	double turnStart;
	double driveStart;
	double tolerance;
	public void init()
	{
		turnSelect = 0;
		driveSelect = 0;
		tolerance = 5.5;
	}
	
	public void update(DriveTrain dt, SensorManager sm)
	{
		this.dt = dt;
		this.sm = sm;
		
	}
	public boolean driveXDist(double goal)
	{
		boolean done = false;
		
		switch(driveSelect)
		{
		case 0:
			driveStart = sm.getDistance();					//sets a starting value to measure change from
			dt.drive(.5, .5);								//starts motors, which will stay on until turned off
			driveSelect++;									//goes to next step
			break;
		case 1:
			if(sm.getDistance()-driveStart >= goal)			//continue driving forward until go desired distance
				driveSelect++;								//go to next case/step
			break;
		case 2:
			dt.drive(0, 0);									//turns off motors
			driveSelect = 0;								//resets switch case so this method can be used again
			done = true;									//changes done to true so can move on to next step in auton code
			break;
		}
		
		return done;										//lets autonCase class know when it has finished dricing the desired distance
		
	}
	
	public boolean turnDegrees(double degrees) //if degree is negative, goes counter clockwise
	{
		boolean done = false;
		switch(turnSelect)
		{
		case 0:
			turnStart = sm.getGyro();
			System.out.println("turn start value: "+turnStart);
			if(degrees < 0)
				dt.drive(-.25, .25);
			else
				dt.drive(.25, -.25);
			turnSelect++;
			break;
			
		case 1:
			if(degrees < 0)
			{
				if(sm.getGyro()-turnStart <= degrees+tolerance)
				{
					turnSelect++;
					System.out.println("current value: "+sm.getGyro());
					System.out.println("difference: "+(sm.getGyro()-turnStart));
					
				}
			}
			else
			{
				
				if(sm.getGyro()-turnStart >= degrees-tolerance)
				{
					turnSelect++;
					System.out.println("current value: "+sm.getGyro());
					System.out.println("difference: "+(sm.getGyro()-turnStart));
					
				}
					
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
