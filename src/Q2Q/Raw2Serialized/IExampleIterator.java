package Q2Q.Raw2Serialized;

import java.io.IOException;
import java.util.Iterator;

import Q2Q.CommonTypes.Cand;
import Q2Q.CommonTypes.Example;

public abstract class IExampleIterator implements Iterator<Example> {
	public String FileName;
	public int MaxNumOfExamples;
	public int c=0;
	
	protected Example nextExample;
	protected Example currExample;
	
	
	public IExampleIterator(String FileName)
	{
		this.FileName=FileName;
	};
	
	public IExampleIterator(String FileName,int MaxNumOfExamples)
	{
		this.FileName=FileName;
		this.MaxNumOfExamples=MaxNumOfExamples;
	};
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		 
		if(nextExample==null){return false;}
		if(MaxNumOfExamples>0 && c>=MaxNumOfExamples)
		{
			return false;
		}
		return true;
	}

	@Override
	public Example next() {
		// TODO Auto-generated method stub
		currExample=nextExample;
		nextExample=GetNext();
		c++;
		//if(c%100==0)
		//{
		//	System.out.println(c);;
		//}
		
		double MaxScore=0;
		for(Cand cand : currExample.Cands)
		{
			if(cand.Score> MaxScore)
			{
				MaxScore=cand.Score;
			}
		}
		currExample.data.put("MaxBaseScore",MaxScore);
	
		
		return currExample;
	}
	
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
	
	protected abstract Example GetNext();
	public  void Restart() throws  IOException
	{
		c=0;
		nextExample=GetNext();	
	}
	 
}
