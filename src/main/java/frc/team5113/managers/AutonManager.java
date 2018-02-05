package frc.team5113.managers;

import frc.team5113.auton.AutonCommands;
import frc.team5113.auton.MiddleSwitch;
import frc.team5113.subsytems.DriveTrain;
import frc.team5113.subsytems.PID_Controller;

public class AutonManager
{
	private int selectedCase;
	private final int NUM_OF_CASES = 0;
	AutonCommands command;
	MiddleSwitch middleSwitch;
	private int currentState;
	
	public void init()
	{
		selectedCase = 1;
		
		command = new AutonCommands();
		//command.init();
		middleSwitch = new MiddleSwitch();
		middleSwitch.init();
		
	}
	
	/*
	 * needs to return angle and speed
	 * needs to get 3 letter code
	 * 
	 */
	public void update()
	{
		switch(currentState)
		{
			case 0:
				//check current location and 3 letter code
				currentState = 1;
			break;
			
			case 1:
				//drive forward at 0 angle a distance
				currentState = 2;
			break;
			
			case 2:
				//check the distance
				//if over line stop
			break;
		}
	}
}
