package frc.team5113.managers;

import java.util.HashMap;
import java.util.Map.Entry;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import sensors.Sensor;

public class SensorManager
{
    HashMap<String, Sensor> SensorMap;
    long timeTaken, lastUpdate = 0;
    long timeTolerance;
    AHRS navx;
    public void init() 
    {
    	timeTolerance = 5000000;
        SensorMap = new HashMap<String, Sensor>();
        navx = new AHRS(Port.kMXP);
    }
    
    //adds a sensor to the hashmap
    public void add(Sensor gyro)
    {
        this.SensorMap.put(gyro.getName(), gyro);
    }
    
    //Gets a sensor from the hashmap
    public Sensor get(String name)
    {
        return this.SensorMap.get(name);
    }
    
    public void setTolerance(long toleranceTime)
    {
        timeTolerance = toleranceTime;
    }
    
    //Update Loop
    public void update()
    {
        timeTaken = System.nanoTime() - lastUpdate; //in nanoseconds
       
        if(timeTaken >= timeTolerance)
        {
            lastUpdate = System.nanoTime();
            //System.out.println("Sensor Manager Update:" + (double)timeTaken / 1000000000 + "old man steroids Sam"); //In Seconds
            for(Entry<String, Sensor> entry : SensorMap.entrySet())
            {
                entry.getValue().update(timeTaken);
            }
            SmartDashboard.putNumber("NavX", navx.getAngle());
            
        }        
    }
    
    public double getAngle()
    {
    	return navx.getAngle();
    }
}
