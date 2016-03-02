package Q2Q.CommonTypes;

public class DepEdge implements java.io.Serializable{
	public int governorInd;
	public int dependentInd;
	public String edgeType;
	
	public DepEdge(int GovernorInd,int DependentInd,String EdgeType)
	{
		governorInd=GovernorInd;
		dependentInd=DependentInd;
		edgeType=EdgeType;
	}
}
