package Q2Q.CommonTypes;

import java.util.HashMap;

public class PreProcessedTerm implements java.io.Serializable{
	public Boolean IsStopWord;
	public String POS;
	public String Term;
	public String Stem;
	public String Lemma;
	public int NodeIndInDepTree;
	public HashMap<String, Object> data;
}
