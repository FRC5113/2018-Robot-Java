package frc.team5113.managers;

import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import sensors.*;

import java.util.*;
public class SensorManager
{
    private HashMap<String, SensorBase> SensorMap;
    private long timeTaken, lastUpdate = 0;
    private long timeTolerance;
    private Gyro gyro;
    public void init() {
    	timeTolerance = 5000;
        SensorMap = new HashMap<String, SensorBase>();
        
        gyro = new Gyro("Gyro");
        
        //this.addAll();
        
    }
     public void addAll()
     {
    	 //this.add(lidar);
    	 //this.add(gyro);
     }
    
    //adds a sensor to the hashmap
    public void add(SensorBase sensor)
    {
        this.SensorMap.put(sensor.getName(), sensor);
    }
    
    //Gets a sensor from the hashmap
    public SensorBase get(String name)
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
            /*lastUpdate = System.nanoTime();
            System.out.println("Sensor Manager Update:" + (double)timeTaken / 1000000000 + "old man steroids Sam"); //In Seconds
            for(Map.Entry <String, SensorBase> entry : SensorMap.entrySet())
            {
                entry.getValue().update(timeTaken);
            }*/
        	System.out.println(gyro.getAngle());
        	SmartDashboard.putNumber("Gyro", gyro.getAngle());
        }
    }
}
