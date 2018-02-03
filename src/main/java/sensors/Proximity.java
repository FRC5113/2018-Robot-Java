package sensors;

import edu.wpi.first.wpilibj.AnalogInput;

public class Proximity extends Sensor
{
	private AnalogInput proximity;
	private double voltage;
	public Proximity(String name, int port)
	{
		super(name);
    	this.name = name;
    	proximity = new AnalogInput(port); //based on location on roborio
	}
	
	//10-80cm sensor
	@Override
	public void update(long elapsed)
	{
		voltage = proximity.getVoltage();
		
	}
	
	public boolean getBox()
	{
		if (voltage > 1) //value is 1 for the 10-80 sensor; .5 for 4-30
			return true;
		else
			return false;
	}
	
	
}

