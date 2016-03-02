package CommonTypes;

import java.util.ArrayList;

 



public class RawDataExample implements java.io.Serializable{
	
	 
	public int RdrId;
	public String query;
	public ArrayList<RawCand> Cands;
	public String[] Qids;
	public int[] Clicks;
	public ArrayList<Integer> CorrectInds;
	
	public RawDataExample()
	{
		CorrectInds=new ArrayList<Integer>();
		Cands=new ArrayList<RawCand>(); 
	}
	
	public RawDataExample(int rdr_id)
	{
		RdrId=rdr_id;
		CorrectInds=new ArrayList<Integer>();
		Cands=new ArrayList<RawCand>(); 
	}
	
	public RawDataExample(RawDataExample copythis,boolean WithCands)
	{
		query=copythis.query;
		Qids=copythis.Qids.clone();
		Clicks=copythis.Clicks.clone();
		RdrId=copythis.RdrId;
		
		CorrectInds=new ArrayList<Integer>();
		Cands=new ArrayList<RawCand>(); 
		
		if(WithCands)
		{
			for(int i=0;i<copythis.Cands.size();i++)
			{
				AddCand(copythis.Cands.get(i));
			}
		}
	}
	
	public void AddCand(RawCand rc)
	{
		if(rc.IsCorrect)
		{
			CorrectInds.add(Cands.size());
		}
		Cands.add(new RawCand(rc));
		
	}
}
