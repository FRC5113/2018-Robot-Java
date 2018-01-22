package frc.team5113.managers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import frc.team5113.subsytems.DriveTrain;

public class JoystickManager
{
	Joystick leftStick;
	Joystick rightStick;
	
	public void init()
	{
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
	}
	
	public void handleJoystickControls(DriveTrain dt)
	{
		dt.drive(leftStick.getY(), rightStick.getY());
	}
}
