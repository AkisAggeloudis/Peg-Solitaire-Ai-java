import java.util.Comparator;

//A Class made to compare the Heuristic values of 2 nodes and determine which one has the lowest value
//in order to be used in the PriorityQueue in the BFS Class
public class HeuristicComparator implements Comparator<NodeBFS>
{
	    public HeuristicComparator() 
	    {
	    	 
	    }

	    public int compare(NodeBFS var1, NodeBFS var2) 
	    {
	        if (var1.getHeuristic() > var2.getHeuristic())
	        {
	            return 1;
	        }
	        else 
	        {
	            return var1.getHeuristic() < var2.getHeuristic() ? -1 : 0;
	        }
	    }
}
	

