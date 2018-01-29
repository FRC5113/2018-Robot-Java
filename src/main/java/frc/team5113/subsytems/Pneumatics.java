package frc.team5113.subsytems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Pneumatics
{
	Compressor comp;
	
	DoubleSolenoid leftSolenoid;
	DoubleSolenoid rightSolenoid;
	
	public void init()
	{
		comp = new Compressor();
		leftSolenoid = new DoubleSolenoid(0, 1);
		rightSolenoid = new DoubleSolenoid(2, 3);
	}
	
	public void setComp(boolean power)
	{
		comp.setClosedLoopControl(power);
		
		System.out.println("getClosedLoopControl(): " + comp.getClosedLoopControl());
		System.out.println("getCompressorCurrent: " + comp.getCompressorCurrent());
	}
	
	public void move(boolean up)
	{
		if(up)
		{
			leftSolenoid.set(Value.kForward);
			rightSolenoid.set(Value.kForward);
		}
		else
		{
			leftSolenoid.set(Value.kReverse);
			rightSolenoid.set(Value.kReverse);
		}
	}
}
