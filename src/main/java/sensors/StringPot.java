package sensors;

import edu.wpi.first.wpilibj.AnalogInput;

public class StringPot extends SensorBase
{
    public double voltage;
    AnalogInput stringP;
    final double ratio = 10.58;
    public StringPot(String name)
    {
        super(name);
        this.name = name;
        stringP = new AnalogInput(1);
    }
    
    @Override
    public void update(long elapsed)
    {
        voltage = stringP.getValue();
    }

    public double getValue()
    {
        return (voltage-7)*ratio - .067;
    }
}
