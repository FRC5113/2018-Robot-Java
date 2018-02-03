package frc.team5113.managers;

import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import sensors.*;

import java.util.*;
public class SensorManager
{
    HashMap<String, SensorBase> SensorMap;
    long timeTaken, lastUpdate = 0;
    long timeTolerance;
    Gyro gyro;
    Proximity proximity;
    StringPot pot;
    Lidar lidar;
    public void init() {
    	timeTolerance = 5000000;
        SensorMap = new HashMap<String, SensorBase>();
        
        gyro = new Gyro("Gyro");
        proximity = new Proximity("Proximity");
        //this.addAll();
        pot = new StringPot("StringPot");
        lidar = new Lidar("Lidar");
    }
     public void addAll()
     {
    	 //this.add(lidar);
    	 //this.add(gyro);
    	 //this.add(proximity);
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
        	//System.out.println(gyro.getAngle());
        	long time = System.nanoTime();
        	pot.update(time);
        	lidar.update(time);
        	SmartDashboard.putNumber("Gyro", gyro.getAngle());
        	//System.out.println(SmartDashboard.getNumber("Gyro", 0));
        	
        	SmartDashboard.putNumber("StringPot", pot.getValue());
        	//System.out.println(pot.getValue());
        	
        	SmartDashboard.putNumber("Lidar", lidar.getDistance());
        	//System.out.println("Lidar: " + lidar.getDistance());
        }
        
        
    }
    
    public double getGyro()
    {
    	return gyro.getAngle();
    }
    public double getDistance()
    {
    	return 10;
    }
}
