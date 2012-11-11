package dblp;
import java.util.*;
import java.io.*;

public class Postprocessing {
	public static void main(String args[])throws Exception
	{
		Scanner SC=new Scanner(new FileReader("C:/dblpfile.txt"));
		
		File file=new File("C:/dblpRefined.txt");
		if(!file.exists())
		{
			file.createNewFile();
		}
		FileWriter fw=new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw=new BufferedWriter(fw);
		
		int count=0;
		String tmp="";
		tmp=SC.nextLine();
		
		while(SC.hasNext())
		{
			tmp=SC.nextLine();
			String content[]=tmp.split("\t");
			if (content.length<2)
			{
				continue;
			}
			
			if (content[1].equals("Home Page "))
			{
				continue;
			}
			String unique[]=content[1].split(",");	
			if(unique.length>=2)
			{
				if (unique[1].equals(" Home Page "))
				{
					continue;
				}
			}
			
			if(unique.length>=3)
			{
				if (unique[2].equals(" Home Page "))
				{
					continue;
				}
			}
			
			if(unique.length>=4)
			{
				if (unique[3].equals(" Home Page "))
				{
					continue;
				}
			}
			if(unique.length>=5)
			{
				if (unique[4].equals(" Home Page "))
				{
					continue;
				}
			}

			bw.write(count+"\t"+content[1]);
			bw.newLine();
			count++;
						
		}
		
	
		SC.close();
		bw.close();
		
	}

}
