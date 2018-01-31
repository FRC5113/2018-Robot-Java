package frc.team5113.managers;

import frc.team5113.subsytems.DriveTrain;

public class AutonManager
{
	private int selectedCase;
	private final int NUM_OF_CASES = 0;
	
	public void init()
	{
		selectedCase = 1;
	}
	
	public void update(DriveTrain dt, SensorManager sm)
	{
		switch(selectedCase)
		{
		default:
			break;
		}
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
