package Q2Q.Raw2Serialized;

import java.io.File;
import java.io.IOException;

import Q2Q.CommonTypes.Cand;
import Q2Q.CommonTypes.Example;

public class Test {
	public static void main(String args[]) throws IOException
	{
		RawExampleIterator exIt = new RawExampleIterator(new File("part0.gz"));
		while(exIt.hasNext())
		{
			Example example = exIt.GetNext();
			System.out.println(example.query);
			for(Cand cand : example.Cands)
			{
				System.out.println(cand.CandId+"("+cand.IsCorrect+") : "+cand.Title);
			}
		}
	}
}
