//This class Calculates children nodes and add them to the arraylist
//and ckecks if it is a solution

import java.util.ArrayList;
import java.util.Arrays;

public class NodeDFS extends Nodes
{	 
	private ArrayList<NodeDFS> children;
		
	 public NodeDFS(int[][] Board, int x, int y, Nodes Parent, int OldI, int OldJ, int NewI, int NewJ) 
	 {
		super(Board, x, y, Parent, OldI, OldJ, NewI, NewJ);
		this.children = new ArrayList<NodeDFS>();
	 }
	 
	 public void Expand() //Calculates children nodes and add them to the arraylist
	 {
		 for (int i = 0; i < x; i++) 
		 {
	            for (int j = 0; j < y; j++)
	            {
	            	if(Board[i][j] == 1)
	            	{
	            		counter++;  //counts pegs
	            		
	            		//checks the top
	                    if (i > 1) 
	                    {
	                        if (Board[i - 1][j] == 1 && Board[i - 2][j] == 2) 
	                        {
	                            //Create a copy of the Board and make a new node with it
	                            int[][] BoardClone1 = new int[x][y];
	                            BoardClone1 = Arrays.stream(Board).map(x -> x.clone()).toArray(int[][]::new);
	                            BoardClone1[i][j] = 2;
	                            BoardClone1[i - 1][j] = 2;
	                            BoardClone1[i - 2][j] = 1;
	                            children.add(new NodeDFS(BoardClone1, x, y, this, i, j, i - 2, j));
	                        }
	                    }
	                    
	                    //checks the Left
	                    if (j > 1) 
	                    {
	                        if (Board[i][j - 1] == 1 && Board[i][j - 2] == 2) 
	                        {
	                            //Create a copy of the Board and make a new node with it
	                            int[][] BoardClone2 = new int[x][y];
	                            BoardClone2 = Arrays.stream(Board).map(x -> x.clone()).toArray(int[][]::new);
	                            BoardClone2[i][j] = 2;
	                            BoardClone2[i][j - 1] = 2;
	                            BoardClone2[i][j - 2] = 1;
	                            children.add(new NodeDFS(BoardClone2, x, y, this, i, j, i, j-2));
	                        }
	                    }
	                    
	                    //checks the Right
	                    if (j < y - 2) 
	                    {
	                        if (Board[i][j + 1] == 1 && Board[i][j + 2] == 2) 
	                        {
	                            //Create a copy of the Board and make a new node with it
	                            int[][] BoardClone3 = new int[x][y];
	                            BoardClone3 = Arrays.stream(Board).map(x -> x.clone()).toArray(int[][]::new);
	                            BoardClone3[i][j] = 2;
	                            BoardClone3[i][j + 1] = 2;
	                            BoardClone3[i][j + 2] = 1;
	                            children.add(new NodeDFS(BoardClone3, x, y, this, i, j, i, j+2));
	                        }
	                    }
	                    //Checks the Bottom
	                    if (i < x - 2) 
	                    {
	                        if (Board[i + 1][j] == 1 && Board[i + 2][j] == 2) 
	                        {
	                            //Create a copy of the Board and make a new node with it
	                            int[][] BoardClone4 = new int[x][y];
	                            BoardClone4 = Arrays.stream(Board).map(x -> x.clone()).toArray(int[][]::new);
	                            BoardClone4[i][j] = 2;
	                            BoardClone4[i + 1][j] = 2;
	                            BoardClone4[i + 2][j] = 1;
	                            children.add(new NodeDFS(BoardClone4, x, y, this, i, j, i+2, j));
	                        }
	                    }
	            	}
	            }
	      }
	 }
	 
	 //checks if solution
	 public boolean isSolution()
	 {
	        if (this.counter == 1)
	            return true;
	        else
	            return false;
	  }

	  public ArrayList<NodeDFS> getChildren() 
	  {
	        return children;
	  }
}
