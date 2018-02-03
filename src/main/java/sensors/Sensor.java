package sensors;
public abstract class Sensor
{
    protected String name;
    public Sensor(String name)
    {
        this.name = name;
    }
    
    //updates the values from the sensor
    public void update(long elapsed) //elapsed is in nanoseconds
    {
        
    }
    
    //returns the name(key) from a sensor
    public String getName()
    {
        return name;
    }
}