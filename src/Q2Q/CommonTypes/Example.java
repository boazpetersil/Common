package Q2Q.CommonTypes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

 
public class Example implements Serializable {
	public ArrayList<Cand> Cands;
	public int RdrId;
	public String RawDataFile;
	public String query;
	 
	public String[] Qids;
	public int[] Clicks;
	public ArrayList<Integer> CorrectInds;
	
	public HashMap<String, Object> data;
	 
	public Example()
	{
		Cands = new ArrayList<Cand>();
		data=new HashMap<String, Object>();
	}
	
	/*public Example(Example example)
	{
		RdrId=example.RdrId;
		RawDataFile=example.RawDataFile;
		query=example.query;
		CorrectInds=(ArrayList<Integer>) example.CorrectInds.clone();
		data=new HashMap<String, Object>();
		data = (HashMap<String, Object>) example.data.clone();
		
		Cands = new ArrayList<Cand>();
		for(Cand other : example.Cands)
		{
			Cand cand = new Cand(this);
			cand.CandId=other.CandId;
			cand.data=(HashMap<String, Object>) other.data.clone();
			cand.IsCorrect=other.IsCorrect;
			cand.Score=other.Score;
			cand.Title=other.Title;
			
		}
		
	}*/
}

