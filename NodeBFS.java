 import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NodeBFS extends Nodes
{

 
	private int Heuristic;
    private int FScore;
    private ArrayList<NodeBFS> children;
    //    Enable if you use manhattan Heuristic
    private static double goalx;
    private static double goaly;
    private Queue<Integer> iQueue; //A Queue with all the I coordinates in the matrix where there is a peg
    private Queue<Integer> jQueue; //A Queue with all the J coordinates in the matrix where there is a peg

	
	public NodeBFS(int[][] Board, int x, int y, Nodes Parent, int OldI, int OldJ, int NewI, int NewJ)
	{
			super(Board,x,y,Parent,OldI,OldJ,NewI,NewJ);
	        goalx = Math.ceil((double)(x / 2));
	        goaly = Math.ceil((double)(y / 2));
	        this.children = new ArrayList<NodeBFS>();
	        this.iQueue = new LinkedList();
	        this.jQueue = new LinkedList();
	        this.Heuristic = 0;
	        this.FScore = 0;	
	}
	
	 //Creates new Nodes as children wherever it is possible, checks every direction at every block
	public void Expand() 
	{	
        while(!this.iQueue.isEmpty() && !this.jQueue.isEmpty()) 
        {
            int i = (Integer)this.iQueue.remove();
            int j = (Integer)this.jQueue.remove();
            int[][] Clone;
            NodeBFS node;
            
            if (i > 1 && this.Board[i - 1][j] == 1 && this.Board[i - 2][j] == 2) 
            {
                Clone = (int[][])Arrays.stream(this.Board).map((var0) -> {
                    return (int[])var0.clone();
                }).toArray((var0) -> {
                    return new int[var0][];
                });
                Clone[i][j] = 2;
                Clone[i - 1][j] = 2;
                Clone[i - 2][j] = 1;
                node = new NodeBFS(Clone, x, y, this, i, j, i - 2, j);
                this.children.add(node);
            }
        
	        if (j > 1 && this.Board[i][j - 1] == 1 && this.Board[i][j - 2] == 2) 
	        {
	            Clone = (int[][])Arrays.stream(this.Board).map((var0) -> 
	            {
	                return (int[])var0.clone();
	            }).toArray((var0) -> 
	            {
	                return new int[var0][];
	            });
	            Clone[i][j] = 2;
	            Clone[i][j - 1] = 2;
	            Clone[i][j - 2] = 1;
	            node = new NodeBFS(Clone, x, y, this, i, j, i, j - 2);
	            this.children.add(node);
	        }
	
	        if (j < y - 2 && this.Board[i][j + 1] == 1 && this.Board[i][j + 2] == 2) {
	            Clone = (int[][])Arrays.stream(this.Board).map((var0) -> {
	                return (int[])var0.clone();
	            }).toArray((var0) ->{
	                return new int[var0][];
	            });
	            Clone[i][j] = 2;
	            Clone[i][j + 1] = 2;
	            Clone[i][j + 2] = 1;
	            node = new NodeBFS(Clone, x, y, this, i, j, i, j + 2);
	            this.children.add(node);
	        }
	
	        if (i < x - 2 && this.Board[i + 1][j] == 1 && this.Board[i + 2][j] == 2) {
	            Clone = (int[][])Arrays.stream(this.Board).map((var0) -> {
	                return (int[])var0.clone();
	            }).toArray((var0) -> {
	                return new int[var0][];
	            });
	            Clone[i][j] = 2;
	            Clone[i + 1][j] = 2;
	            Clone[i + 2][j] = 1;
	            node = new NodeBFS(Clone, x, y, this, i, j, i + 2, j);
	            this.children.add(node);
	        }
	    }



	}
	
    //  Calculates a Heuristic based on the number of Pegs and the number if Isolated pegs on the board
    public void CalculateHeuristic() 
    {
        int ManhattanSum = 0; 
        for(int i = 0; i < x; ++i) 
        {  	
            for(int j = 0; j < y; ++j) 
            {
                if (this.Board[i][j] == 1)
                {
                    ++this.counter; //This counter is important becouse we need it to check if this is a solution
                    this.iQueue.add(i);
                    this.jQueue.add(j);
                    double Xdist = (double)i - goalx;
                    double Ydist = (double)j - goaly;
                    ManhattanSum = (int)((double)ManhattanSum + Math.abs(Xdist) + Math.abs(Ydist));
                }
            }
        }
        
        int IsolatedPegs = this.CalculateIsolatedPegs();
        
        //this heuristic adds the manhattan distance in the function it solves the 7x7 problem in 22 seconds
        if (IsolatedPegs != 0) 
        {
            this.Heuristic = this.counter * IsolatedPegs * ManhattanSum;
        } 
        else 
        {
            this.Heuristic = this.counter * ManhattanSum;
        }
    }
    
    //Calculates the number of isolated pegs (Is able to notice pegs that are at the corners of the board, because
    //the number of possible directions changes in certain positions for example the corners of the board)
    public int CalculateIsolatedPegs() {
        int counter = 0;
        int isolatedDirections = 0;
        int blockedDirections = 0;

        for(int i = 0; i < x; ++i) 
        {
            for(int j = 0; j < y; ++j) 
            {
                if (this.Board[i][j] == 1) 
                {
                    if (i >= 1) 
                    {
                        if (this.Board[i - 1][j] == 2) 
                        {
                            ++isolatedDirections;
                        }
                    } 
                    else 
                    {
                        ++blockedDirections;
                    }

                    if (j >= 1) 
                    {
                        if (this.Board[i][j - 1] == 2) 
                        {
                            ++isolatedDirections;
                        }
                    } 
                    else 
                    {
                        ++blockedDirections;
                    }

                    if (j <= y - 2)
                    {
                        if (this.Board[i][j + 1] == 2)
                        {
                            ++isolatedDirections;
                        }
                    }
                    else 
                    {
                        ++blockedDirections;
                    }

                    if (i <= x - 2) 
                    {
                        if (this.Board[i + 1][j] == 2) 
                        {
                            ++isolatedDirections;
                        }
                    } 
                    else
                    {
                        ++blockedDirections;
                    }
                }

                if (isolatedDirections == 4 - blockedDirections) 
                {
                    ++counter;
                }

                isolatedDirections = 0;
                blockedDirections = 0;
            }
        }

        return counter;
    }
    

    //best guess
    public void CalculateF() 
    {
        this.FScore = this.Heuristic;
    }

    public boolean isSolution() 
    {	 
    	if (this.counter == 1)
            return true;
    	else
            return false;
    }
    
    public ArrayList<NodeBFS> getChildren()
    {
        return children;
    }

    public int getFScore() 
    {
        return this.FScore;
    }


    public void setVisited(boolean var1) 
    {
        this.Visited = var1;
    }


    public int getHeuristic() 
    {
        return this.Heuristic;
    }
   
	
}
