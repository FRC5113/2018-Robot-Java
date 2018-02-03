package frc.team5113.auton;

public class MiddleSwitch extends AutonCase
{
	int select = 0;
	boolean done;
	public void init()
	{
		done = false;
	}
	@Override
	public void update(AutonCommands command) {
		// TODO Auto-generated method stub
		if(!done)
			done = command.turnDegrees(360);
	}
	
	

}
