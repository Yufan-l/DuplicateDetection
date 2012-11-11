package twitter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class EndTag {

	public static void addEndTag(String target)throws Exception
	{
	
		File file = new File(target);
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		final BufferedWriter bw = new BufferedWriter(fw);
		
	
		bw.newLine();
		String EndTag="</graph>\n</graphml>";
		bw.write(EndTag);
		

		bw.close();
		
		
		
	}
	public static void main(String args[])throws Exception
	{
		addEndTag(args[0]);
	}
}
