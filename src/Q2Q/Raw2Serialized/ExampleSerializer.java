package Q2Q.Raw2Serialized;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;

import org.nustaq.serialization.FSTConfiguration;

import Q2Q.CommonTypes.Example;

public class ExampleSerializer {
	static FSTConfiguration conf = FSTConfiguration.createDefaultConfiguration();
	FileOutputStream fileOut; 
	ObjectOutputStream out;
	String serFile;
	int i;
	
	private void Init(String SerFile) throws IOException
	{
		serFile=SerFile;
		fileOut = new FileOutputStream(SerFile);
		out = new ObjectOutputStream(fileOut);
		i=0;
	}
	
	
	public ExampleSerializer(String SerFile) throws IOException
	{
		Init(SerFile);
	}
	
	
	public ExampleSerializer(String SerFile,boolean New) throws IOException
	{
		if(Files.exists(new File(SerFile).toPath()) && New)
		{
			Files.delete(new File(SerFile).toPath());
		}
		Init(SerFile);
	}
	
	
	public void AppendExample(Example example) throws IOException
	{
		byte barray[] = conf.asByteArray(example);
		out.writeObject(barray);
	
		
		if(i % 100==0)
		{
		//	System.out.println("processed " + i);
			out.reset();
			fileOut.flush();
		}
		
		i++;
	}
	
	public void Close() throws IOException
	{
		out.close();
		fileOut.close();
	}
}
