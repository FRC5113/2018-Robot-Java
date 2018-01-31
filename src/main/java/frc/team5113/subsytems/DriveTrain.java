package frc.team5113.subsytems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveTrain
{
	WPI_TalonSRX leftRear;
	WPI_TalonSRX leftFront;
	WPI_TalonSRX rightRear;
	WPI_TalonSRX rightFront;
	FeedbackDevice lr, lf, rr, rf;
	
	public void init()
	{
		leftRear = new WPI_TalonSRX(15);
		leftFront = new WPI_TalonSRX(14);
		rightRear = new WPI_TalonSRX(0);
		rightFront = new WPI_TalonSRX(1);
		/*
		leftRear.configSelectedFeedbackSensor(lr, 0, 100);
		leftFront.configSelectedFeedbackSensor(lf, 0, 100);
		rightRear.configSelectedFeedbackSensor(rr, 0, 100);
		rightFront.configSelectedFeedbackSensor(rf, 0, 100);*/
		
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
	
	
	@SuppressWarnings("static-access")
	public FeedbackDevice[] getEncoderValue()
	{
		FeedbackDevice[] encoderValue = new FeedbackDevice[4];
		encoderValue[0] = lr;
		encoderValue[1] = lf;
		encoderValue[2] = rr;
		encoderValue[3] = rf;
		
		return encoderValue;
		
	}
	
	public double getEnginePowerLeft()
	{
		return leftRear.get();
	}
	
	public double getEnginePowerRight()
	{
		return rightRear.get();
	}
	
}
