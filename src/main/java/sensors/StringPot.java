package sensors;


import edu.wpi.first.wpilibj.AnalogInput;

public class StringPot extends SensorBase
{
    public double height;
    AnalogInput stringP;
    public StringPot(String name)
    {
        super(name);
        this.name = name;
        stringP = new AnalogInput(1);
    }

    public void update()
    {
        height = stringP.getValue();
    }

    public double getValue()
    {
        return height;
    }
}
