package sensors;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import frc.team5113.subsytems.DriveTrain;

public class Encoders extends SensorBase
{
	private FeedbackDevice[] encoders;
	
	public Encoders(String name, DriveTrain dt) {
		super(name);
		encoders = dt.getEncoderValue();
	}
	
	@Override
	public void update(long elapsed) //elapsed is in nanoseconds
    {
        
    }
}
