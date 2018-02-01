package frc.team5113.managers;

import frc.team5113.auton.AutonDrive;
import frc.team5113.auton.MiddleSwitch;
import frc.team5113.subsytems.DriveTrain;

public class AutonManager
{
	private int selectedCase;
	private final int NUM_OF_CASES = 0;
	AutonDrive au;
	MiddleSwitch middleSwitch;
	public void init()
	{
		selectedCase = 1;
		
		au = new AutonDrive();
		au.init();
		middleSwitch = new MiddleSwitch();
		middleSwitch.init();
		
	}
	
	public void update(DriveTrain dt, SensorManager sm)
	{
		au.update(dt, sm);
		middleSwitch.update(au);
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
