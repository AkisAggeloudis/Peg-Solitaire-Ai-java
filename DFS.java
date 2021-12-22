//-------------------------------------------------
//implements the DFS algorithm using a stack 
//-------------------------------------------------

import java.util.ArrayList;
import java.util.Stack;

 
public class DFS 
{
	private Stack<NodeDFS> stack;

    public DFS(NodeDFS StartNode)
    {
        stack = new Stack<NodeDFS>();
        stack.push(StartNode);
        StartNode.setVisited(true);
    }
    
    //the method running the DFS
    public void ComputeDFS(String solution)
    {
    	//timer
        double startTime = System.nanoTime();
        while (!stack.isEmpty())
        {
            //Here we get the Current Node
            NodeDFS current = stack.pop();
            
            //Now we expand it 
            current.Expand();
            
            //cheking if isSolution
            if(current.isSolution())
            {
            	Writer.WriteSolution(current, solution);
            	break;
            }
            
            //Adds the nodes in the stack
            ArrayList<NodeDFS> neighbours= current.getChildren();
            for (int i = 0; i < neighbours.size(); i++) 
            {
                NodeDFS n=neighbours.get(i);
                if(n!=null && !n.isVisited())
                {
                	stack.push(n);
                    n.setVisited(true);
                }
            }
        
        
        }
        System.out.println(("Time spend:") + (System.nanoTime() - startTime) / 1000000000); //prints the time
    }
}
