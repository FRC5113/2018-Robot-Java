package sensors;

import edu.wpi.first.wpilibj.AnalogInput;

public class StringPot extends Sensor
{
    public double voltage;
    AnalogInput stringP;
    final double ratio = 10.58;
    public StringPot(String name, int port)
    {
        super(name);
        this.name = name;
        stringP = new AnalogInput(port);
    }
    
    @Override
    public void update(long elapsed)
    {
        voltage = stringP.getVoltage();
    }

    public double getValue()
    {
        return voltage*ratio - .06 ;
    }
}
