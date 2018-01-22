package frc.team5113.subsytems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveTrain
{
	WPI_TalonSRX leftRear;
	WPI_TalonSRX leftFront;
	WPI_TalonSRX rightRear;
	WPI_TalonSRX rightFront;
	
	public void init()
	{
		leftRear = new WPI_TalonSRX(2);
		leftFront = new WPI_TalonSRX(3);
		rightRear = new WPI_TalonSRX(0);
		rightFront = new WPI_TalonSRX(1);

		leftRear.setInverted(true);
		leftFront.setInverted(true);
	}
	
	public void drive(double leftPower, double rightPower)
	{
		leftPower *= 0.99;
		rightPower *= 0.99;
	
		leftRear.set(leftPower);
		leftFront.set(leftPower);
		rightRear.set(rightPower);
		rightFront.set(rightPower);
	}
	
	
}
