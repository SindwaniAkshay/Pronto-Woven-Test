import java.io.*;
import java.util.*;
import java.lang.*;
/**
 * @author Akshay Sindwani
 */
public class RobotPronto
{
    public void instructions ()
    {
        System.out.println("This is a robot that will move as per your commands");
        System.out.println("These commands will tell the  robot to move forward or backward and to turn right or left");
        System.out.println("The commands will be in the format <command><number>");
        System.out.println("For example 'L1' would mean 'Turn left by 90 degrees once', 'B2' would mean 'Move backwards 2 units of distance'");
        System.out.println("###Available commands");
        System.out.println("`F` - move forward 1 unit \n`B` - move backward 1 unit \n`R` - turn right 90 degrees \n`L` - turn left 90 degrees");
    }

	public static void main(String [] args)
	{
		RobotPronto rp = new RobotPronto();
		rp.instructions();
	
	}
}
