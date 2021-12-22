

public class Nodes 
{
	public static int x;
	public static int y;
	protected int[][] Board; //The board state 
	protected Nodes Parent;
	protected boolean Visited =  false;
	protected int[][] LastMove; //Saves the move made to get from the parent node
    protected int counter; //Counts the number of Pegs on the board
    
    public Nodes(int[][] Board, int x, int y, Nodes Parent, int OldI, int OldJ, int NewI, int NewJ)
    {
    	  this.Board = Board;
          this.Parent = Parent;
          this.LastMove = new int[1][4];
          
          //sets the move made to get to this node from the parent node
          this.LastMove[0][0] = OldI;
          this.LastMove[0][1] = OldJ;
          this.LastMove[0][2] = NewI;
          this.LastMove[0][3] = NewJ;
          this.counter = 0;
          this.x = x;
          this.y = y;
    }

    public int[][] getLastMove()
    {
        return LastMove;
    }

    public int getCounter()
    {
        return counter;
    }


    public Nodes getParent() 
    {
        return Parent;
    }

    public boolean isVisited() 
    {
        return Visited;
    }

    public void setVisited(boolean visited) 
    {
        Visited = visited;
    }

    public int[][] getBoard() 
    {
        return Board;
    }

}
