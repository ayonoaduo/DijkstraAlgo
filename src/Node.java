package dijkstraAlgo;

import java.util.ArrayList;
public class Node 
{
	private int distFromSource = Integer.MAX_VALUE;
	
	private boolean visited;
	
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public int getDis() {
		return distFromSource;
	}
	
	public void setDist(int distFromSource)
	{
		this.distFromSource = distFromSource;
	}
	
	public boolean isVisited()
	{
		return visited;
	}
	
	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}
	
	public ArrayList<Edge> getEdges()
	{
		return edges;
	}
	
	public void setEdges(ArrayList<Edge> edges)
	{
		this.edges = edges;
	}
}
