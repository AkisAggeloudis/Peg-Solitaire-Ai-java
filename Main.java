// -------------------------------------------------
//
// This program solves a peg solitaire puzzle using two algorithms
// - Breadth first search
// - Best first search
//
//---------------------------------------------------

//--------------------------------------------------------------
//    A peg solitaire puzzle :
//
//
//  	
//		0 0 1 1 1 0 0
//		0 1 1 1 1 1 0
//		1 1 1 2 1 1 1
//		1 1 1 1 1 1 1
//		1 1 1 1 1 1 1
//		0 1 1 1 1 1 0
//		0 0 1 1 1 0 0
//
//		�������� ���� �� ���� ������ �� ���� ��� ��������������� ���������.
//		��� ��� ������ �� ����� ���� � �� ��������� ���� �������(1).
//		������ ������� ���� ��� ���� ���(2)
//		������� ��� �������� ������ ��� ������ �� ����� � �������: ��� �������� ��� �������� ��� ���� ��� ��
//		����� ���������� ������ ���� ���� ������, �� ��� ��� ��� ��� ����, � �������� ��� ��������� ��� ���� ����
//		������������ ���� ��� ��� � �������� ���� ��������� ���� ���������� ��� ��� ������ ��� ����������.
//		� ���� ����� �� �������� �� ���� �� ������
//
//		�� ��� ������ ��� �������� � 
//		���� ��� ��� ��� �������� ������� ���������� ��� ������.
//       �� ��� ������ ������� ���� ������ ������ �� ���� (�,�)
//		
//
//
//
//
//----------------------------------------------------------------------

import java.util.Scanner;


public class Main 
{

	public static void main(String[] args)
	{	
		System.out.print("-------------------------------------------------------------------------------- \n");
		//We read from the user 
		
		//Which allgorithm will the user use
		System.out.print("You can choose either DFS or BFS. ");
		System.out.print("Which algorithm do you want to use: \n");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
	
		
		System.out.print("-------------------------------------------------------------------------------- \n");
		
		//What input (txt)
		System.out.print("Which input do you want to use: \n");
		String string1 = scanner.next() + ".txt";
		
		System.out.print("-------------------------------------------------------------------------------- \n");
		
		//giving name on solution file
		System.out.println("How do you want to name the solution file: ");
        String solution = scanner.next() + ".txt";
    
        System.out.print("-------------------------------------------------------------------------------- \n");
        
        //Reading input File
        int[][] var4 = BoardRead.ReadFile(string1);
        int Rows = BoardRead.getRows();
        int Cols = BoardRead.getColumns();
        
        //checks what algorithm did the user wants to use
        if(string.equals("depth"))
        {
        	 NodeDFS nodeDepthFirst = new NodeDFS(var4, Rows, Cols, null, 0, 0, 0, 0);
             DFS depthFirstSearch = new DFS(nodeDepthFirst);
             depthFirstSearch.ComputeDFS(solution);
             System.out.print("The problem solved with the DFS method \n");
             System.out.print("--------------------------------------------------------------------------------");
     	}
        else if(string.equals("best")) 
        {
        	 NodeBFS nodeBFS = new NodeBFS(var4, Rows, Cols, (NodeBFS)null, 0, 0, 0, 0);
             BFS bfs = new BFS(nodeBFS);
             bfs.ComputeBFS(solution);
             System.out.print("The problem solved with the BFS method \n");
             System.out.print("--------------------------------------------------------------------------------");
        }
        else
        {
        	System.out.print("No such algorithm Found! /n");
        	System.out.print("--------------------------------------------------------------------------------");
        }
	}

}
