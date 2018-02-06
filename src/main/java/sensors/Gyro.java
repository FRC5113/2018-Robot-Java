package sensors;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public void update()
	{
		SmartDashboard.putNumber("Gyro", this.getAngle());
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
