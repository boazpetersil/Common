package Q2Q.CommonTypes;

 

import java.io.Serializable;
import java.util.HashMap;




public class Cand implements Serializable{
	public String Title;
	 
	public	String Qid;
	public	float Score;
	public	int Clicks;
	public Boolean IsCorrect=false;
	public int CandId;
	public Example parentExample;
	
	public HashMap<String, Object> data;
	
	public Cand(Example parent)
	{
		parentExample=parent;
		data = new HashMap<String, Object>();
	}  
}
