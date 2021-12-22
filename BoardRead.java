//--------------------------------------------------------------------------------------
//A class that reads from the input file and initiates the beginning state of the board
//--------------------------------------------------------------------------------------

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BoardRead 
{
	private static int Rows;
	private static int Columns;
	
	public static int[][] ReadFile(String varFile0)
	{
		File varFile1 = new File(varFile0);
		
		//Starts reading the input file
		try
		{
			Scanner var4 = new Scanner(varFile1);
			Rows = var4.nextInt();
			Columns = var4.nextInt();
			int[][] table = new int[Rows][Columns];
			
			for(int i = 0; i < Rows; ++i) 
			{
				for(int j = 0; j < Columns; ++j)
				{
					if(var4.hasNextInt())
					{
						table[i][j] = var4.nextInt(); //Gets the inputs in a board
					}
					else
					{
						 System.err.println("File format is wrong");
					}
				}
			}
			
			return table;
		}
		catch(FileNotFoundException var6)
		{
			var6.printStackTrace();
			return(int[][])null;
		}
	}
	
	//Gets number of rows and collums
	
	public static int getRows()
	{
		return Rows;
	}
	
	public static int getColumns()
	{
        return Columns;
    }
	
}
