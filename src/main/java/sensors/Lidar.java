package sensors;

import edu.wpi.first.wpilibj.I2C;

public class Lidar extends Sensor
{
	I2C dar;
	byte[] data = {0x04, 0x09};
	byte[] buffer;
	int distance, velocity;
	
	public Lidar(String name)
	{
		super(name);
		dar = new I2C(I2C.Port.kOnboard, 0x62);
		
		buffer = new byte[8];
	}
	
	@Override
	public void update(long elapsed) //elapsed is in nanoseconds
    {
		int bottomHalf, topHalf;
		
		dar.write(0x00,  0x04);
		
		sleep(0.1);
		
		buffer[0] = (byte)0xFF;
		while((buffer[0] & 0x01) == 1)
		{
			buffer[0] = (byte)0x01;
			dar.writeBulk(buffer, 1);
			
			sleep(0.1);
			
			dar.readOnly(buffer, 1);
		}
		
		buffer[0] = (byte)0x8f;
		dar.writeBulk(buffer, 1);
		sleep(0.1);
		dar.readOnly(buffer, 2);
		distance = 0;
		topHalf = buffer[0] & 0xFF;
		bottomHalf = buffer[1] & 0xFF;
		distance = (topHalf << 8) + bottomHalf;
		
		sleep(0.1);
		buffer[0] = (byte)0x09;
		dar.writeBulk(buffer, 1);
		sleep(0.1);
		dar.readOnly(buffer,  1);
		velocity = buffer[0];
    }
	
	
	
	public int getDistance()
	{
		return distance; 			//cm
	}
	
	public double getVelocity()
	{
		return velocity;
	}
	
	private void sleep(double time)
	{
		long startTime = System.nanoTime();
		
		while((System.nanoTime() - startTime)/1000000.0 < time)
		{}
	}
}
