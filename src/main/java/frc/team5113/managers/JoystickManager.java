package frc.team5113.managers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team5113.subsytems.DriveTrain;
import frc.team5113.subsytems.Pneumatics;

public class JoystickManager
{
	Joystick leftStick;
	Joystick rightStick;
	
	JoystickButton compOn;
	JoystickButton compOff;
	JoystickButton test;
	
	boolean compressor;
	
	public void init()
	{
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		
		compOn = new JoystickButton(leftStick, 3);
		compOff = new JoystickButton(leftStick, 4);
		
		test = new JoystickButton(leftStick, 5);
		
		compressor = false;
	}
	
	public void handleJoystickControls(DriveTrain dt, Pneumatics pm)
	{
		dt.drive(leftStick.getY(), rightStick.getY());
		
		if(compOn.get())
			pm.setComp(true);
		else if(compOff.get())
			pm.setComp(false);
		
		if(test.get())
			pm.move(true);
	}
}
