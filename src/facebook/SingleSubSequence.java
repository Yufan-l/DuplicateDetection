package facebook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class SingleSubSequence {
	
	public static void SSS()throws Exception
	{
		//int count=1;
		File file1 = new File("C:/substring_distibution.txt");
		if (!file1.exists()) {
			file1.createNewFile();
		}
		FileWriter fw1 = new FileWriter(file1.getAbsoluteFile());
		final BufferedWriter bw1 = new BufferedWriter(fw1);
		
		Scanner SC=new Scanner(new FileReader("H:/train/substring_name.txt"));	
		Scanner SC1=new Scanner(new FileReader("H:/train/SubSequence.txt"));	
		Scanner SC2=new Scanner(new FileReader("H:/train/full_name.txt"));	
		
		HashMap<String, ArrayList<String> > output=new HashMap<String, ArrayList<String> >();
		HashSet<String> HS=new HashSet<String>();
		
		while(SC2.hasNext())
		{
			String tmp=SC2.nextLine();
			HS.add(tmp);
		}
		
		
		
		while(SC.hasNext())
		{
			String tmp=SC.nextLine();
			ArrayList<String> A1=new ArrayList<String>();
			output.put(tmp, A1);
			//count++;
		}
		System.out.println(output.size());
		while(SC1.hasNext())
		{
			String tmp=SC1.nextLine();
			String content[]=tmp.split("\t");
			ArrayList<String> A1=output.get(content[1]);
			if(HS.contains(content[0]))
			{
				A1.add(content[0]+"\t"+content[2]);
			}
			output.put(content[1], A1);
		}
		
		for(String s1:output.keySet())
		{
			
			/*if(output.get(s1).size()==2)
			{
				bw1.write(s1+"\t");
				bw1.write(output.get(s1).get(0));
				bw1.write(output.get(s1).get(1));
				bw1.newLine();
			}*/
			bw1.write(s1+"\t");
			for(String s2: output.get(s1))
			{
				bw1.write(s2+"\t");
			}
			bw1.newLine();
			
		
		}
		
		SC.close();
		SC1.close();
		SC2.close();
		bw1.close();
	}
	
	public static void main(String args[])throws Exception
	{
		SSS();
	}
}


