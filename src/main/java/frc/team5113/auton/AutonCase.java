package frc.team5113.auton;

import frc.team5113.subsytems.DriveTrain;

public abstract class AutonCase
{
	public DriveTrain dt;
	
	public String code;
	
	public void init(String code)
	{
		this.code = code;
	}
	
	public abstract void update();
}
