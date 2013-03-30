package algorithms;

import java.util.*;

public class DStar {
	
	// i dont think we care about closed state but for now
	// enums
	// add start, goal and current?
	public enum NodeStatus {
		NEW, OPEN, CLOSE, RAISE, LOWER
	}
	/*
	int NEW   = 0;
	int OPEN  = 0;
	int CLOSE = 0; 
	int RAISE = 0;
	int LOWER = 0;
	*/

	//public List<NodeStatus> openList = new ArrayList<NodeStatus>();
	public NodeStatus openList[][];
	public int startRow;
	public int startCol;
	public int goalRow;
	public int goalCol;
	public int currentRow;
	public int currentCol;
	
	public void init(int sRow, int sCol, int gRow, int gCol)
	{
		startRow = sRow;
		startCol = sCol;
		goalRow = gRow;
		goalCol = gCol;
		
		currentRow = 0;
		currentCol = 0;
	}
}
