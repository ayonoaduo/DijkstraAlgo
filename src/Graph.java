package dijkstraAlgo;

import java.util.ArrayList;
public class Graph 
{
	private Node[] nodes;
	private int numOfNodes; 
	private Edge[] edges;
	private int numOfEdges;
	
	public Graph(Edge[] edges)
	{
		this.edges = edges;
		this.numOfNodes = calcNoOfNodes(edges);
		
		for(int i=0; i<this.numOfNodes ; i++)
		{
			nodes[i]  = new Node();
		}
		
		this.numOfEdges  = edges.length;
		
		for(int i=0; i<this.numOfEdges; i++)
		{
			this.nodes[edges[i].getNodeIn()].getEdges().add(edges[i]);
			this.nodes[edges[i].getToNodeIn()].getEdges().add(edges[i]);
		}
	}
	
	private int calcNoOfNodes(Edge[] edges)
	{
		int noOfNodes=0;
		
		for(Edge e: edges)
		{
			if(e.getToNodeIn()>noOfNodes)
				noOfNodes= e.getToNodeIn();
			if(e.getNodeIn() > noOfNodes)
				noOfNodes= e.getNodeIn();
		}
		
		noOfNodes++;
		
		
		return noOfNodes; 
	}
	
	public void shortestDistance()
	{
		this.nodes[0].setDist(0);
		int nextnode=0;
		
		for(int i=0; i<nodes.length; i++)
		{
			ArrayList<Edge> currentNodeEdges = this.nodes[nextnode].getEdges();
			
			for(int joinedEdge=0; joinedEdge< currentNodeEdges.size(); joinedEdge++)
			{
				int neighbourindex= currentNodeEdges.get(joinedEdge).getNeighbourIn(nextnode);
				
				if(!this.nodes[neighbourindex].isVisited())
				{
					int tentative = this.nodes[nextnode].getDis() + currentNodeEdges.get(joinedEdge).getLength();
					
					if(tentative < nodes[neighbourindex].getDis()) {
						nodes[neighbourindex].setDist(tentative);
					}
				}
			}
			
			nodes[nextnode].setVisited(true);
			nextnode = getShortestDistance();
		}
	}
	
	private int getShortestDistance()
	{
		int storedNodedIndex=0;
		int storedDist = Integer.MAX_VALUE;
		
		for(int i=0; i<this.nodes.length; i++)
		{
			int currDist = this.nodes[i].getDis();
			
			if(!this.nodes[i].isVisited() && currDist < storedDist)
			{
				storedDist = currDist;
				storedNodedIndex = i;
			}
		}
		
		return storedNodedIndex;
	}
	
	public void print()
	{
		String output = "Num of Nodes: " + this.numOfNodes;
		output += "\n Num of Edges: " + this.numOfEdges;
		
		for(int i=0; i<this.nodes.length; i++)
		{
			output+= ("\n The shortest dist " + i + "is " + nodes[i].getDis());
			
		}
		
		System.out.println(output);
	}
	
	public Node[] getNodes() {
		return nodes;
	}
	public int getNumOfNodes() {
		return numOfNodes;
	}
	public Edge[] getEdges() {
		return edges;
	}
	public int getNumOfEdges() {
		return numOfEdges;
	}
	
	
}
