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
		leftRear = new WPI_TalonSRX(2);
		leftFront = new WPI_TalonSRX(3);
		rightRear = new WPI_TalonSRX(0);
		rightFront = new WPI_TalonSRX(1);
		
		leftRear.configSelectedFeedbackSensor(lr, 0, 100);
		leftFront.configSelectedFeedbackSensor(lf, 0, 100);
		rightRear.configSelectedFeedbackSensor(rr, 0, 100);
		rightFront.configSelectedFeedbackSensor(rf, 0, 100);
		
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
		encoderValue[0] = lr.valueOf("CTRE_MagEncoder_Relative ");
		encoderValue[1] = lf.valueOf("CTRE_MagEncoder_Relative ");
		encoderValue[2] = rr.valueOf("CTRE_MagEncoder_Relative ");
		encoderValue[3] = rf.valueOf("CTRE_MagEncoder_Relative ");
		
		return encoderValue;
		
	}
	
	
}
