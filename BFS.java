import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;


//A class containing the implementation of BFS algorithm  
public class BFS
{
	 private PriorityQueue<NodeBFS> Open; //A Qeueue that represents the open list which automatically sorts the Nodes
	 private static HeuristicComparator comparator; //The comparison made between Nodes to sort them with the best Heuristic score first

	 public BFS(NodeBFS StartNode)
	 {
		 comparator = new HeuristicComparator();
		 this.Open = new PriorityQueue(comparator);
		 StartNode.CalculateHeuristic();
		 this.Open.add(StartNode);
	 }
	 
	// Runs the BFS algorithm and counts the time it take to run
	public void ComputeBFS(String solutionName)
	{
		double startTime = (double)System.nanoTime();
		
		while(!this.Open.isEmpty())
		{
			 NodeBFS Current = Open.poll();
	         Current.Expand();
	         
	         if (Current.isSolution()) 
	         {
	                Writer.WriteSolution(Current, solutionName);             
	                break;
	         }
	         
	         ArrayList<NodeBFS> children = Current.getChildren();

	         for(NodeBFS Successor: children) 
	         {	       
		           if (!this.Open.contains(Successor)) 
		           {
		                    this.Open.add(Successor);
		                    Successor.CalculateHeuristic();
		           }
	         }

		}
	 
		System.out.println(("Time spend:") +(System.nanoTime() - startTime) / 1000000000);
		
	}
	
	 
}
