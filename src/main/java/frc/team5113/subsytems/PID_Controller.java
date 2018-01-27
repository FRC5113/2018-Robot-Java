package frc.team5113.subsytems;

import sensors.Gyro;

public class PID_Controller
{
	
	    double p = 1;
	    double i = 1;
	    double d = 1; 
	    double f = 8080; // starting engine power
	    double period = 0.05;
	    double setpoint = 0;
	    private Gyro g;
	    private double previous_error, integral, derivative, rcw;
	    	   /* 
		PID_Controller PID_Controller(p, i, d, f, PID_Source, PID_Output, period);
		PID_Controller.setPID(p, i, d);
		PID_Controller.setPercentTolerance (percentage);
		PID_Controller.setSetpoint(setpoint);
		PID_Controller.setOutputRange(minimumOutput, maximumOutput);
		PID_Controller.enable();
		*/
    	public PID_Controller(Gyro g)
    	{
    		this.g = g;
    		previous_error = 0;
    		integral = 0;
    	}

    	public void setSetpoint(double setpoint)
    	{
    		this.setpoint = setpoint;// this sets the starting point (0 degrees)
    	}
		
    	public void PID()
        {
    		
    		double error = setpoint - g.getAngle(); // Error = Target - Actual (I'm also assuming that a clockwise angle is positive and counter clockwise is negative)
    		integral += (error*.02); // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
    		derivative = (error - previous_error) / .02;
    		rcw = p*error + i*integral + d*derivative;//these constants will need to be tested heavily to find out what works
    		previous_error = error;
        }

    	public double execute()
    	{
    		PID();
    		return rcw;
    	}
		
    	/*public void findAndChangeEnginePower(double change) //note a positive change increases right power and negative increases left. The total power is constant throughout auton
    	{
    		enginePower = f % 100; //this finds the right power
    		f = f - enginePower;
         	f = f / 100; //this finds the left power 
         	enginePower = enginePower + change;
         	f = f - change;
         	f = (enginePower * 100) + f;     
    	}*/

	
	
}
