//  PROGRAMMER:  Jean Paul Lobon  5729060
//
//  CLASS:       COP 3337   TR 11:00am
//
//  INSTRUCTOR:  Norman Pestaina  ECS 364
//
//  ASSIGNMENT:  #5 Maze/Recursion.   DUE Thursday 11/28
//
// CERTIFICATION: I certify that this work is my own and that
//                 none of it is the work of any other person.
//

//--------------------------------------------- Skeleton Code Given ------------------------------------------------------

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class MazeClient
{
	public static void main(String[] args) throws IOException
	{
		boolean quitting = false;
                
		do
		{
			String fileName = JOptionPane.showInputDialog(null,
			                  "Enter the name of a Maze data file or CANCEL to quit");
			
			if (fileName == null)
				quitting = true;
			else
			{
				Maze maze = new Maze( new Scanner( new FileReader(fileName) ) );
				System.out.println();
				System.out.println(maze);
				System.out.println("\n" + (maze.solve() ? maze + " SUCCESS" :
                                                      maze + " FAILURE"));
			}
		} while (!quitting);
	}
}
