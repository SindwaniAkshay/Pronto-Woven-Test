import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.lang.*;
/**The program is meant to calculate the minimum path to be travelled by the robot to reach it's starting position.
 * @author Akshay Sindwani
 */
public class RobotPronto
{
    //Displays the instructions and the examples for the user. Explaining how the user should operate the robot.
	public void instructions ()
    {
        System.out.println("This is a robot that will move as per your commands");
        System.out.println("These commands will tell the  robot to move forward or backward and to turn right or left");
        System.out.println("The commands will be in the format <command><number>");
        System.out.println("For example 'L1' would mean 'Turn left by 90 degrees once', 'B2' would mean 'Move backwards 2 units of distance'");
        System.out.println("Please make sure you input individual characters. \n The number values cannot be greater than 9. \n If so, it will give the wrong answer. Using the first digit of thw two digit number.");
		System.out.println("###Available commands");
        System.out.println("`F` - move forward 1 unit \n`B` - move backward 1 unit \n`R` - turn right 90 degrees \n`L` - turn left 90 degrees");
    }
	
	//All the inputs, validations and functionallities are being done in this method.
	public void inputCommands()
	{
		String command;
		Scanner scan = new Scanner (System.in);
		char cont = 'y';
		//The boolean used to validate the input. If it they are of the format <number><digit> or not and contain only F,B,L and R commands(not case sensitive).
		boolean matches = false;
		while (cont == 'y' || cont == 'Y' && matches )
		{				
			int x = 0;
			int y = 0;
			int direction = 0;
			System.out.println("Please enter your commands for the robot");
			command = scan.next();
			//Splits the input into comma separated array.
			String [] commands = command.split(",");
			//Loop to iterate over each String element of the array.
			for (String cmnd : commands)
			{					
			try
				{
						//The pattern of input being validated.
						String regex = "([fblrFBLR])([\\d])";
						matches = Pattern.matches(regex,cmnd);
						//Values of each element being split into alphabetical and numerical values.
						char alphabet = cmnd.toLowerCase().charAt(0);
						int numerical = Character.getNumericValue(cmnd.charAt(1));
						//handling which the robot is facing.
						switch (direction)
						{
							case 0 : 
							//Handling the movement in the correct direction according to the robot's perspective(where the robot is facing).
							switch (alphabet)
							{
								case 'f' : y += numerical;
											break;
								case 'b' : y-= numerical;
											break;
								case 'r' : 	direction = setFace (alphabet,numerical,direction);
											break;
								case 'l' :  direction = setFace (alphabet,numerical,direction);
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
											
								case 'r' : 	direction = setFace (alphabet,numerical,direction);
											break;
								case 'l' :  direction = setFace (alphabet,numerical,direction);
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
											
								case 'r' : 	direction = setFace (alphabet,numerical,direction);
											break;
								case 'l' :  direction = setFace (alphabet,numerical,direction);
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
											
								case 'r' : 	direction = setFace (alphabet,numerical,direction);
											break;
								case 'l' :  direction = setFace (alphabet,numerical,direction);
											break;
							}
							break;
						}
				}
					
					//Catches and prints any exception thrown from the try block.
					catch(Exception e)
					{
						System.out.println(""+e);
					}
					
			}
					
					//Computing the final answer. The minimum distance required for the robot to travel. Using absolute values of the coordinates.
					int answer = Math.abs(x) + Math.abs (y);
					
						//Checking the condition for any wrong input made, giving back the appropriate information for the user to retry and setting the answer to 0 as the inputs were wronng.
						if(!matches)
						{
							System.out.println("You entered the wrong commands.");
							System.out.println("Please use only the available commands.");
							System.out.println("Make sure your commands cannot be more than 9 units.");
							System.out.println("Make your each command an individual character as explained in the instructions.");
							System.out.println("The answer will be set to 0");
							answer = 0;
							
						}
					System.out.println("The minimum distance needed to travel by the robot to reach where it started from is: " + answer);
					System.out.println("Do you wish to continue? Please press 'Y' to enter another set of commands and 'N' to terminate.");
					cont = scan.next().charAt(0);
			
			
		}
		
	}
	//handles the robot looking left or right.
	public static int setFace(char alphabet, int numerical, int currentFacing)
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
		//Done so that if left or right facing is changed by the user to a degree of 4 or more. For example, R5 will be same as R1.
		currentFacing = currentFacing % 4;
		return currentFacing;
	}

	//The main method used to run the program.
	public static void main(String [] args)
	{
		RobotPronto rp = new RobotPronto();
		rp.instructions();
		rp.inputCommands();
	
	}
}
