package sensors;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Gyro extends Sensor
{
	private ADXRS450_Gyro gyru;
	public Gyro(String name)
	{
		super(name);
		this.name = name;
		gyru = new ADXRS450_Gyro(); 
		gyru.reset();
		gyru.calibrate();
	}
	
	public double getAngle()
	{
		return gyru.getAngle();
	}
	public double getRate()
	{
		return gyru.getRate();
	}
}
