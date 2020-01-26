import java.io.*;
import java.util.*;
import java.util.regex.*;
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
	
	public void inputCommands()
	{
		String command;
		Scanner scan = new Scanner (System.in);
		char cont = 'y';
		do
		{				
			int x = 0;
			int y = 0;
			int direction = 0;
			cont = 'n';
			System.out.println("Please enter your commands for the robot");
			command = scan.next();
			String [] commands = command.split(",");
			for (String cmnd : commands)
			{
				try
				{
						char alphabet = cmnd.toLowerCase().charAt(0);
						int numerical = Character.getNumericValue(cmnd.charAt(1));
						System.out.println(""+cmnd);
						System.out.println(""+alphabet);
						System.out.println(""+numerical);
						
						switch (direction)
						{
							case 0 : 
							switch (alphabet)
							{
								case 'f' : y += numerical;
											break;
								case 'b' : y-= numerical;
											break;
							}
							break;
							
							case 1 :
							switch (alphabet)
							{
								case 'f' : x += numerical;
											break;
								case 'b' : x -= numerical;
											break;
							}
							break;
							
							case 2:
							switch (alphabet)
							{
								case 'f' : y -= numerical;
											break;
								case 'b' : y += numerical;
											break;
							}
							break;
							case 3:
							switch (alphabet)
							{
								case 'f' : x -= numerical;
											break;
								case 'b' : x+= numerical;
											break;
							}
							break;
						}
						
						//System.out.println(""+x+""+y);
				}
					
					catch(Exception e)
					{
						
					}
					
			}
					
					int answer = Math.abs(x) + Math.abs (y);
					System.out.println("The answer is: " + answer);
					System.out.println("Do you wish to continue? Please press 'Y' to enter another set of commands and 'N' to terminate.");
					cont = scan.next().charAt(0);
			
			
		}while (cont == 'y' || cont == 'Y');
		
	}
	
	public static int setFace(String alphabet, int numerical, int currentFacing)
	{
		switch (alphabet)
		{
			case 'r' : switch (numerical)
					   {
						   case 0 : currentFacing += 0;
									break;
						   case 1 : currentFacing += 1;
									break;
						   case 2 : currentFacing += 2;
									break;
						   case 3 : currentFacing += 3;
									break;
				
					   }
					   break;
			case 'l' : switch (numerical)
						{
							case 0 : currentFacing +=0;
										break;
							case 1 : currentFacing += 3;
										break;
							case 2 : currentFacing += 2;
										break;
							case 3 : currentFacing += 1;
				
						}
						break;
						
		}
		currentFacing = currentFacing % 4;
		return currentFacing;
	}

	public static void main(String [] args)
	{
		RobotPronto rp = new RobotPronto();
		rp.instructions();
		rp.inputCommands();
	
	}
}
