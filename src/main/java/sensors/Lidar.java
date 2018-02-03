package sensors;

import edu.wpi.first.wpilibj.I2C;

public class Lidar extends SensorBase
{
	I2C dar;
	byte[] data = {0x04, 0x09};
	byte[] buffer;
	int size;
	int distance, velocity;
	public Lidar(String name) {
		super(name);
		dar = new I2C(I2C.Port.kOnboard, 0x62);
		
		buffer = new byte[8];
	}
	
	@Override
	public void update(long elapsed) //elapsed is in nanoseconds
    {
		boolean valid = false;
		
		dar.write(0x00,  0x04);
		
		sleep(1);
		
		if(true)
		{			
			buffer[0] = (byte)0xFF;
			while((buffer[0] & 0x01) == 1)
			{
				buffer[0] = (byte)0x01;
				dar.writeBulk(buffer, 1);
				
				sleep(1);
				
				dar.readOnly(buffer, 1);
			}
			
			buffer[0] = (byte)0x8f;
			dar.writeBulk(buffer, 1);
			
			sleep(1);
			
			dar.readOnly(buffer, 2);
			
			distance = 0;
			distance = buffer[0];
			distance <<= 8;
			distance += buffer[1];
			
			dar.read(0x09, 1, buffer);
			velocity = buffer[0];
		}
    }
	
	public int getDistance()
	{
		return distance; 			//cm
	}
	
	public double getVelocity()
	{
		return velocity;
	}
	
	private void sleep(long time)
	{
		long startTime = System.nanoTime();
		
		while((System.nanoTime() - startTime)/1000000 < time)
		{}
	}
}
