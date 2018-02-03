package frc.team5113.subsytems;

public class SpeedController 
{
	private double accelAbs, accel;
	private long t0;
	private double v0, vf, vc;
	
	public SpeedController(double accel) //% per second
	{
		this.accelAbs = accel;
		
		v0 = vf = vc = 0;
	}
	
	public void setDesiredSpeed(double speed)
	{
		v0 = vc;
		t0 = System.currentTimeMillis();
		vf = speed;
		if (vf < v0)
		{
			accel = -accelAbs;
		}
		else
			accel = accelAbs;
	}
	
	public void update()
	{
		if(((vc < vf) && accel > 0 )|| ((vc > vf) && accel < 0))
			vc = accel*((System.currentTimeMillis() - t0)/1000.0) + v0;
		else
			vc = vf;
		
	}
	
	public double get()
	{
		return vc;
	}
	
}


