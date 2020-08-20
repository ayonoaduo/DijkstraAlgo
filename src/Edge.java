package dijkstraAlgo;

public class Edge
{
	private int nodeIndex;
	private int length;
	private int toNodeIndex;
	
	public Edge(int nodeIndex, int toNodeIndex, int length)
	{
		this.nodeIndex = nodeIndex;
		this.toNodeIndex = toNodeIndex;
		this.length = length;
	}
	
	public int getNodeIn()
	{
		return nodeIndex;
	}
	
	public void setNodeIn(int nodeIndex)
	{
		this.nodeIndex = nodeIndex;
	}
	
	public int getToNodeIn()
	{
		return toNodeIndex;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public int getNeighbourIn(int nodeIndex)
	{
		if(this.nodeIndex == nodeIndex)
		{
			return this.toNodeIndex;
		}
		else
		{
			return this.nodeIndex;
		}
	}
}
