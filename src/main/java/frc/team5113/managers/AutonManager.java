package frc.team5113.managers;

import frc.team5113.auton.AutonCommands;
import frc.team5113.auton.MiddleSwitch;
import frc.team5113.subsytems.DriveTrain;

public class AutonManager
{
	private int selectedCase;
	private final int NUM_OF_CASES = 0;
	AutonCommands command;
	MiddleSwitch middleSwitch;
	public void init()
	{
		selectedCase = 1;
		
		command = new AutonCommands();
		//command.init();
		middleSwitch = new MiddleSwitch();
		middleSwitch.init();
		
	}
	
	public void update(DriveTrain dt, SensorManager sm)
	{
		//command.update(dt, sm);
		middleSwitch.update(command);
		/*switch(selectedCase)
		{
		default:
			break;
		}*/
	}
	
	public void setCase(int autonCase)
	{
		this.selectedCase = autonCase % NUM_OF_CASES;
	}
	
	public int getCase()
	{
		return selectedCase;
	}
}
