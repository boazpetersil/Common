package Q2Q.Raw2Serialized;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.nustaq.serialization.FSTConfiguration;

import Q2Q.CommonTypes.Example;

public class SerExampleIterator extends IExampleIterator {

	static FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();
	FileInputStream fileIn; 
	ObjectInputStream in; 
	//Example nextExample;
	//Example currExample;
	 
	
	public SerExampleIterator(File SerFile) throws IOException
	{
		super(SerFile.getAbsolutePath());
		Restart();
		//fileIn=new FileInputStream(SerFile);
		//in=new ObjectInputStream(fileIn);
		//nextExample=GetNext();	
			
	}
	
	public SerExampleIterator(File SerFile,int MaxNumOfExamples) throws IOException
	{
		super(SerFile.getAbsolutePath(),MaxNumOfExamples);
		Restart();
		//fileIn=new FileInputStream(SerFile);
		//in=new ObjectInputStream(fileIn);
		//nextExample=GetNext();	
			
	}
	
	
	protected Example GetNext()
	{
		 
		
		 
		byte[] barray=null;
		
		try
		{
			 barray = (byte[])in.readObject();
			 return (Example)conf.asObject(barray);
			 
		}
		catch(EOFException eofex)
		{
			return null;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	

	

	@Override
	public void Restart() throws IOException {
		// TODO Auto-generated method stub
		if(fileIn!=null && in!=null)
		{
			fileIn.close();
			in.close();
		}
		fileIn=new FileInputStream(new File(this.FileName));
		in=new ObjectInputStream(fileIn);
		 
		super.Restart();
		 
	}

}
