//-----------------------------------------------------
//A class that writes the solution onto a file
//-----------------------------------------------------


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Writer  
{
	public static void WriteSolution(Nodes node, String solution)
	{
		try
		{
			FileOutputStream var1 = new FileOutputStream(solution);
            OutputStreamWriter var2 = new OutputStreamWriter(var1);
            BufferedWriter writer = new BufferedWriter(var2);
            
            for(int var4 = 0; var4 < Nodes.x; ++var4) 
            {
                for(int var5 = 0; var5 < Nodes.y; ++var5) 
                {
                    writer.write(node.getBoard()[var4][var5] + " ");
                }

                writer.write("\n");
            }
            
            //Get all the nodes from the last to the first
            Stack<Nodes> Ancestors = new Stack<Nodes>();
            while (node.getParent() != null)
            {
                Ancestors.push(node);
                node = node.getParent();
            }
            
            writer.write(Ancestors.size() + "\n");
            
            //pop each node
            while(!Ancestors.isEmpty())
            {
            	node = Ancestors.pop();
                int[][] LastMove = node.getLastMove();
                writer.write(++LastMove[0][0] + " " + ++LastMove[0][1] + " " + ++LastMove[0][2] + " " + ++LastMove[0][3] + "\n");
            }
            
            writer.close();
            var2.close();
            var1.close();
            System.out.println("Solution Wrote!");
		}
		catch (FileNotFoundException var6) 
		{
			var6.printStackTrace();
		} 
		catch (IOException var7) 
		{
			var7.printStackTrace();
		}

	}
	

}
