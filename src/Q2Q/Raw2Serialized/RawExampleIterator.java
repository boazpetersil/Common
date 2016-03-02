package Q2Q.Raw2Serialized;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

import Q2Q.CommonTypes.Cand;
import Q2Q.CommonTypes.Example;

public class RawExampleIterator extends IExampleIterator {

	
	FileInputStream fileIn; 
	 
	int rdr_ind=0;
	Iterator<String> linesIt=null;
	String line=null;
	int lcounter=0;
	
	
	public RawExampleIterator(File RawDataFile) throws IOException
	{
		super(RawDataFile.getAbsolutePath());
		Restart();
		 	
			
	}
	
	public RawExampleIterator(File RawDataFile,int MaxNumOfExamples) throws IOException
	{
		super(RawDataFile.getAbsolutePath(),MaxNumOfExamples);
		Restart();
		 
			
	}
	
	
	protected Example GetNext()
	{
		return GetNextRecord();
	}
	
	
	public  Example GetNextRecord()
	{
		Example example = new Example();
		example.CorrectInds=new ArrayList<Integer>();
		if(line.equals(""))//first line is blank - will happen on first record. next records will start with query line
		{
			line = linesIt.next();lcounter++;
		}
		
		try
		{
			
			String[] fields = line.split("\t");
			
			example.query = fields[0].trim();
			String click_data=fields[1];
			String[] temp = click_data.split(",");
			example.Qids=new String[temp.length];
			example.Clicks=new int[temp.length];
			for(int i=0;i<temp.length;i++)
			{
				String qid_and_clicks=temp[i];
				int eq_sign_ind =  qid_and_clicks.indexOf('=');	
				
				example.Qids[i]=qid_and_clicks.substring(0, eq_sign_ind);
				example.Clicks[i]=Integer.parseInt(qid_and_clicks.substring(eq_sign_ind+1,qid_and_clicks.length()));
			}
			
			while(true)
			{
				line = linesIt.next();lcounter++;
				
				if(line.equals(""))//no more cands
				{
					break;
				}
					
				fields = line.split("\t");
				String title=fields[3];
				String body=fields[4];
				String answer=fields[5];
				String qid=fields[2];
				float score=Float.parseFloat( fields[0]);
				int clicks=Integer.parseInt(fields[1]);
				int candid=example.Cands.size();
				Cand cand = new Cand(example);
				cand.Title=title;
				cand.Qid=qid;
				cand.Score=score;
				cand.Clicks=clicks;
				cand.CandId=candid;
				
				
				
				
				for(int i=0;i<example.Qids.length;i++)
				{
					if(cand.Qid.equals(example.Qids[i]))
					{
						example.CorrectInds.add(candid);
						cand.IsCorrect=true;
					}
				}
				
				example.Cands.add(cand);
				
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("bad format encounterd at line "+ lcounter +" during reading " + FileName + ", " +rdr_ind + " were read");
			return null;
		}
		
		if(example.CorrectInds.size()==0 )
		{
			 return  GetNextRecord();
		}
		rdr_ind++;
		return example;
	}
	

	@Override
	public void Restart() throws IOException {
		// TODO Auto-generated method stub
		if(fileIn!=null)
		{
			fileIn.close();
			
		}
		fileIn=new FileInputStream(new File(this.FileName));
		linesIt= FileUtils.lineIterator(new File(this.FileName));
		line=linesIt.next();
		 
		super.Restart();
		 
	}

}
