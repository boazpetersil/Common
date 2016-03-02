package Q2Q.CommonTypes;

import java.util.ArrayList;

public class MatchingData implements java.io.Serializable{
	
	public ArrayList<ArrayList<Match>>  SourceMatches;
	public ArrayList<ArrayList<Match>>  TargetMatches;
	
	public double[][] MatchingMatrix;
	//public String[] source_tokens_for_match;
	//public String[] target_tokens_for_match;
	
	public MatchingData()
	{
		
	}
	
	public MatchingData(int sourceTermCount,int targetTermCount)
	{
		SourceMatches=new ArrayList<ArrayList<Match>>();
		for(int i=0;i<sourceTermCount;i++)
		{SourceMatches.add(new ArrayList<Match>());}
		
		TargetMatches=new ArrayList<ArrayList<Match>>();
		for(int i=0;i<targetTermCount;i++)
		{TargetMatches.add(new ArrayList<Match>());}
	}
	
	 
	
	
}
