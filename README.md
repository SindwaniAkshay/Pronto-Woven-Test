Task.

The task is to write a CLI(Command Line Interface) application that will take a set of commands of input and display the result accordingly. The set of commands will be the movement of the robot. The result is the minimum distance required to travel the robot to get back to its starting position.

What are the commands?

F – Move forward. 

B – Move backward.

L – Turn left by 90 degrees.

R – Turn right by 90 degrees.

For example ‘L1’ would mean ‘Turn right by 90 degrees once.’ Or ‘B2’ would mean ‘Move backward by 2 units.’ So, for example an input of commands can be ‘F1, R1, B2, L1, and B3’. In this example the result would be 4.  ‘4’ units is the minimum distance required for the robot to travel to get back to its starting position.

How was it executed?

The movements were mapped to 2-Dimensional Cartesian plane which has 4 quadrants. The initial state of the robot is assumed to be the origin (0, 0). Then, the up and down movement was traced to the y-axis and the left and right movements were traces to the x-axis. The movements were traced according to the perspective of the robot (where it is looking). For example, if the command was ‘R1’, it means that the robot is facing the positive side of the x-axis.

Technology used.

Java was used to build the application. 
Basic validation of the commands was done using a Regex expression and the inputs were mapped to a comma separated array using the split() method. 
Each command was further split into numeric and alphabetical values using the charAt() method. 
To access the source code, you may use text editor like Notepad (Notepad++ preferable).

How to run the application?

1)	Open Notepad or Install and run Notepad++.
2)	Copy the code onto a text editor of your preference and save the file locally as a .java file in your preferred location.
3)	Install Java SE Development Kit (JDK).
4)	Set the environment path by either using the command prompt or otherwise.
5)	Run the command java –version to verify the path.
6)	Next, cd (change directory) in the command prompt to the location where you saved the .java file.
7)	Run the command javac <filename>.java. This command is used to compile or convert the java code to a byte code.
8)	Run the command java <filename>. This is used to run the java application.

NOTE: The steps mentioned above are for Windows OS only.
