package frc.team5113.subsytems;

import frc.team5113.managers.SensorManager;
import sensors.Gyro;

public class PID_Controller
{
	private double kp, ki, kd;
	private long lastUpdate;
	private double summedError, lastError, setPoint;
	SensorManager sm;
	DriveTrain dt;
	public PID_Controller(double kp, double ki, double kd, SensorManager sm)
	{
		this.kp = kp;
		this.ki = ki;
		this.kd = kd;
		this.sm = sm;
		lastUpdate = System.nanoTime() / 1000000000;
		setPoint = 0;
	}
	
	public void init(DriveTrain dt)
	{
		this.dt = dt;
	}
	public PID_Controller()
	{
		kp = ki = kd = 1;
		
		lastUpdate = System.nanoTime();
	}

	public double update()
	{
		double angle = sm.getAngle();
		long dTime = System.nanoTime() / 1000000000 - lastUpdate;
		double retVal = 0;
		//if (dTime > 0.004)
		{
			double error = setPoint - angle; 
			summedError = (summedError + error) * dTime;
			double dError = (error - lastError) / dTime;
			
			retVal = kp * error + ki * summedError + kd * dError; 
			lastUpdate = System.nanoTime() / 1000000000;
		}
			return retVal;	
	}
	
	public void pidDrive(double speed)	//speed in -1 to 1
	{
		double change = this.update();
		dt.drive(speed-change, speed+change);
	}
	public void setSetPoint(double x)
	{
		setPoint = x;
	}
}


