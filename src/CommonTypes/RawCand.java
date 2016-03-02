package CommonTypes;



public class RawCand implements java.io.Serializable
	{
		public String Title;
		public transient String Body;//transient is for saving space and time
		public transient String Answer;//transient is for saving space and time
		public	String Qid;
		public	float Score;
		public	int Clicks;
		public Boolean IsCorrect=false;
		public int CandId;
		public RawCand(String title,String body,String answer,String qid,float score,int clicks,int candid)
		{
			Title=title;
			Body=body;
			Answer=answer;
			Qid=qid;
			Score=score;
			Clicks=clicks;
			CandId=candid;
		}
	 
		public RawCand(RawCand rc)
		{
			Title=rc.Title;
			Body=rc.Body;
			Answer=rc.Answer;
			Qid=rc.Qid;
			Score=rc.Score;
			Clicks=rc.Clicks;
			IsCorrect=rc.IsCorrect;
			CandId=rc.CandId;
		}
	}

